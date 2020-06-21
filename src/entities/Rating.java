package entities;

public class Rating {

	private int rating;
	private User user;
	private Book book;

	public Rating(int rating, User user, Book book) {

		this.rating = rating;
		this.user = user;
		this.book = book;

	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
