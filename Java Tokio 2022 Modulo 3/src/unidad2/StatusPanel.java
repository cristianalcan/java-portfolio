package unidad2;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusPanel extends JPanel {
	/**
	 * Este componente tiene como finalidad mostrar texto o imagenes segun como lo
	 * especifiquemos
	 */
	private JLabel lbStatus;
	
	public StatusPanel() {
		setLayout(new FlowLayout());
		initComponents();
	}
	
	private void initComponents() {
		lbStatus = new JLabel("Barra de estado");
		add(lbStatus);// Al panel le añadimos nuetro label
	}
}
