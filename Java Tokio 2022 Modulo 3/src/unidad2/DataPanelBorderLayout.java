package unidad2;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * De esta forma queda mas organizado el codigo, ya que creamos esta clase solo
 * para representar la parte del medio de nuestra aplicacion. Seria el panel del
 * medio
 * 
 * @author crist
 *
 */
public class DataPanelBorderLayout extends JPanel {
	private JLabel lbName, lbSurname, lbCategory;
	private JTextField tfName, tfSurname;
	/**
	 * Esta clase lo que hace es que nos permite escoger la opcion de una lista,
	 * como los enumeradores que vimos, cuando solo podemos escoger opciones
	 * finitas. Tenemos que definir que tipo de dato se va a tratar, en este caso un
	 * String
	 */
	private JComboBox<String> cbCategory;

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
		lbName = new JLabel("Nombre");
		lbSurname = new JLabel("Apellidos");
		lbCategory = new JLabel("Categoria");

		tfName = new JTextField("");
		tfSurname = new JTextField("");

		cbCategory = new JComboBox<String>();
		cbCategory.addItem("categoria 1");
		cbCategory.addItem("categoria 2");
		/**
		 * Es importante que lo añadamos en el orden correcto, primero añadimos la
		 * etiqueta del Nombre, y despues el texto del nombre, para que asi vayan en
		 * pareja, del mismo modo ocurre con los siguientes componentes. Hay que tener
		 * mucho cuidado con el orden en el que añadamos los componentes
		 */
		add(lbName);
		add(tfName);
		add(lbSurname);
		add(tfSurname);
		add(lbCategory);
		add(cbCategory);
	}

	public JLabel getLbName() {
		return lbName;
	}

	public JLabel getLbSurname() {
		return lbSurname;
	}

	public JLabel getLbCategory() {
		return lbCategory;
	}

	public JTextField getTfName() {
		return tfName;
	}

	public JTextField getTfSurname() {
		return tfSurname;
	}

	public JComboBox<String> getCbCategory() {
		return cbCategory;
	}

}
