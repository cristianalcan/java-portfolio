package unidad2;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Esta clase sera igual que Window 1, lo que pasa es que usaremos otro layout
 * 
 * @author crist
 *
 */
public class WindowBoxLayout extends JFrame {
	private JButton btDeleteName;
	private JButton btQuit;
	private JTextField tfName;
	/**
	 * Con este layout necesitaremos un panel
	 */
	private JPanel panel;

	public WindowBoxLayout() {
		initComponents();
		configureWindow();
	}

	private void initComponents() {
		panel = new JPanel();
		/**
		 * Aqui le estamos asignando el diseño a nuestro panel, en este caso sera con
		 * BoxLayout, en el lado izquierdo se pone el objeto JPanel al que le vamos a
		 * aplicar este diseño, al lado derecho el diseño que se va a aplicar, en este
		 * caso, los elementos estaran distribuidos en forma vertical
		 */
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		/**
		 * Con el metodo getContentPane() lo que hacemos es establecer como contenedor
		 * nuestro panel, y luego a este contenedor, como vemos abajo, le añadimos los
		 * componentes
		 */
		getContentPane().add(panel);

		btDeleteName = new JButton("Borrar nombre");
		btDeleteName.addActionListener(event -> {
			tfName.setText("");
		});
		btQuit = new JButton("Salir");
		btQuit.addActionListener(event -> {
			if (JOptionPane.showConfirmDialog(null, "Está seguro?", "Salir",
					JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
				return;
			}
			System.exit(0);
		});
		tfName = new JTextField(50);
		/**
		 * Asi le añadimos los componentes al panel
		 */
		panel.add(btDeleteName);
		panel.add(btQuit);
		panel.add(tfName);
	}

	/**
	 * Este metodo es para configurar la ventana, estas son cosas "rutinarias" que
	 * casi siempre vamos a hacer cuando estemos creando una app. Asi tenemos el
	 * constructor mas despejado
	 */
	private void configureWindow() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
