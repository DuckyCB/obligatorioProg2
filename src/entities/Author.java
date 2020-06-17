package entities;

import tads.implementations.LinkedList;

public class Author<Books> {

	String name;
	LinkedList<Books> booksList;

	public Author(String name, LinkedList<Books> booksList) {
		this.name = name;
		this.booksList = booksList;
	}

}
