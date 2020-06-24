package entities;

import tads.implementations.QueueLinkedList;

public class Book{

	private long book_id;
	private String isbn;
	private int[] authors;
	private QueueLinkedList<User> reservation;
	private QueueLinkedList<Integer> ratings;
	private int original_publication_year;
	private String original_title;
	private String title;
	private String language_code;
	private String image_url;

	public Book(long book_id, String isbn, int[] authors, int original_publication_year,
				String original_title, String title, String language_code, String image_url) {

		this.book_id = book_id;
		this.isbn = isbn;
		this.authors = authors;
		this.reservation = new QueueLinkedList<>();
		this.ratings = new QueueLinkedList<>();
		this.original_publication_year = original_publication_year;
		this.original_title = original_title;
		this.title = title;
		this.language_code = language_code;
		this.image_url = image_url;

	}

	public long getBook_id() {
		return book_id;
	}
	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int[] getAuthors() {
		return authors;
	}
	public void setAuthors(int[] authors) {
		this.authors = authors;
	}

	public QueueLinkedList<User> getReservation() {
		return reservation;
	}
	public void setReservation(QueueLinkedList<User> reservation) {
		this.reservation = reservation;
	}

	public QueueLinkedList<Integer> getRatings() {
		return ratings;
	}
	public void setRatings(QueueLinkedList<Integer> ratings) {
		this.ratings = ratings;
	}

	public int getOriginal_publication_year() {
		return original_publication_year;
	}
	public void setOriginal_publication_year(int original_publication_year) {
		this.original_publication_year = original_publication_year;
	}

	public String getOriginal_title() {
		return original_title;
	}
	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage_code() {
		return language_code;
	}
	public void setLanguage_code(String language_code) {
		this.language_code = language_code;
	}

	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
}
