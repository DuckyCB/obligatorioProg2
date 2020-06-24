package main;

import entities.Book;
import entities.Rating;
import entities.Tuple;
import entities.User;
import exceptions.EmptyQueueException;
import exceptions.InvalidInformationException;
import sortingAlgorithms.Sort;
import tads.nodes.HashEntry;
import tads.nodes.Node;
import tads.nodes.NodeBT;
import tads.implementations.*;
import tads.nodes.HashNode;
import tads.nodes.NodeHeap;
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

		NodeBT<Integer, Book>[] booksReservation= new NodeBT[books.getSize()];

		int i=0;

		for(Book book: books) {

			int reservas= book.getReservationUsers().size();

			 NodeBT<Integer, Book> toAdd= new NodeBT<>(reservas,book);

			booksReservation[i]	= toAdd;

			i++;

		}
		Sort<NodeBT<Integer,Book>> toSort= new Sort<>();

		toSort.quicksort(booksReservation);

		int posToPrint= booksReservation.length;

		int j=0;

		while( j<10){

			System.out.println("Id del libro: "+ booksReservation[posToPrint-1].getData().getBook_id());

			System.out.println("Titulo: "+ booksReservation[posToPrint-1].getData().getOriginal_title());

			System.out.println("Cantidad: " + booksReservation[posToPrint-1].getKey());

			posToPrint=posToPrint-1;

			j++;

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

		NodeBT<Integer, Book>[] booksWRating= new NodeBT[books.getSize()];

		int i=0;

		for(Book book: books){

			int ratings= book.getRankedUsers().size();

			NodeBT<Integer, Book> toAdd= new NodeBT<>(ratings,book);

			booksWRating[i]	= toAdd;

			i++;

		}

		Sort<NodeBT<Integer,Book>> toSort= new Sort<>();

		toSort.quicksort(booksWRating);

		int posToPrint= booksWRating.length;

		for(int j= 0; j<10; j++){

			System.out.println("Id del libro: "+ booksWRating[posToPrint-1].getData().getBook_id());

			System.out.println("Titulo: "+ booksWRating[posToPrint-1].getData().getOriginal_title());

			System.out.println("Cantidad: " + booksWRating[posToPrint-1].getKey());

			posToPrint=posToPrint-1;
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

		for (User user : users) {

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

		for (User user : users) {

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

		HeapImp<Integer, User> top = new HeapImp<>(100000, 1);

		for (User user : users) {


		}

		Tuple<Integer, Tuple<String, Integer>>[] topRatings = new Tuple[20];

		//Sort.quicksort(topRatings);

		for (int i = 0; i < 20; i++) {


		}

	}

}
