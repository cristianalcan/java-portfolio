package component;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 * Esta clase será nuestra barra de estado(Esto será un componente de nuestra
 * ventana)
 * 
 * @author crist
 *
 */
public class StatusBarPanel extends JPanel {
	// Esta clase crea etiquetas(pequeños mensajes estaticos que se muestra en
	// nuestra app). Estos atributos los ponemos publicos para que asi en los
	// controller podamos usar los atributos
	private JLabel mainMessage, secondaryMessage;
	// Esto es una clase que se utiliza para crear una línea separadora gráfica
	// entre componentes de una interfaz de usuario.
	private JSeparator separator;

	public StatusBarPanel() {
		super();
		initComponents();
	}

	private void initComponents() {
		mainMessage = new JLabel("Book Manager v1.0");
		mainMessage.setSize(200, 50);// Aqui lo que hacemos es proporcionarle cantidades maximas a nuestra
										// etiqueta(200 de ancho y 50 de alto)

		// Aqui lo que hacemos es inicializar nuestro separator (en medio de nuestro 2
		// componentes que vamos a separar)
		separator = new JSeparator();
		separator.setOrientation(JSeparator.VERTICAL);// Aqui le damos un orientacion vertical a nuestro separador

		secondaryMessage = new JLabel("No messages available");
		secondaryMessage.setSize(200, 50);

		add(mainMessage);
		add(separator);// Aqui añadimos a nuestro panel nuestro separador en medio de los 2 componentes
						// que queremos separar
		add(secondaryMessage);
	}

	/**
	 * Hemos creado este metodo y el de abajo para poder asignarle valores a
	 * nuestras barras, ya que ahora las tenemos como privadas y por tanto no
	 * podemos acceder a ellas desde otras clases
	 * 
	 * @param text
	 */
	private void setPrimaryMessage(String text) {
		mainMessage.setText(text);
	}

	public void setPrimaryErrorMessage(String text) {
		mainMessage.setForeground(Color.RED);
		setPrimaryMessage(text);
	}
	
	public void setPrimaryInformationMessage(String text) {
		mainMessage.setForeground(Color.BLACK);
		setPrimaryMessage(text);
	}

	public void setSecondaryMessage(String text) {
		secondaryMessage.setText(text);
	}

	public void clearPrimaryMessage() {
		mainMessage.setText("");
	}

	public void clearSecondaryyMessage() {
		secondaryMessage.setText("");
	}

	public void clearAllMessages() {
		mainMessage.setText("");
		secondaryMessage.setText("");
	}
}
