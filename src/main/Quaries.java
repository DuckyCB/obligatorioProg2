package main;

import entities.Book;
import entities.Rating;
import entities.Tuple;
import entities.User;
import exceptions.EmptyQueueException;
import exceptions.InvalidInformationException;
import sortingAlgorithms.Sort;
import tads.nodes.Node;
import tads.nodes.NodeBT;
import tads.implementations.*;
import tads.nodes.HashNode;
import utils.Functions;

import java.text.DecimalFormat;
import java.util.Iterator;

public class Quaries {

	private static ClosedHash<Long, Book> books = UploadData.getBooks();
	private static ClosedHash<Long, User> users = UploadData.getUsers();

	public static void top10Books() {
		/* Tomando en cuenta los libros y las reservas que los usuarios pueden
		realizar sobre los mismos, indicar el Top 10 de los libros que más reservas
		tienen por parte de usuarios.
		Datos esperados del resultado:
		- Id del libro
		- Titulo
		- Cantidad */

		HeapImp<Integer, User> topTen = new HeapImp<>(100000, 1);
		//	vas a ahcer un heap y cada vez qeu aprece el libro le sumas uno a la key

		for (User user: users) {

			//topTen.insert(user.);

		}

		for (int i = 0; i < 10; i++) {



		}


	}

	public static void top20Books() {
		/* Nuevamente considerando los libros pero ahora considerando las
		evaluaciones recibidas por sus usuario, se deberá hacer un listado de los
		Top 20 de libros que más cantidad de evaluaciones recibieron (independiente
		del puntaje).
		Datos esperados del resultado:
		- Id del libro
		- Titulo
		- Cantidad */

		// tengo en books y users todos los books y users

		NodeBT<Integer, Book>[] booksWRating= new NodeBT[ books.getSize()]; // donde se guardaran los libros

		Iterator<Book> itBook= books.iterator();

		Book toCompare= itBook.next();

		while(itBook.hasNext()){

			boolean found=false;

			int times = -1; // cant de reseñas de toCompare, empieza en -1 para que no cuente la misma dos veces

			int pos=-1; // posicion a guardar en el vector!

			Iterator<User> itUsers= users.iterator();

			User user=itUsers.next();

			while (itUsers.hasNext()){

				QueueLinkedList<Rating> ratings= user.getRatings(); // todos los ratings

				for(int i=0; i< ratings.size(); i++){

					Book ratingBook = ratings.dequeue().getBook(); // con queue linked list no se me rompe?

					if(ratingBook.getBook_id()== toCompare.getBook_id()){

						times=times+1;

						found=true;

					}

				}

				user=itUsers.next();

				if(found==true && times!=0){
					NodeBT<Integer, Book> toAdd=  new NodeBT<>(times, toCompare);

					booksWRating[pos+1]= toAdd;
				}else{
					NodeBT<Integer, Book> toAdd=  new NodeBT<>(0, toCompare);

					booksWRating[pos+1]= toAdd;
				}

				toCompare= itBook.next();

			}

			Sort<NodeBT<Integer,Book>> toSort= new Sort<>();

			toSort.quicksort(booksWRating);

			int posToPrint= booksWRating.length;

			for(int i= 0; i<10; i++){

				System.out.println("Id del libro: "+ booksWRating[posToPrint-1].getData().getBook_id());

				System.out.println("Titulo: "+ booksWRating[posToPrint-1].getData().getOriginal_title());

				System.out.println("Cantidad: " + booksWRating[posToPrint-1].getKey());

				posToPrint=posToPrint-1;
			}

		}

	}

	public static void top10Users() {
		/* Obtener el Top 10 de usuarios que realizaron mayor cantidad de
		evaluaciones a libros y ordenarlo por rating promedio descendente. La
		idea de esta consulta es saber los 10 usuarios que han hecho más puntuaciones
		sobre libros y de esos 10, mostrarlos de manera que se ordene primero por
		aquellos que tienen mayor rating y finalizando con aquellos que tienen menor.
		Datos esperados del resultado:
		- Id del usuario
		- Cantidad
		- Rating promedio */

		HeapImp<Integer, User> top = new HeapImp<>(100000, 1);

		for (User user: users) {

			top.insert(user.getRatings().size(), user);

		}

		Tuple<Float, User>[] topRatings = new Tuple[10];

		for (int i = 0; i < 10; i++) {

			User userTemp = top.deleteAndReturn().getData();
			float average = Functions.linkedListAverage(userTemp.getRatings());
			topRatings[0] = new Tuple(average, top.deleteAndReturn());

		}

		// Tiene que ordenar el topRating usando topRating[i].getKey() como valor
		// Sort.quicksort(topRatings);
		// No anda el quicksort

		for (int i = 0; i < 10; i++) {

			User userTemp = topRatings[i].getValue();
			System.out.println("ID del usuario: " + userTemp.getUser_id());
			System.out.println("Cantidad: " + userTemp.getRatings().size());
			DecimalFormat decimalFormat = new DecimalFormat("#.##");
			System.out.println("Rating promedio" + decimalFormat.format(topRatings[i].getKey()));

		}

	}

	public static void top5Language() {
		/* Indicar el Top 5 de los idiomas con más reservas. Tener en cuenta que
		un libro tiene asociado un idioma y se deben contabilizar las reservas
		realizadas. Por ejemplo, si tenemos un libro en español que tiene 5
		reservas debe contabilizar 5 veces en el resultado. Se debe tener en cuenta
		que no todos libros tienen idioma y que el idioma ingles aparece escrito de
		varias formas, ejemplo en-CA y en-GB pero debe contabilizarse como uno
		solo (eng).
		Datos esperados del resultado:
		- Codigo del idioma
		- Cantidad */

		// Verificar que no se guarde el nan
		Tuple<Integer, String>[] topRatings = Functions.createLangArray();

		for (User user: users) {

			QueueLinkedList<Book> list = user.getReservations();
			for (int n = 0; n < list.size(); n++) {

				try {

					Book book = list.dequeue();
					Functions.addToLangage(book.getLanguage_code(), topRatings);
					list.enqueue(book);

				} catch (EmptyQueueException e) {
					e.printStackTrace();
				}

			}

		}

		// Ordenar array de tuplas
		// Sort.quicksort(topRatings);

		for (int i = 0; i < 5; i++) {

			System.out.println("Codigo del idioma: " + topRatings[i].getValue());
			System.out.println("Cantidad: " + topRatings[i].getKey());

		}

	}

	public static void top20Authors() {
		/* Indicar el Top 20 de autores que más publicaciones han hecho por año. De
		esta manera se mostrarán los autores que más libros han hecho y cuál fue
		la cantidad asociada. Como los autores pueden escribir libros todos los
		años, puede pasar que un mismo autor aparezca varias veces en el listado
		para años distintos. Se debe tener en cuenta que no todos los libros tienen
		un fecha de publicación.
		Datos esperados del resultado:
		- Autor
		- Año de publicacion
		- Cantidad */

		System.out.println("Esta es una pregunta filosofica, puede tener muchas respuestas");

		Tuple<Integer, Tuple<String, Integer>>[] topRatings = new Tuple[20];

		for (int i = 0; i < 20; i++) {



		}

	}

}
