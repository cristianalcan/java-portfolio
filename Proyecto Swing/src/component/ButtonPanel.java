package component;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Esta clase será para implementar los botones(Esto será un componente de
 * nuestra ventana)
 * 
 * @author crist
 *
 */
public class ButtonPanel extends JPanel {
	public JButton newButton, modifyButton, deleteButton, saveButton, cancelButton;

	public ButtonPanel() {
		super();
		initComponents();
	}

	private void initComponents() {
		newButton = new JButton("New");
		newButton.setActionCommand("new");// Aqui lo que hacemos es asignarle un "valor" con el que identificar este
											// boton en caso de que se produzca un evento

		modifyButton = new JButton("Modify");
		modifyButton.setActionCommand("modify");

		deleteButton = new JButton("Delete");
		deleteButton.setActionCommand("delete");

		saveButton = new JButton("Save");
		saveButton.setActionCommand("save");

		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("cancel");

		add(newButton);
		add(modifyButton);
		add(deleteButton);
		add(saveButton);
		add(cancelButton);
	}
}
