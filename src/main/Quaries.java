package main;

import dataBase.DataBase;
import entities.*;
import sortingAlgorithms.Sort;
import tads.implementations.*;
import utils.Functions;

import java.text.DecimalFormat;

public class Quaries {

	private static ClosedHash<Long, Book> books = DataBase.books;
	private static ClosedHash<Long, User> users = DataBase.users;
	private static ClosedHash<Integer, Author> authors = DataBase.authors;
	private static ClosedHash<Integer, Rating> ratings = DataBase.ratings;

	public static void top10Books() {
		/* Tomando en cuenta los libros y las reservas que los usuarios pueden
		realizar sobre los mismos, indicar el Top 10 de los libros que más reservas
		tienen por parte de usuarios.
		Datos esperados del resultado:
		- Id del libro
		- Titulo
		- Cantidad */

		int size = books.getSize();
		Tuple<Integer, Book>[] booksReservation = new Tuple[size];

		int i=0;

		for(Book book: books) {

			booksReservation[i]	= new Tuple<>(book.getReservation().size(), book);
			i++;

		}

		Sort.quicksort(booksReservation);

		for (int n = 1; n < 11; n++) {

			System.out.println("Id del libro: " + booksReservation[size-n].getValue().getBook_id());
			System.out.println("Titulo: " + booksReservation[size-n].getValue().getTitle());
			System.out.println("Cantidad: " + booksReservation[size-n].getKey() + "\n");

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

		int size = books.getSize();
		Tuple<Integer, Book>[] booksWRating = new Tuple[size];

		int i=0;

		for(Book book: books){

			booksWRating[i]	= new Tuple<>(book.getRatings().size(), book);
			i++;

		}

		Sort.quicksort(booksWRating);

		for (int n = 1; n < 21 ; n++){

			System.out.println("Id del libro: " + booksWRating[size-n].getValue().getBook_id());
			System.out.println("Titulo: " + booksWRating[size-n].getValue().getTitle());
			System.out.println("Cantidad: " + booksWRating[size-n].getKey() + "\n");

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

		// HeapImp<Integer, User> top = new HeapImp<>(100000, 1);
		Tuple<Float, User>[] topUsers = new Tuple[users.getSize()];

		int i = 0;


		for (User user : users) {

			// top.insert(user.getRatings().size(), user);
			if(user.getRatings()==null){
				topUsers[i] = new Tuple(0, user);
			}else {
				topUsers[i] = new Tuple(user.getRatings().size(), user);
			}
			i++;
		}



		Sort.quicksort(topUsers);

		Tuple<Float, User>[] topRatings = new Tuple[10];

		for (int n = 1; n < 11; n++) {

			User userTemp = topUsers[topUsers.length - n].getValue();
			float average = Functions.linkedListAverage(userTemp.getRatings());
			topRatings[n-1] = new Tuple(average, userTemp);

		}

		Sort.quicksort(topRatings);

		for (int n = 9; n >= 0; n--) {

			User userTemp = topRatings[n].getValue();
			System.out.println("ID del usuario: " + userTemp.getUser_id());
			System.out.println("Cantidad: " + userTemp.getRatings().size());
			DecimalFormat decimalFormat = new DecimalFormat("#.##");
			System.out.println("Rating promedio" + decimalFormat.format(topRatings[i].getKey()) + "\n");

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

		Tuple<Integer, String>[] topRatings = Functions.createLangArray();

		/*for (User user : users) {

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

		}*/

		for (Book book: books) {

			Functions.addToLanguage(book.getLanguage_code(), topRatings, book.getReservation().size());

		}

		Sort.quicksort(topRatings);

		for (int i = 20; i > 15; i--) {

			System.out.println("Codigo del idioma: " + topRatings[i].getValue());
			System.out.println("Cantidad: " + topRatings[i].getKey() + "\n");

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

		QueueLinkedList<Tuple<Integer, Author>> forYear= new QueueLinkedList();

		int totalSize=0; // me va a dar un mega vector

		for (Book book:books){

			//String[] allAuthors= book.getAuthors();// mal los autores?




		}

		//

		HeapImp<Integer, User> top = new HeapImp<>(100000, 1);
		ClosedHash<String, Tuple<Integer, Integer>> authors = new ClosedHash<>(20000);

		for (Book book: books) {

			for (int i = 0; i < book.getAuthors().length; i++) {

				//try {

					//authors.put(book.getAuthors()[i].getName(), new Tuple<>());

				//} catch (Exception e) {

				//}

			}

		}

		Tuple<Integer, Tuple<String, Integer>>[] topRatings = new Tuple[20];

		//Sort.quicksort(topRatings);

		for (int i = 0; i < 20; i++) {


		}

	}

}
