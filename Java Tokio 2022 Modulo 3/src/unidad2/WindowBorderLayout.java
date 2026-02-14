package unidad2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowBorderLayout extends JFrame {
	/**
	 * Aqui creamos 3 paneles porque vamos a crear nuestra aplicacion, y
	 * "dividiremos" cada parte en 3, la primera parte sera de botones, la segunda
	 * de texto, y la tercera un label. Esto lo hacemos porque como vemos, para
	 * poder estructurar una aplicacion tenemos que usar layouts, entonces, tambien
	 * necesitamos paneles, por tanto creamos un panel para cada layout que usaremos
	 */
	private JPanel buttonsPanel, centralPanel, statusPanel;

	public WindowBorderLayout() {
		super();
		initComponents();
		configureWindow();
	}

	private void initComponents() {
		setLayout(new BorderLayout());
		/**
		 * Asi le asignamos a nuestros panel central nuestra clase que creamos para que
		 * quede mas organizado, esto lo podriamos hacer con todos los paneles
		 */
		buttonsPanel = new ButtonsPanel();
		centralPanel = new DataPanelBorderLayout();
		statusPanel = new StatusPanel();
		/**
		 * Con esto añadimos nuestro panel a nuestra ventana, y tambien añadimos el
		 * sitio en el que se va a situar en nuestra ventana
		 */
		getContentPane().add(buttonsPanel, BorderLayout.NORTH);
		getContentPane().add(statusPanel, BorderLayout.SOUTH);
		getContentPane().add(centralPanel, BorderLayout.CENTER);
	}

	private void configureWindow() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
