package unidad2_clase3_copiasClase2;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StatusPanel extends JPanel implements KeyListener {
	/**
	 * Este componente tiene como finalidad mostrar texto o imagenes segun como lo
	 * especifiquemos
	 */
	private JLabel lbStatus;
	// Esta clase permite al usuario ingresar una cadena de caracteres por
	// teclado(solo una linea)
	private JTextField textField;
	private JButton button;
	// Esta clase permite al usuario ingresar mas de una cadena de caracteres por
	// teclado (mas de una linea)
	private JTextArea textArea;

	public StatusPanel() {
		setLayout(new FlowLayout());
		initComponents();
	}

	private void initComponents() {
		lbStatus = new JLabel("Barra de estado");
		// Aqui inicializamos nuestro textField indicando nuestro numero de columnas(que
		// es el numero de caracteres maximo)
		textField = new JTextField(20);
		textField.addActionListener(event -> {
			// Va a realizar cuando se ponga un enter, el evento que hemos programado en el
			// boton de abajo
			button.doClick();
		});
		// Aqui lo que hacemos es que añadimos nuestro KeyListener y decimos que en esta
		// clase se encuentran los metodos necesarios
		textField.addKeyListener(this);
		// Esta es otra forma en la que cuando presionemos un boton al lado de nuestro
		// textfield pues salga el mensaje
		button = new JButton("Buscar");
		// Tambien podemos añadirle una funcion a nuestro texto, y es que cuando
		// presionemos enter una vez hayamos seleccionado nuestro textfield, se
		// producira el evento que hemos programado, en este caso, saltara un mensaje de
		// informacion
		button.addActionListener(event -> {
			JOptionPane.showMessageDialog(null, "Buscar", "Buscar", JOptionPane.INFORMATION_MESSAGE);
		});
		// Aqui inicializamos nuestro TextArea y especifica que solo puede haber 4 filas
		// como maximo y en cada fila 10 caracteres como maximo
		textArea = new JTextArea(4, 10);
		add(lbStatus);// Al panel le añadimos nuetro label
		add(textField);
		add(button);
		add(textArea);
	}

	/**
	 * Aqui lo que hemos hecho, es que como vamos a usar un KeyListener, pues
	 * tuvimos que implementar su interfaz ya que cuenta con 3 metodos que tenemos
	 * que sobreescribir. Entonces desde aqui modificaremos estos metodos.
	 * RECORDEMOS que los Keylistener tiene varios usos, entre los que destaca el
	 * hecho de que nosotros por ejemplo en google escribimos jopt y google ya nos
	 * muestra una serie de sugerencias, pues el KeyListener hace lo mismo
	 */

	// Este metodo es el que lee los caracteres que estamos escribiendo
	@Override
	public void keyTyped(KeyEvent e) {
		if (textField.getText().length() > 4) {
			System.out.println("Lanzo la busqueda");
		}
	}

	// Este metodo es el que detecta si hemos pulsado un boton
	@Override
	public void keyPressed(KeyEvent e) {
	}

	// Este metodo es el que detecta si hemos soltado un boton. Recordemos que
	// muchas veces en distintos programas, tener pulsado un boton en una opcion y
	// no soltar en ese mismo boton, significa que el evento no se ejecutara, por
	// tanto es necesario que se pulse y suelte el teclado o raton para que se
	// ejecute un evento
	@Override
	public void keyReleased(KeyEvent e) {
	}
}
