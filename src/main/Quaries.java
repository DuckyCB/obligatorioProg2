package main;

import entities.Book;
import entities.Tuple;
import entities.User;
import sortingAlgorithms.Sort;
import tads.implementations.*;
import tads.nodes.HashNode;
import tads.nodes.NodeHeap;
import utils.Functions;

import java.text.DecimalFormat;

public class Quaries {

	private static ClosedHash<Long, Book> books = UploadData.getBooks();
	private static OpenHash<Long, User> users = UploadData.getUsers();

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
		HashNode<Long, Book>[] temp = books.getHash();

		Comparable<Integer>[] size = new Comparable[150000];
		Heap<Integer> topBooks = new Heap(size, true);

		for (HashNode<Long, Book> bookNode : temp) {

			if (bookNode != null) {

				//topBooks.insert(bookNode.getValue());
				// Completar esto

			}

		}

		//Pato no quise sobreescribir sobre lo que hiciste, pero habia pensado que la parte uno podía ser como la parte dos
		// pero en vez de comparar respecto a los rating, compararlos con las reservas


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

		OpenHash<Long, User> allUsers = UploadData.getUsers(); //all users

		ClosedHash<Long, Book> booksByRating= UploadData.getBooks(); //all books

		HashNode<Integer, Book>[] booksWRating= new HashNode[ booksByRating.getSize()]; // donde se guardaran los libros

		for (int i=0; i<allUsers.getSize(); i++){

			while(booksByRating.hasNext()){

				HashNode<Long, Book> toCompare= booksByRating.next();

				boolean found=false;

				int times = -1; // cant de reseñas de toCompare, empieza en -1 para que no cuente la misma dos veces

				//puede ser que los usuarios tmb sean closed Hush, o un heap?
				// hago:
				// ClosedHash<Long, User> allUsers=UploadData.getUsers();
				// Book withReview= booksByRating.next();
				// while (booksByRating.hasNext()){
				//		if (withReview.getId.compareTo(toCompare.getValue().getId)==0 ){ o hago un compare to en book no se
				//			times=times+1;
				//			found=true
				//		}
				//
			// }
			// if(found==true && times!=0){
			// 		HashNode<Integer, Book> toAdd=  new HashNode(times, toCompare.getValue());
			// }else{
			// 		HashNode<Integer, Book> toAdd=  new HashNode(0, toCompare.getValue());
			// }
			//	booksWRating[i]= toAdd;

			}

			//como los ordeno!!! adaptar bublesort a nodos (no lo arreglo porque estoy cansada)!!!!

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

		HeapImp<Integer, User> topTen = new HeapImp<>(100000, 1);
		// Recorrer usuarios
		User user = new User(123); // esto es solo para tener un usuario y que no me tire errores
	 	topTen.insert(user.getRatings().size(), user);

		Tuple<Float, User>[] topRatings = new Tuple[10];

		for (int i = 0; i < 10; i++) {

			User userTemp = topTen.deleteAndReturn().getData();
			float average = Functions.linkedListAverage(userTemp.getRatings());
			topRatings[0] = new Tuple(average, topTen.deleteAndReturn());

		}

		// Tiene que ordenar el topRating usando topRating[i].getKey() como valor
		Sort.quicksort(topRatings);
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
		- Cantidad
		 */


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


	}

}
