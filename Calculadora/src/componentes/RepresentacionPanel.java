package componentes;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Esta es la parte donde se muestran todos los numeros que se seleccionan
 * 
 * @author crist
 *
 */
public class RepresentacionPanel extends JPanel {
	public JTextField representacion;

	public RepresentacionPanel() {
		super();
		initComponents();
	}

	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		representacion = new JTextField();

		add(representacion);
	}

}
