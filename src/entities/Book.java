package entities;

import tads.implementations.QueueLinkedList;

public class Book{

	private long book_id;
	private String isbn;
	private Author[] authors;
	private QueueLinkedList<User> reservationUsers;
	private QueueLinkedList<User> rankedUsers;
	private int original_publication_year;
	private String original_title;
	private String title;
	private String language_code;
	private String image_url;

	public Book(long book_id, String isbn, Author[] authors, int original_publication_year,
				String original_title, String title, String language_code, String image_url) {

		this.book_id = book_id;
		this.isbn = isbn;
		this.authors = authors;
		this.reservationUsers = new QueueLinkedList<>();
		this.rankedUsers = new QueueLinkedList<>();
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

	public Author[] getAuthors() {
		return authors;
	}
	public void setAuthors(Author[] authors) {
		this.authors = authors;
	}

	public QueueLinkedList<User> getReservationUsers() {
		return reservationUsers;
	}
	public void setReservationUsers(QueueLinkedList<User> reservationUsers) {
		this.reservationUsers = reservationUsers;
	}

	public QueueLinkedList<User> getRankedUsers() {
		return rankedUsers;
	}
	public void setRankedUsers(QueueLinkedList<User> rankedUsers) {
		this.rankedUsers = rankedUsers;
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
