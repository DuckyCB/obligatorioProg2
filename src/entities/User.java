package entities;

import tads.implementations.LinkedList;

public class User {

	private long user_id;
	private LinkedList<Rating> ratings; // Esto se podria cambiar por stack
	private LinkedList<Book> reservations;	// Esto se podria cambiar por stack

	public User(long user_id) {

		this.user_id = user_id;
		this.ratings = new LinkedList<>();
		this.reservations = new LinkedList<>();

	}

	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public LinkedList<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(LinkedList<Rating> ratings) {
		this.ratings = ratings;
	}

	public LinkedList<Book> getReservations() {
		return reservations;
	}
	public void setReservations(LinkedList<Book> reservations) {
		this.reservations = reservations;
	}
}
