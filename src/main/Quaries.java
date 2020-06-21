package main;

import entities.Book;
import tads.implementations.Heap;
import tads.nodes.HashNode;

public class Quaries {

	public static void top10Books() {
		/* Tomando en cuenta los libros y las reservas que los usuarios pueden
		realizar sobre los mismos, indicar el Top 10 de los libros que más reservas
		tienen por parte de usuarios.
		Datos esperados del resultado:
		- Id del libro
		- Titulo
		- Cantidad */

		HashNode<Integer, Book>[] temp = Data.getBooks().getHash();
		Comparable<Integer>[] size = new Comparable[150000];
		Heap<Integer> topBooks = new Heap(size, true);

		for (HashNode<Integer, Book> bookNode : temp) {

			if (bookNode != null) {

				//topBooks.insert(bookNode.getValue());
				// Completar esto

			}

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
		HashNode<Integer, Book>[] temp = Data.getBooks().getHash();



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
