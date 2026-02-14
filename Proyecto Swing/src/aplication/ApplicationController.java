package aplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JOptionPane;

import database.BookDAO;
import model.Book;

/**
 * Esta clase será la que manejará todo de nuestra ventana
 * 
 * @author crist
 *
 */
public class ApplicationController implements ActionListener, KeyListener, MouseListener {
	private ApplicationView view;
	private BookDAO model;

	public ApplicationController(ApplicationView view, BookDAO model) {
		this.view = view;
		this.model = model;
		addActionListeners(this);// Aqui lo que hacemos es que si en algun momento queremos sacar fuera estos
									// metodos, pues que se puedan pasar por parametro los componentes que queremos
									// que produzcan eventos
		addKeyListeners(this);
		addMouseListeners(this);
		loadData();
		configureButtons();
	}

	/**
	 * Aqui lo que hacemos es asignarle los valores a nuestro bookList de la clase
	 * Application view, ya que usamos el metodo getAllBooks que hemos creado en la
	 * clase BookDAO en el que creamos 3 libros
	 */
	private void loadData() {
		List<Book> books = model.getAllBooks();
		view.bookList.setListData(books.toArray(new Book[] {}));
		view.statusBarPanel.setSecondaryMessage(books.size() + " libros disponibles");
	}

	/**
	 * Este metodo lo que hace es permitir que botones se van a pulsar nada mas
	 * comenzar el programa, en este caso hemos puesto que solo se pueda presionar
	 * el boton new(que ya por defecto se muestra)
	 */
	private void configureButtons() {
		view.buttonPanel.deleteButton.setEnabled(false);
		view.buttonPanel.modifyButton.setEnabled(false);
		// Esto significa que los botones Save y cancel no apareceran al inicio
		setEditionMode(false);
	}

	private void addActionListeners(ActionListener actionListener) {
		// Aqui lo que estamos haciendo basicamente es acceder a nuestro AppView.
		// buttonPanel.Button y usamos la funcion addActionListener
		view.buttonPanel.newButton.addActionListener(actionListener);
		view.buttonPanel.modifyButton.addActionListener(actionListener);
		view.buttonPanel.deleteButton.addActionListener(actionListener);
		view.buttonPanel.saveButton.addActionListener(actionListener);
	}

	private void addKeyListeners(KeyListener keyListener) {
		view.dataPanel.titleText.addKeyListener(keyListener);
	}

	private void addMouseListeners(MouseListener mouseListener) {
		view.bookList.addMouseListener(mouseListener);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Book book = null;
		// Aqui lo que hacemos es almancenar en un String el boton que produjo el evento
		// en nuestra aplicacion
		String actionPerformed = event.getActionCommand();
		// Aqui lo que hacemos es indicar la sentencia de ejecucion que queremos que se
		// produzca en el caso de que uno de los botones haya sido clickeado
		switch (actionPerformed) {
		case "new":
			view.dataPanel.clearTextFields();// Aqui lo que hacemos es que en caso de que el boton que ha sido pulsado
												// sea el new, pues limpiaremos los textos como si fueran nuevos(Este
												// metodo lo hemos creamos en la clase DataPanel con la intencion de que
												// implementarlas en otras clases sea mucho mas sencillo)
			view.dataPanel.titleText.requestFocus();// Este metodo lo usamos para que el cursor del mouse aparezca ya
													// directamente en la caja de texto de tittleText
			view.bookList.clearSelection();// Aqui lo que decimos es que cuando se pone new nuestro Jlist desaparece la
											// seleccion que habiamos hecho antes
			setEditionMode(true);
			break;
		case "modify":

			break;
		case "delete":
			// Aqui lo que estamos diciendo es que el usuario no ha seleccionado un libro,
			// si es igual a menos 1 pues no ha seleccionado un libro en caso contrario pues
			// pasara de esta sentencia
			if (view.bookList.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "Selecciona un libro para eliminar", "Eliminar libro",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			// Recordemos que aqui lo que decimos es que si el usuario a puesto que no esta
			// seguro, pues retornamos a la pagina principal, en caso contrario pues se
			// aplicara lo de abajo
			if (JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Eliminar libro",
					JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
				return;
			}
			// Aqui lo que estamos haciendo es basicamente asignarle el libro que hemos
			// seleccionado de nuestra JList pues eliminarlo(RECORDEMOS QUE A NUESTRO
			// BOOKLIST LE HEMOS PASADO LOS DATOS DE NUESTRO BOOKDAO, por eso es que es en
			// model donde utilizamos el metodo deleteBook. Esta variable book la hemos
			// creado en el inicio de este metodo para poder utilizarla en distintas
			// ocasiones como en el tema del "save"
			book = view.bookList.getSelectedValue();
			model.deleteBook(book);
			// Recordemos que es MUY IMPORTANTE ACTUALIZAR nuestra bookList siempre que
			// vayamos a añadir, modificar, eliminar, etc. Ya que como el metodo loadData lo
			// implementamos tambien en esta clase, pues solo toma en cuenta los libros que
			// se han pasado antes de la clase bookDAO, por tanto siempre va a ser necesario
			// utilizar este metodo cuando hagamos alguna modificacion
			loadData();
			// Con esto una vez se haya eliminado, en nuestra etiqueta saldra este mensaje
			view.statusBarPanel.setPrimaryInformationMessage("Libro eliminado correctamente");
			break;
		case "save":
			// Aqui lo que decimos es que el titulo no puede estar vacio, y mientras este
			// vacio retornara nada y volvera al inicio
			if (view.dataPanel.titleText.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "El titulo es obligatorio", "Nuevo Libro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (view.dataPanel.pageCountText.getText().equals("")) {
				view.dataPanel.pageCountText.setText("0");
			}
			// Aqui lo que hacemos es basicamente aplicar una especie de expresion regular
			// en la que decimos que si el dato introducido en el campo de PageCounttext no
			// es un numero, pues enviamos un mensaje de error y volvemos a iniciar
			if (!view.dataPanel.pageCountText.getText().matches("[0-9]*")) {
				JOptionPane.showMessageDialog(null, "pageCount debe ser un numero", "Nuevo Libro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			String title = view.dataPanel.titleText.getText();// Este metodo lo que hace es obtener la cadena de
																// carecteres que ha introducido el usuario en nuestro
																// campo tittleText
			String description = view.dataPanel.descriptionText.getText();
			String author = view.dataPanel.authorText.getText();
			int pageCount = Integer.parseInt(view.dataPanel.pageCountText.getText());
			book = new Book(title, description, author, pageCount);// Aqui creamos nuestro libro con los parametros
																	// que hemos recogido
			model.addBook(book);// Aqui lo que hacemos es que a nuestro model(Que es un objeto de el BookDAO que
								// recordemos que es como la clase con la que recogemos datos) le añadimos este
								// nuevo libro y asi lo tenemos guardado

			loadData();// Tenemos que utilizar este metodo en este boton debido a que este metodo lo
						// que hara sera actualizar los libros que tendremos en nuestra lista de
						// BookDAO, por tanto es muy importante que al final de botones como este
						// actualicemos nuestra lista que contendra nuestros libros

			// De esta manera lo que hacemos es que una vez guardado el libro que
			// introducimos, pues quedan vacias otra vez las casillas para poder introducir
			// texto nuevo
			view.dataPanel.titleText.setText("");
			view.dataPanel.descriptionText.setText("");
			view.dataPanel.authorText.setText("");
			view.dataPanel.pageCountText.setText("");
			// Recordemos que este metodo lo hemos creado nostros para que segun que boton
			// presionemos, los otros botones se puedan clickear o no
			setEditionMode(false);
			view.statusBarPanel.setPrimaryInformationMessage("Libro creado correctamente");
			break;
		case "cancel":
			setEditionMode(false);
			break;

		default:
			break;
		}
	}

	/**
	 * Este metodo nos sirve para cambiar la visibilidad de nuestro botones segun
	 * que boton se haya presionado. En nuestro caso de haber presionado el boton
	 * "new" veremos que hemos pasado true por parametro y es que los setEnabled que
	 * tienen un "!" antes, significa que seran falsos y los otros verdaderos, pero
	 * en el caso de save vemos que hemos puesto "false" por parametro y eso quiere
	 * decir que los que tengan un "!" pasaran a ser true y los otros pues seran
	 * false
	 * 
	 * @param editionMode
	 */
	private void setEditionMode(boolean editionMode) {
		view.buttonPanel.newButton.setEnabled(!editionMode);
		view.buttonPanel.saveButton.setEnabled(editionMode);
		view.buttonPanel.cancelButton.setEnabled(editionMode);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Aqui lo que hacemos es guardar en la variable selectedBook el libro que se ha
		// seleccionado
		Book selectedBook = view.bookList.getSelectedValue();
		if (selectedBook == null) {
			return;
		}
		view.dataPanel.titleText.setText(selectedBook.getTitle());
		view.dataPanel.descriptionText.setText(selectedBook.getDescription());
		view.dataPanel.authorText.setText(selectedBook.getAuthor());
		view.dataPanel.pageCountText.setText(String.valueOf(selectedBook.getPageCount()));

		// Aqui lo que decimos es que cuando se produzca un click en algun libro de
		// nuestra JList, pues los botones modify y delete button se puedan clicar
		view.buttonPanel.modifyButton.setEnabled(true);
		view.buttonPanel.deleteButton.setEnabled(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
