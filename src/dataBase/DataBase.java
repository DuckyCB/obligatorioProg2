package dataBase;

import entities.Author;
import entities.Book;
import entities.Rating;
import entities.User;
import tads.implementations.ClosedHash;

public class DataBase {

	public static ClosedHash<Long, Book> books = new ClosedHash<>(10001);

	public static ClosedHash<Long, User> users = new ClosedHash<>(60000);
	// Hay tipo 52 000 autores
	public static ClosedHash<Integer, Author> authors = new ClosedHash<>(55000);

	public static ClosedHash<Integer, Rating> ratings = new ClosedHash<Integer, Rating>(5);

}
