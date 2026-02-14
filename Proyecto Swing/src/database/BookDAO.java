package database;

import java.util.ArrayList;
import java.util.List;

import model.Book;

/**
 * Recordemos que los DAO es basicamente una clase genérica para que podamos
 * acceder a cualquier gestor de bases de datos
 * 
 * @author crist
 *
 */
public class BookDAO {
	private List<Book> books;

	public BookDAO() {
		books = new ArrayList<>();
		books.add(new Book("El Quijote"));
		books.add(new Book("Secuestrado"));
		books.add(new Book("La isla del tesoro"));
	}

	public List<Book> getAllBooks() {
		return books;
	}

	public List<Book> searchBooks(String title) {
		return null;
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public void modifyBook(Book book) {

	}

	public void deleteBook(Book book) {
		books.remove(book);
	}
}
