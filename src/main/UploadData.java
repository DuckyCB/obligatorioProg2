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

public class UploadData {

	private static ClosedHash<Long, Book> books = new ClosedHash<>(10001);
	private static ClosedHash<Long, User> users = new ClosedHash<>(50000);

	public static void timeDataLoad() {

		long startTime = System.currentTimeMillis();

		System.out.println("Read books");
		readFromCSV("books.csv");
		System.out.println("Read ratings");
		readFromCSV("ratings.csv");
		System.out.println("Read to read");
		readFromCSV("to_read.csv");

		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.print("Carga de datos exitosa, tiempo de ejecución de la carga : " + elapsedTime);

		// ESTO PUEDE HACER EXPLOTAR TOD0
		System.gc();

	}

	public static ClosedHash<Long, Book> getBooks() {
		return books;
	}

	public static ClosedHash<Long, User> getUsers() {
		return users;
	}


	private static void readFromCSV(String fileName) {

		try ( BufferedReader br = Files.newBufferedReader(Paths.get(fileName)) ) {

			String line = br.readLine();
			line = br.readLine();

			while (line != null) {

				String[] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

				switch (fileName) {

					case "books.csv":
							saveBook(attributes);
						break;

					case "ratings.csv":
						saveRating(attributes);
						break;

					case "to_read.csv":
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

		// if (! (line.contains(",\"nan\"") || line.contains(",NaN") ||
		//								line.contains(",nan"))) {

		int n = attributes.length;

		Author[] authorsArray = new Author[n - 7];

		for (int i = 0; i < n - 7; i++) {

			Author newAuthor = new Author(attributes[2 + i]);
			authorsArray[i] = newAuthor;

		}

		Book book;

		try {
			book = new Book(Long.parseLong(attributes[0]), attributes[1], authorsArray,
					Integer.parseInt(attributes[n - 5]), attributes[n - 4], attributes[n - 3], attributes[n - 2],
					attributes[n - 1]);
		} catch (NumberFormatException e) {

			book = new Book(Long.parseLong(attributes[0]), attributes[1], authorsArray,
					0, attributes[n - 4], attributes[n - 3], attributes[n - 2],
					attributes[n - 1]);

		}
		try {

			books.put(Long.parseLong(attributes[0]), book);

		} catch (FullHashException e)  {

			System.out.println("El hash esta lleno");

		} catch (InvalidInformationException e) {

			System.out.println("Libro repetido");

		}

	}

	private static void saveRating(String[] attributes) {

		try {

			Rating newRating = new Rating(Integer.parseInt(attributes[1]),
					books.get(Long.parseLong(attributes[2])));
			users.put(Long.parseLong(attributes[0]), new User(Long.parseLong(attributes[0])));
			users.get(Long.parseLong(attributes[0])).getRatings().add(newRating);

		} catch (KeyNotFoundException | InvalidInformationException e) {

			System.out.println("Error");

		} catch (FullHashException e) {
			e.printStackTrace();
		}

	}

	private static void saveToRead(String[] attributes) {

		try {

		User user = users.get(Long.parseLong(attributes[0]));
		Book book = books.get(Long.parseLong(attributes[1]));
		user.getReservations().add(book);

		} catch (KeyNotFoundException | InvalidInformationException e) {
			e.printStackTrace();
		}

	}

}
