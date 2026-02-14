package unidad2_clase3_copiasClase2;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JToggleButton;

public class ButtonsPanel extends JPanel {
	// Recordemos que el JButton es un boton que vamos a utilizar sobretodo cuando
	// queremos que se ejecute un evento, los otros botones sirven sobre todo para
	// recopilar informacion, auqneu tambien pueden ejecutar eventos
	private JButton button1;
	// Esta clase permite implementar un cuadro de opciones(que tenemos que
	// confirmar al menos una, pero puede ser mas de una).
	private JCheckBox button2;
	// Esta clase permite implementar un cuadro de opciones(y aqui solo podremos
	// confirmar una opcion)
	private JRadioButton button3;
	// Esta clase lo que hace es que si presionamos un boton este se mantendra
	// presionado hasta que presionemos otro boton u otra opcion de nuestro programa
	private JToggleButton button4;
	// Esta clase lo que hace es que nos permite escoger la opcion de una lista,
	// como los enumeradores que vimos, cuando solo podemos escoger opciones
	// finitas. Tenemos que definir que tipo de dato se va a tratar, en este caso un
	// String
	private JComboBox<City> comboBox;
	// Esta clase lo que hace es crear una barra en la que se establecen valores, en
	// los que el usuario podra seleccionar los valores que esten dentro del rango
	// de la barra
	private JSlider slider;
	// Esta clase sirve para ver el progreso de una tarea o de una accion que se
	// esta produciendo, por ejemplo, cuando estamos abriendo un archivo pesado,
	// podemos enseñar el porcentaje de carga con esta barra(tambien mediante hilos
	// podemos mostrar esto mientras se sigue ejecutando otra tarea)
	private JProgressBar progressBar;

	public ButtonsPanel() {
		/**
		 * Al primer panel que es el de los botones le vamos a poner el flow layout que
		 * recordemos que organiza los componentes de izquierda a derecha y de arriba a
		 * abajo
		 */
		setLayout(new FlowLayout());
		initComponents();
	}

	private void initComponents() {
		button1 = new JButton("Registrar");
		// A nuestro button1 le añadimos la siguiente funcion. Recordemos que el null es
		// para que aparezca en medio el mensaje, "Click" es el nombre del mensaje,
		// "Click" es el titulo del mensaje y lo que va a mandar es una "informacion".
		button1.addActionListener(event -> {
			// Con esto lo que hacemos es mostrar el mensaje si esta o no esta seleccionado
			// cada boton.Este metodo se puede usar con casi todos los botones que no son
			// JButton
			if (button2.isSelected()) {
				JOptionPane.showMessageDialog(null, "button2 está seleccionado", "Click",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "button2 no está seleccionado", "Click",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (button3.isSelected()) {
				JOptionPane.showMessageDialog(null, "button3 está seleccionado", "Click",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "button3 no está seleccionado", "Click",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (button4.isSelected()) {
				JOptionPane.showMessageDialog(null, "button4 está seleccionado", "Click",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "button4 no está seleccionado", "Click",
						JOptionPane.INFORMATION_MESSAGE);
			}
			// Aqui estamos creando la variable actionCity para obtener la ciudad
			// seleccionada por el usuario
			City actionCity = (City) comboBox.getSelectedItem();
			// Y aqui pues lo que hacemos es que cuando le demos al boton1 pues se mostrara
			// que ciudad esta seleccionada
			JOptionPane.showMessageDialog(null, "Ciudad seleccionada " + actionCity.getName(), "Click",
					JOptionPane.INFORMATION_MESSAGE);
		});
		button2 = new JCheckBox("Modificar");
		button3 = new JRadioButton("Eliminar");
		button4 = new JToggleButton("Buscar");

		comboBox = new JComboBox<City>();
		// Añadimos las opciones a nuestro comboBox
		comboBox.addItem(new City("Vigo", "Galicia"));
		comboBox.addItem(new City("Madrid", "Madrid"));
		comboBox.addItem(new City("Zaragoza", "Aragon"));

		slider = new JSlider();
		slider.setMinimum(0);// Le asignamos el valor minimo
		slider.setMaximum(100);// Le asignamos el valor maximo
		slider.setOrientation(JSlider.VERTICAL);// Asi ponemos la barra en vertical
		slider.setPaintTicks(true);// Esto es para "pintar" las escalas o los valores en los que se encuentran en
									// la barra
		slider.addChangeListener(event -> {
			// Aqui lo que hacemos es mostrar por consola el valor que tiene en el momento
			// que se produce el evento
			System.out.println(slider.getValue());
		});

		progressBar = new JProgressBar();
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
//		progressBar.setIndeterminate(true);// Con este metodo lo que hace es que se mueva la linea que determina un
		// valor de la barra de un lado hacia otro
		progressBar.setValue(50);// Le asignamos el valor 50

		/**
		 * Le añadimos los botones a nuestro panel de botones, y el combo box.
		 * Recordemos que los botones y el comboBox se mostraran en el orden segun se
		 * han ido añadiendo
		 */
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(comboBox);
		add(slider);
		add(progressBar);
	}
}
