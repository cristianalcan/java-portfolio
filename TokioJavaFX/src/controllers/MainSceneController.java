package controllers;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class MainSceneController {
	@FXML
	private TextField tfNumero1;
	@FXML
	private TextField tfNumero2;
	@FXML
	private Button bSumar;
	@FXML
	private Label lResultado;

	// Event Listener on Button[#bSumar].onAction
	@FXML
	public void sumarNumeros(ActionEvent event) {
		int n1 = Integer.parseInt(tfNumero1.getText());
		int n2 = Integer.parseInt(tfNumero2.getText());
		lResultado.setText("Resultado: " + (n1 + n2));
	}
}
