package entities;

import tads.implementations.QueueLinkedList;

public class User {

	private long user_id;
	private QueueLinkedList<Integer> ratings;
	private QueueLinkedList<Book> reservations;

	public User(long user_id) {

		this.user_id = user_id;
		this.ratings = new QueueLinkedList<>();
		this.reservations = new QueueLinkedList<>();

	}

	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public QueueLinkedList<Integer> getRatings() {
		return ratings;
	}
	public void setRatings(QueueLinkedList<Integer> ratings) {
		this.ratings = ratings;
	}

	public QueueLinkedList<Book> getReservations() {
		return reservations;
	}
	public void setReservations(QueueLinkedList<Book> reservations) {
		this.reservations = reservations;
	}

}
