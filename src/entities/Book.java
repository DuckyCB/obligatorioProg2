package entities;

public class Book {

	String book_id;
	String isbn;
	String original_publication_year;
	String original_title;
	String title;
	String language_code;
	String image_url;

	public Book(String book_id, String isbn, String original_publication_year, String original_title, String title, String language_code, String image_url) {
		this.book_id = book_id;
		this.isbn = isbn;
		this.original_publication_year = original_publication_year;
		this.original_title = original_title;
		this.title = title;
		this.language_code = language_code;
		this.image_url = image_url;
	}
}
