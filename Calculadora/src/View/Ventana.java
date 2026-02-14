package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

import componentes.DigitosPanel;
import componentes.OpcionesPanel;
import componentes.RepresentacionPanel;

/**
 * Esta clase es la vista de nuestra aplicacion
 * 
 * @author crist
 *
 */
public class Ventana extends JFrame {
	public DigitosPanel digitos;
	public RepresentacionPanel representacion;
	public OpcionesPanel opciones;

	public Ventana() {
		super("Calculadora Tokio");
		initComponents();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initComponents() {
		setMinimumSize(new Dimension(380, 400));
		setLayout(new BorderLayout());

		digitos = new DigitosPanel(new GridLayout(4, 4));
		representacion = new RepresentacionPanel();
		opciones = new OpcionesPanel(new GridLayout(3, 1));

		getContentPane().add(digitos, BorderLayout.CENTER);
		getContentPane().add(representacion, BorderLayout.NORTH);
		getContentPane().add(opciones, BorderLayout.EAST);
	}
}
