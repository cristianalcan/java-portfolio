package unidad2_clase3_copiasClase2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WindowBorderLayout extends JFrame {
	/**
	 * Aqui creamos 3 paneles porque vamos a crear nuestra aplicacion, y
	 * "dividiremos" cada parte en 3, la primera parte sera de botones, la segunda
	 * de texto, y la tercera un label. Esto lo hacemos porque como vemos, para
	 * poder estructurar una aplicacion tenemos que usar layouts, entonces, tambien
	 * necesitamos paneles, por tanto creamos un panel para cada layout que usaremos
	 */
	private ButtonsPanel buttonsPanel;
	private DataPanelBorderLayout centralPanel;
	private StatusPanel statusPanel;
	private DataPanelController dataPanelController;
	/**
	 * Esta clase lo que hace es que genera un "menu" cuando seleccionamos una
	 * pestaña(JTabbedPane), y nos da opciones(por ejemplo cuando entramos a las 3
	 * barritas en google y nos salen muchas opciones como por ejemeplo
	 * configuracion, nueva pestaña, historial, ect...
	 */
	private JMenuBar menuBar;

	public WindowBorderLayout() {
		super();
		// Es importante que pongamos el configureWindow al final del todo ya que ahi
		// incluimos el meotod pack que nos sirve para que a la hora de abrir nuestro
		// programa, salga de un tamaño adecuado todos los componentes
		initMenuBar();
		initComponents();
		configureWindow();
	}

	private void initMenuBar() {
		// Inicializamos el menuBar
		menuBar = new JMenuBar();
		// Para añadir opciones a nuestro menuBar tiene que ser a traves de JMenu
		JMenu menuFile = new JMenu("Fichero");
		// A nuestras opciones pues le creamos sus items para que aparezcan una vez se
		// clickee nuestra opcion
		JMenuItem menuItemOpen = new JMenuItem("Abrir");
		menuFile.add(menuItemOpen);
		JMenuItem menuItemQuit = new JMenuItem("Salir");
		menuFile.add(menuItemQuit);
		// Aqui le añadimos una accion a nuestro item salir, y es que si seleccionamos
		// yes, saldremos, pero si no, no saldremos. Recordemos que el null es para que
		// aparezca en medio, "Esta seguro que desea salir" es el texto que le saldra,
		// "Salir" es el nombre de la "ventana" que saldrá, y JOption es para que nos de
		// dos opciones , si y no
		menuItemQuit.addActionListener(event -> {
			if (JOptionPane.showConfirmDialog(null, "Está seguro que desea salir?", "Salir",
					JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
				return;
			}
			// Esta es la forma de salir de una aplicacion de forma "limpia"
			System.exit(0);
		});
		// Es importante que nostros añadieramos el Jmenu a nuestro menubar al ultimo,
		// ya que si lo añadimos antes de crear nuestro jmenuitem no se van a añadir
		// estos items
		menuBar.add(menuFile);

		JMenu menuEdit = new JMenu("Editar");
		menuBar.add(menuEdit);

		JMenu menuTools = new JMenu("Herramientas");
		menuBar.add(menuTools);

		JMenu menuHelp = new JMenu("Ayuda");
		menuBar.add(menuHelp);
		// Y asi le decimos a nuestra JFrame que nuestro menu de opciones es nuestro
		// menuBar que hemos creado
		setJMenuBar(menuBar);
	}

	private void initComponents() {
		setLayout(new BorderLayout());
		/**
		 * Asi le asignamos a nuestros panel central nuestra clase que creamos para que
		 * quede mas organizado, esto lo podriamos hacer con todos los paneles
		 */
		buttonsPanel = new ButtonsPanel();
		centralPanel = new DataPanelBorderLayout();
		dataPanelController = new DataPanelController(centralPanel);
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
