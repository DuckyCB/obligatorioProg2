package entities;

public class Book{

	long book_id;
	String isbn;
	Author[] authors;
	int original_publication_year;
	String original_title;
	String title;
	String language_code;
	String image_url;

	public Book(long book_id, String isbn, Author[] authors, int original_publication_year,
				String original_title, String title, String language_code, String image_url) {

		this.book_id = book_id;
		this.isbn = isbn;
		this.authors = authors;
		this.original_publication_year = original_publication_year;
		this.original_title = original_title;
		this.title = title;
		this.language_code = language_code;
		this.image_url = image_url;

	}

}
