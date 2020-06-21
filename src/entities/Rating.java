package entities;

public class Rating {

	private int rating;
	private Book book;

	public Rating(int rating, Book book) {

		this.rating = rating;
		this.book = book;

	}

	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
