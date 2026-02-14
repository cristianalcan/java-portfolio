package controllers;

import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.CheckBox;

import javafx.scene.input.KeyEvent;
import models.Coche;
import javafx.scene.control.TableView;

public class EscenaPruebaController {
	@FXML
	private CheckBox cbGrupo1;
	@FXML
	private CheckBox cbGrupo2;
	@FXML
	private ComboBox<String> c;
	@FXML
	private ListView<String> lista;
	@FXML
	private TableView<Coche> tabla;
	@FXML
	private TextArea taArea;
	@FXML
	private TextField tField;

	public void initialize() {
		List<String> elementos = new ArrayList<>();
		elementos.add("elemento1");
		elementos.add("elemento2");
		elementos.add("elemento3");
		c.setItems(FXCollections.observableArrayList(elementos));

		lista.getItems().add("Texto 1");
		lista.getItems().add("Texto 2");
		lista.getItems().add("Texto 3");
		ObservableList<Coche> data = FXCollections.observableArrayList(new Coche("TOYOTA", "Yaris 1.5 120H Style 5p.",
				22000, 2022,
				"PRECIO FINANCIADO.\r\n"
						+ "PACK PROTECCIÓN TOYOTA INCLUIDO: Tornillos antirrobo, caja organizadora para la compra, protector de maletero, alfombras de goma y pincel de retoque (varía en función de cada gama)   \r\n"
						+ "Vehículos de ocasión y km0 con garantía de Concesionario Oficial Toyota. Aceptamos tu vehículo como parte de pago, tasándolo sin ningún compromiso.",
				"../resources/coche1.jpg"));
		TableColumn marca = new TableColumn<>("Marca");
		marca.setCellValueFactory(new PropertyValueFactory<Coche, String>("marca"));
		TableColumn modelo = new TableColumn<>("Modelo");
		modelo.setCellValueFactory(new PropertyValueFactory<Coche, String>("modelo"));
		tabla.setItems(data);
		tabla.getColumns().clear();
		tabla.getColumns().addAll(marca, modelo);
	}

	@FXML
	public void combo(ActionEvent event) {
		System.out.println(c.getValue());
	}

	// Event Listener on TextField.onAction
	@FXML
	public void tfField(ActionEvent event) {
		System.out.println(tField.getText());
	}

	// Event Listener on TextArea[#taArea].onKeyTyped
	@FXML
	public void capturarTexto(KeyEvent event) {
		System.out.println(taArea.getText());
	}
}
