package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;

public class ControlStockController {
	@FXML
	private Button buttonAgregar;
	@FXML
	private Button buttonModificar;
	@FXML
	private TableView<String[]> tabla;
	@FXML
	private TextField textoIdentificador;
	@FXML
	private TextField textoProducto;
	@FXML
	private TextField textoStock;
	private TableColumn<String[], String> identificador;
	private TableColumn<String[], String> producto;
	private TableColumn<String[], String> stock;

	public ControlStockController() {
	}

	public void initialize() {
	//	iniciarTabla();
	//	tabla.setEditable(true);
//		VBox vbox = new VBox(10, textoIdentificador, textoProducto, textoStock, buttonAgregar, tabla);
	/*	identificador.setCellValueFactory(data -> new SimpleStringProperty((data).getValue()));
		identificador.setCellFactory(TextFieldTableCell.forTableColumn());*/
	}

	private void iniciarTabla() {
		tabla.setEditable(true);
		identificador = new TableColumn<>("Identificador");
		producto = new TableColumn<>("Nom. Producto");
		stock = new TableColumn<>("Stock");
		tabla.getColumns().addAll(identificador, producto, stock);
	}

	@FXML
	void agregar(ActionEvent event) {
		if (textoIdentificador.getText() != "" & textoProducto.getText() != "" & textoStock.getText() != ""
				& !compararTexto()) {
			String[] row = new String[] { textoIdentificador.getText(), textoProducto.getText(), textoStock.getText() };
			tabla.getItems().add(row);
		}
		textoIdentificador.clear();
		textoProducto.clear();
		textoStock.clear();
	}

	@FXML
	void modificar(ActionEvent event) {

	}

	/*
	 * private void validarTextos() { if (textoIdentificador.getText() != "" &
	 * textoProducto.getText() != "" & textoStock.getText() != "" &
	 * !compararTexto()) { String identificador = textoIdentificador.getText();
	 * tabla.getItems().add(identificador); textoIdentificador.clear();
	 * 
	 * String producto = textoProducto.getText(); tabla.getItems().add(producto);
	 * textoProducto.clear();
	 * 
	 * String stock = textoStock.getText(); tabla.getItems().add(stock);
	 * textoStock.clear(); } textoIdentificador.clear(); textoProducto.clear();
	 * textoStock.clear(); }
	 */

	private boolean compararTexto() {
		String nuevoNombre = textoIdentificador.getText();
		boolean existe = false;
		for (String texto[] : tabla.getItems()) {
			String nombreActual = identificador.getCellData(texto);
			if (nuevoNombre.equals(nombreActual)) {
				existe = true;
				break;
			}
		}
		return existe;
	}
}
