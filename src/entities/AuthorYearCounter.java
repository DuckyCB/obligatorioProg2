package entities;

public class AuthorYearCounter implements Comparable<AuthorYearCounter> {

	private int year;
	private int counter;
	private Author author;

	public AuthorYearCounter(int year, Author author) {
		this.year = year;
		this.author = author;
		this.counter = 1;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void incrementCounter() {

		counter++;

	}


	@Override
	public int compareTo(AuthorYearCounter o) {

		return Integer.compare(counter, o.counter);

	}
}
