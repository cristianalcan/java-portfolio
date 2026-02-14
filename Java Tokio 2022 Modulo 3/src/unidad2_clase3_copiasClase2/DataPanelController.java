package unidad2_clase3_copiasClase2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * En esta clase vamos a crear los metodos o los ActionListener de nuestros
 * botones de la clase DataPanelBorderLayout
 * 
 * @author crist
 *
 */
public class DataPanelController implements ActionListener {
	private unidad2_clase3_copiasClase2.DataPanelBorderLayout dataPanel;

	public DataPanelController(unidad2_clase3_copiasClase2.DataPanelBorderLayout dataPanel) {
		this.dataPanel = dataPanel;
		addListeners();
	}

	private void addListeners() {
		dataPanel.okButton.addActionListener(this);
		dataPanel.cancelButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Aqui lo que estamos haciendo es que vamos a identificar nuestro boton que ha
		// producido el evento. Como en la clase DataPanelBorderLayout hemos utilizado
		// el metodo setActionCommand en cada boton, pues podemos obtener sus "valores"
		String actionCommand = e.getActionCommand();
		switch (actionCommand) {
		case "ok":
			doOk();
			break;
		case "cancel":
			doCancel();
			break;

		default:
			break;
		}
	}

	private void doOk() {
		JOptionPane.showMessageDialog(null, "ok", "ok", JOptionPane.INFORMATION_MESSAGE);
	}

	private void doCancel() {
		JOptionPane.showMessageDialog(null, "cancel", "cancel", JOptionPane.INFORMATION_MESSAGE);
	}
}
