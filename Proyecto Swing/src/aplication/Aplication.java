package aplication;

import database.BookDAO;

public class Aplication {

	public static void main(String[] args) {
		ApplicationView view = new ApplicationView();
		BookDAO model = new BookDAO();
		ApplicationController controller = new ApplicationController(view, model);
	}

}
