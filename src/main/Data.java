package main;

import entities.Author;
import entities.Book;
import entities.Rating;
import entities.User;
import exceptions.FullHashException;
import exceptions.InvalidInformationException;
import exceptions.KeyNotFoundException;
import tads.implementations.ClosedHash;
import tads.implementations.OpenHash;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Data {

	private static ClosedHash<Integer, Book> books = new ClosedHash<>(10001);
	private static OpenHash<Integer, Author> authors = new OpenHash<>(26); // Letras abecedario
	private static ClosedHash<String, Rating> ratings = new ClosedHash<>(6000000);
	private static OpenHash<Integer, User> users = new OpenHash<>(50000);

	public static void timeDataLoad() {

		double startTime = System.currentTimeMillis();

		readFromCSV("books.csv", "book");
		readFromCSV("ratings.csv", "rating");
		readFromCSV("to_read.csv", "toread");

		double elapsedTime = System.currentTimeMillis() - startTime;
		System.out.print("Carga de datos exitosa, tiempo de ejecución de la carga : " + elapsedTime);

	}

	public static ClosedHash<Integer, Book> getBooks() {
		return books;
	}

	public static OpenHash<Integer, Author> getAuthors() {
		return authors;
	}

	public static ClosedHash<String, Rating> getRatings() {
		return ratings;
	}


	private static void readFromCSV(String fileName, String entitie) {

		try ( BufferedReader br = Files.newBufferedReader(Paths.get(fileName)) ) {

			String line = br.readLine();

			while (line != null) {

				String[] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

				switch (entitie) {
					case "book":
						saveBook(attributes);
						break;

					case "rating":
						saveRating(attributes);
						break;

					case "toread":
						saveToRead(attributes);
						break;

					default:

				}

				line = br.readLine();

			}

		} catch (IOException ioe) {

			ioe.printStackTrace();

		}

	}

	private static void saveBook(String[] attributes) {

		int n = attributes.length;
		Author[] authorsArray = new Author[n-7];

		for (int i = 0; i < n - 7; i++) {

			Author newAuthor = new Author(attributes[2+i]);

			// Agregar autores en alguna estructura

		}

		Book book = new Book( Long.parseLong(attributes[0]), attributes[1], authorsArray,
				Integer.parseInt(attributes[n-5]), attributes[n-4], attributes[n-3], attributes[n-2],
				attributes[n-1]);

		// Verificar que el autor no este repetido
		// Agregar libro a la lista de libros del autor
		// Author author = new Author();

		try {

			books.put(Integer.parseInt(attributes[0]), book);

		} catch (FullHashException e) { // Creo que falta otra exception

			e.printStackTrace();

		}

	}

	private static void saveRating(String[] attributes) {

		try {
			Book book = books.get(Integer.parseInt(attributes[2]));
		} catch (KeyNotFoundException | InvalidInformationException e) {
			System.out.println("No se encontro libro con esa key");
		}

		Rating newRating = new Rating(attributes[1], book);

		try {

			ratings.put(Integer.parseInt(attributes[0]), newUser);

		} catch (KeyNotFoundException e) {

			e.printStackTrace();

		} catch (InvalidInformationException e) {

			e.printStackTrace();

		}

	}

	private static void saveToRead(String[] attributes) {



	}

}
