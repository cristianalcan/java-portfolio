package component;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Esta clase será para introducir texto(Esto será un componente de nuestra
 * ventana)
 * 
 * @author crist
 *
 */
public class DataPanel extends JPanel {
	public JTextField titleText, descriptionText, authorText, pageCountText;
	private JLabel tittleLabel, descriptionLabel, authorLabel, pageCountLabel;

	public DataPanel() {
		super();
		initComponents();
	}

	private void initComponents() {
		setLayout(new GridLayout(4, 3));
		/**
		 * Aqui lo que estamos haciendo es basicamente inicializar nuestros componentes,
		 * y van en un orden que nosotros hemos especificado. Como vemos primero va
		 * inicializada nuestra etiqueta y luego el texto
		 */

		tittleLabel = new JLabel("Tittle*");
		titleText = new JTextField();
		descriptionLabel = new JLabel("Description");
		descriptionText = new JTextField();
		authorLabel = new JLabel("Author");
		authorText = new JTextField();
		pageCountLabel = new JLabel("Pages");
		pageCountText = new JTextField();

		// Aqui tambien es importante añadir a nuestro panel en el orden en el que lo
		// hemos inicializado para que en nuestra aplicacion aparezca en ese orden
		add(tittleLabel);
		add(titleText);
		add(descriptionLabel);
		add(descriptionText);
		add(authorLabel);
		add(authorText);
		add(pageCountLabel);
		add(pageCountText);
	}

	public void clearTextFields() {
		titleText.setText("");
		descriptionText.setText("");
		authorText.setText("");
		pageCountText.setText("");
	}
}
