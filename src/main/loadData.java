package main;

import entities.Author;
import entities.Book;
import exceptions.FullHashException;
import exceptions.InvalidInformationException;
import tads.implementations.ClosedHash;
import tads.implementations.OpenHash;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class loadData {

	private static ClosedHash<Integer, Book> books = new ClosedHash<>(10001);
	private static OpenHash<Integer, Author> authors = new OpenHash<>(26); // Letras abecedario

	public static void timeDataLoad() {

		double startTime = System.currentTimeMillis();

		readBooksFromCSV("books.csv");
		readBooksFromCSV("ratings.csv");
		readBooksFromCSV("to_read.csv");

		double elapsedTime = System.currentTimeMillis() - startTime;
		System.out.print("Carga de datos exitosa, tiempo de ejecución de la carga : " + elapsedTime);

	}

	// Carga con Buffer
	private static void readBooksFromCSV(String fileName) {

		try ( BufferedReader br = Files.newBufferedReader(Paths.get(fileName)) ) {

			String line = br.readLine();

			while (line != null) {

				String[] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
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
				// Falta agregar un hash o algo de autores

				try {

					books.put(Integer.parseInt(attributes[0]), book);

				} catch (FullHashException e) { // Creo que falta otra exception

					e.printStackTrace();

				}

				line = br.readLine();

			}

		} catch (IOException | InvalidInformationException ioe) {

			ioe.printStackTrace();

		}

	}

}
