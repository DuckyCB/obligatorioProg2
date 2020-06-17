package main;

import entities.Author;
import entities.Book;
import exceptions.InvalidInformationException;
import tads.implementations.OpenHash;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class loadData {

	public static void timeDataLoad() {

		double startTime = System.currentTimeMillis();

		OpenHash<Integer, Book> books = readBooksFromCSV("books.csv");
		OpenHash<Integer, Book> ratings = readBooksFromCSV("ratings.csv");
		OpenHash<Integer, Book> to_read = readBooksFromCSV("to_read.csv");

		double elapsedTime = System.currentTimeMillis() - startTime;
		System.out.print("Carga de datos exitosa, tiempo de ejecución de la carga : " + elapsedTime);

	}

	// Carga con Buffer
	private static OpenHash<Integer, Book> readBooksFromCSV(String fileName) {

		OpenHash<Integer, Book> books = new OpenHash<>(100000); // Cambiar este valor luego

		try ( BufferedReader br = Files.newBufferedReader(Paths.get(fileName)) ) {

			String line = br.readLine();

			while (line != null) {

				String[] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
				int n = attributes.length;
				Book book = new Book( Long.parseLong(attributes[0]), attributes[1],
						Integer.parseInt(attributes[n-5]), attributes[n-4], attributes[n-3], attributes[n-2],
						attributes[n-1]);
				// Verificar que el autor no este repetido
				// Agregar libro a la lista de libros del autor
				// Author author = new Author();
				// Falta agregar un hash o algo de autores
				books.put(Integer.parseInt(attributes[0]), book);

				line = br.readLine();

			}

		} catch (IOException | InvalidInformationException ioe) {

			ioe.printStackTrace();

		}

		return books;

	}

}
