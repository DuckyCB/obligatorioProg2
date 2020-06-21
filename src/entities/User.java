package entities;

import tads.implementations.LinkedList;

public class User {

	private long user_id;
	private LinkedList<Rating> ratings;
	private LinkedList<Book> reservations;

	public User(long user_id) {

		this.user_id = user_id;
		this.ratings = new LinkedList<>();
		this.reservations = new LinkedList<>();

	}
}
