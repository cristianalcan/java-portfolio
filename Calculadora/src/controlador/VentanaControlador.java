package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;

import org.nfunk.jep.JEP;

import View.Ventana;
import datos.Datos;

/**
 * Clase controladora donde se encargara de llevar a cabo todos los eventos de
 * nuestro componentes
 * 
 * @author crist
 *
 */
public class VentanaControlador implements ActionListener {
	private Ventana ventana;
	private Datos datos;

	public VentanaControlador(Ventana ventana, Datos datos) {
		this.ventana = ventana;
		this.datos = datos;
		addActionListeners(this);
	}

	private void addActionListeners(ActionListener actionListener) {
		ventana.digitos.cero.addActionListener(actionListener);
		ventana.digitos.uno.addActionListener(actionListener);
		ventana.digitos.dos.addActionListener(actionListener);
		ventana.digitos.tres.addActionListener(actionListener);
		ventana.digitos.cuatro.addActionListener(actionListener);
		ventana.digitos.cinco.addActionListener(actionListener);
		ventana.digitos.seis.addActionListener(actionListener);
		ventana.digitos.siete.addActionListener(actionListener);
		ventana.digitos.ocho.addActionListener(actionListener);
		ventana.digitos.nueve.addActionListener(actionListener);
		ventana.digitos.suma.addActionListener(actionListener);
		ventana.digitos.resta.addActionListener(actionListener);
		ventana.digitos.division.addActionListener(actionListener);
		ventana.digitos.multiplicacion.addActionListener(actionListener);
		ventana.digitos.punto.addActionListener(actionListener);
		ventana.opciones.limpiar.addActionListener(actionListener);
		ventana.opciones.guardar.addActionListener(actionListener);
		ventana.opciones.recuperar.addActionListener(actionListener);
		ventana.digitos.igual.addActionListener(actionListener);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botonPresionado = (JButton) e.getSource();
		String textoActual = ventana.representacion.representacion.getText();
		String nuevoTexto = textoActual + botonPresionado.getActionCommand();
		ventana.representacion.representacion.setText(nuevoTexto);
		String action = e.getActionCommand();
		switch (action) {
		case "limpiar":
			ventana.representacion.representacion.setText("");
			break;
		case "guardar":
			datos.datos.add(textoActual);
			ventana.representacion.representacion.setText("");
			break;
		case "recuperar":
			ventana.representacion.representacion.setText("" + datos.datos.get(datos.datos.size() - 1));
			break;
		// Este es el setActionCommand de igual, lo tengo vacio porque como vemos en la
		// parte de arriba, cuando seleccionamos un boton, pues tambien se añade su
		// setactionCommand, y por tanto como la unica tecla que no queremos que se
		// añada su valor es el igual lo tengo vacio. IMPORTANTE, AQUI ESTOY TRABAJANDO
		// CON UNA LIBRERIA IMPORTADA, la libreria se llama jep.jar, te dejo el enlace
		// donde lo descargue https://jar-download.com/artifact-search/jep
		case "":
			JEP jep = new JEP();
			jep.parseExpression(ventana.representacion.representacion.getText());
			ventana.representacion.representacion.setText("" + jep.getValue());
			break;
		default:
			break;
		}
	}

}
