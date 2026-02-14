package controllers;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import models.Coche;

public class CocheSceneController {
	@FXML
	private ImageView imagen;
	@FXML
	private Label lMarca;
	@FXML
	private Label lModelo;
	@FXML
	private Label lAnyo;
	@FXML
	private Label lDescripcion;
	@FXML
	private Label lPrecio;
	@FXML
	private Button bAceptar;

	private Coche coche;

	public CocheSceneController() {
		super();
		this.coche = new Coche("TOYOTA", "Yaris 1.5 120H Style 5p.", 22000, 2022, "PRECIO FINANCIADO.\r\n"
				+ "PACK PROTECCIÓN TOYOTA INCLUIDO: Tornillos antirrobo, caja organizadora para la compra, protector de maletero, alfombras de goma y pincel de retoque (varía en función de cada gama)   \r\n"
				+ "Vehículos de ocasión y km0 con garantía de Concesionario Oficial Toyota. Aceptamos tu vehículo como parte de pago, tasándolo sin ningún compromiso.",
				"../resources/coche1.jpg");
	}

	/**
	 * Esta funcion la usamos para asignarle los valores a nuestro programa, esto lo
	 * hacemos en este metodo, ya que el constructor que es el primer metodo que se
	 * ejecuta cuando se abre el programa no puede asignar los valores de forma
	 * directa, ya que en el momento que se ejecuta el constructor pues nuestro
	 * programa "no existe" por eso lo tenemos que hacer en un metodo aparte
	 */
	public void initialize() {
		lMarca.setText(coche.getMarca());
		lModelo.setText(coche.getModelo());
		lAnyo.setText(coche.getAnyo() + "");
		lDescripcion.setText(coche.getDescripcion());
		lPrecio.setText(coche.getPrecio() + " €");
	}

	@FXML
	public void cerrarVentana(ActionEvent event) {
		System.exit(0);
	}
}
