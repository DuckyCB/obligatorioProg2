package main;

import entities.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Menu {

	public static void mainMenu() {

		System.out.println("Seleccione la opción que desee :\n");
		System.out.println(" 1. Carga de datos");
		System.out.println(" 2. Ejecutar consultas");
		System.out.println(" 3. Salir\n");

		Scanner myObj = new Scanner(System.in);
		System.out.print("Opción : ");
		String option = myObj.nextLine();

		switch (option) {
			case "1":

				loadData();

				break;
			case "2":

				runQueries();

				break;
			case "3":

				System.exit(0);

			default:

				System.out.println(" *** Entrada invalida *** \n");
				mainMenu();
				
				break;
		}

	}

	private static void loadData() {

		double start = System.nanoTime() / 1000000;

		List<Book> books = readBooksFromCSV("D:/Documentos/GitHub/obligatorioProg2/src/books.txt");

		double elapsedTime = System.nanoTime() / 1000000 - start;
		System.out.print("Carga de datos exitosa, tiempo de ejecución de la carga : ");
		System.out.println(elapsedTime);

	}

	private static List<Book> readBooksFromCSV(String fileName) {

		List<Book> books = new LinkedList<>();
		Path pathToFile = Paths.get(fileName);

		// create an instance of BufferedReader
		// using try with resource, Java 7 feature to close resources
		try (BufferedReader br = Files.newBufferedReader(pathToFile)) {

			// read the first line from the text file
			String line = br.readLine();
			line = br.readLine();
			// loop until all lines are read


			while (line != null) {

				// use string.split to load a string array with the values from
				// each line of
				// the file, using a comma as the delimiter
				String[] attributes = line.split(",");
				attributes[1] = attributes[1].substring(1, attributes[1].length()-1);
				attributes[1] = attributes[1].substring(1, attributes[1].length()-1);

				Book book = new Book(attributes[1], attributes[2], attributes[3], attributes[4], attributes[5], attributes[6], attributes[7]);

				// adding book into ArrayList
				books.add(book);

				// read next line before looping
				// if end of file reached, line would be null
				line = br.readLine();

			}

		} catch (IOException ioe) {

			ioe.printStackTrace();

		}

		return books;

	}

	private static void runQueries() {

		System.out.println("Seleccione la opción que desee :\n");
		System.out.println(" 1. Indicar el Top 10 de libros que más lecturas tienen por parte de usuarios.");
		System.out.println(" 2. Indicar el Top 20 de libros que más cantidad de lecturas tienen.");
		System.out.println(" 3. Indicar el Top 10 de usuarios que realizaron mayor cantidad de\n" +
				"evaluaciones a libros y ordenarlo por rating promedio descendente");
		System.out.println(" 4. Indicar el Top 5 de los idiomas asociados a libros que han tenido más\n" +
				"reservas.");
		System.out.println(" 5. Indicar el Top 20 de autores que más publicaciones han hecho por año.");
		System.out.println(" 6. Salir.");

		Scanner myObj = new Scanner(System.in);
		System.out.print("Opción : ");
		String option = myObj.nextLine();

		switch (option) {

			case "1":

				Quaries.top10Books();

				break;
			case "2":

				Quaries.top20Books();

				break;
			case "3":

				Quaries.top10Users();

				break;
			case "4":

				Quaries.top5Language();

				break;
			case "5":

				Quaries.top20Authors();

				break;
			case "6":

				Menu.mainMenu();

				break;
			default:

				System.out.println("Entrada inválida");
				runQueries();

				break;

		}

	}

}
