package model;

public class Book {
	private int id;
	private String title;
	private String description;
	private String author;
	private int pageCount;

	public Book(String title) {
		this.title = title;
	}

	public Book(String title, String description, String author, int pageCount) {
		super();
		this.title = title;
		this.description = description;
		this.author = author;
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		return title;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getAuthor() {
		return author;
	}

	public int getPageCount() {
		return pageCount;
	}

}
