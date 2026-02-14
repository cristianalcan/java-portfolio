package componentes;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 * Botones que van a limpiar, guardar y recuperar los numeros
 * 
 * @author crist
 *
 */
public class OpcionesPanel extends JPanel {
	private GridLayout g;
	public JButton limpiar, guardar, recuperar;
	public JSeparator uno, dos, tres;

	public OpcionesPanel(GridLayout g) {
		super();
		this.g = g;
		initComponents();
	}

	private void initComponents() {
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setLayout(g);
		g.setHgap(20);
		g.setVgap(20);
		limpiar = new JButton("Limpiar");
		limpiar.setActionCommand("limpiar");
		guardar = new JButton("Guardar");
		guardar.setActionCommand("guardar");
		recuperar = new JButton("Recuperar");
		recuperar.setActionCommand("recuperar");

		add(limpiar);
		add(guardar);
		add(recuperar);
	}
}
