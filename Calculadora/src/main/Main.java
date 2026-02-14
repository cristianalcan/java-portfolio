package main;

import View.Ventana;
import controlador.VentanaControlador;
import datos.Datos;

public class Main {

	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		Datos datos = new Datos();
		VentanaControlador controlador = new VentanaControlador(ventana, datos);
	}
}
