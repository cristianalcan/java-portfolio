package aplication;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JList;

import component.ButtonPanel;
import component.DataPanel;
import component.StatusBarPanel;
import model.Book;

public class ApplicationView extends JFrame {
	// No ponemos los componentes como private debido a que en ApplicationController
	// tendremos que acceder a estos componentes
	StatusBarPanel statusBarPanel;
	ButtonPanel buttonPanel;
	DataPanel dataPanel;
	JList<Book> bookList;

	public ApplicationView() {
		super("Book Manager");// Este sera el titulo de nuestra ventana
		initComponents();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initComponents() {
		// Nuestra ventana tendra un diseño de BorderLayout
		setLayout(new BorderLayout());

		statusBarPanel = new StatusBarPanel();
		buttonPanel = new ButtonPanel();
		dataPanel = new DataPanel();
		bookList = new JList<>();
		getContentPane().add(statusBarPanel, BorderLayout.SOUTH);// Aqui añadimos nuestro StatusBarPanel a nuestra
																	// ventana y sera en la posicion del sur(Abajo)
		getContentPane().add(buttonPanel, BorderLayout.NORTH);
		getContentPane().add(dataPanel, BorderLayout.CENTER);
		getContentPane().add(bookList, BorderLayout.EAST);
	}
}
