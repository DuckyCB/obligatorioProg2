package entities;

public class AuthorYear {

	private int year;
	private Author author;

	public AuthorYear(int year, Author author) {

		this.year = year;
		this.author = author;

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public int hashCode() {

		return author.getName().length() + Math.abs(year);

	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof AuthorYear) {

			return author.getName().equals(((AuthorYear) obj).author.getName()) && year == ((AuthorYear) obj).year;

		}

		return false;

	}
}
