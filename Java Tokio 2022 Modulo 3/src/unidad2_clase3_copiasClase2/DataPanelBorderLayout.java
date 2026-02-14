package unidad2_clase3_copiasClase2;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;

/**
 * Esta clase es la copia del Verdadero DataPanelBorderLayout que esta en la
 * unidad2, estas clases que se encuentran en este paquete las vamos a usar para
 * incrementar y modificar cosas que antes no estaban(Esta es la clase3
 * telepresencial). HEMOS PUESTO LOS COMPONENTES EN PUBLIC debido a que los
 * vamos a usar desde nuestra clase DataPanelController. Entonces esta clase
 * quedaria como la "VISTA"
 * 
 * @author crist
 *
 */
public class DataPanelBorderLayout extends JPanel {
	/**
	 * Esta clase nos permite organizar nuestros paneles, que recordemos que son
	 * "grupos" en los que se van organizando distintos componentes, en forma de
	 * pestañas
	 */
	public JTabbedPane tabbedPane;
	public JPanel customersPanel, ordersPanel, providersPanel;
	public JButton okButton, cancelButton;
	// Una JList es muy parecida a un ComboBox, que recordemos que nos muestra una
	// serie de opciones que puede seleccionar el usuario, la diferencia es que en
	// esta JList se pueden tambien seleccionar multiples opciones
	public JList<City> lCities;
	// Esta clase será NECESARIA cuando trabajemos con el JList, ya que con esta
	// clase añadiremos los elementos(opciones) del JList, ya que no podemos añadir
	// las opciones directamente con el JList, entonces este será como un
	// "intermediario"
//	private DefaultListModel<City> dlmCities;

	public DataPanelBorderLayout() {
		/**
		 * Este layout coloca los componentes en forma de matriz, haciendo que todos los
		 * componentes tengan el mismo tamaño. En el lado izquierdo se pone el numero de
		 * filas que queremos y en el derecho el lado de columnas.
		 */
		setLayout(new GridLayout(3, 2));
		initComponents();
	}

	private void initComponents() {
		// Inicializamos los paneles
		customersPanel = new JPanel();
		okButton = new JButton("ok");
		// Este es el "valor" asociado que se le asigna al boton en caso de eventos
		okButton.setActionCommand("ok");
		cancelButton = new JButton("cancel");
		cancelButton.setActionCommand("cancel");
		// Añadimos nuestros botones a nuestro panel de "clientes"
		customersPanel.add(okButton);
		customersPanel.add(cancelButton);

		List<City> cities = new ArrayList<>();
		cities.add(new City("Zaragoza", "Aragon"));
		cities.add(new City("Madrid", "Madrid"));
		cities.add(new City("Vigo", "Galicia"));

		lCities = new JList<>();
		// De esta forma hacemos que nuestra JList tenga solo una opcion de seleccionar
		lCities.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		// Esta es otra forma de añadir nuestras opciones a nuestra JList
		lCities.setListData(cities.toArray(new City[] {}));
		// Otra forma de añadirle las opciones al JList directamente es pasandole un
		// Array de en este caso, ciudades
//		lCities.setListData(new City[] { new City("Zaragoza", "Aragon"), new City("Madrid", "Madrid"),
//				new City("Vigo", "Galicia") });
//		dlmCities = new DefaultListModel<>();
		// Y aqui ahora le añadimos las opciones o elementos a nuestro DefaultListModel
		// y asi cuando le asignmeos al JList, pues saldran estas opciones
//		dlmCities.addElement(new City("Zaragoza", "Aragon"));
//		dlmCities.addElement(new City("Madrid", "Madrid"));
//		dlmCities.addElement(new City("Vigo", "Galicia"));

		// Aqui le asignamos a nuestra Jlist el modelo dlmCities
//		lCities.setModel(dlmCities);
		// Aqui añadimos nuestra JList en nuestra pestaña de Clientes
		customersPanel.add(lCities);

		ordersPanel = new JPanel();

		providersPanel = new JPanel();

		tabbedPane = new JTabbedPane();
		// Asi es como nosotros vamos añadiendo nuestras pestañas a nuestro JtabbedPane,
		// el lado izquierdo sera el nombre de la pestaña, mientras el lado derecho la
		// clase a la que pertenece, en este caso seran paneles
		tabbedPane.addTab("Clientes", customersPanel);
		tabbedPane.addTab("Pedidos", ordersPanel);
		tabbedPane.addTab("Proveedores", new ButtonsPanel());// Aqui estamos poniendo como panel nuestra clase creada
																// buttonsPanel, lo que pasara con esto es que se
																// añadiran los componentes de esta clase creada
		// Añadimos nuestro tabbedPane
		add(tabbedPane);
	}

}
