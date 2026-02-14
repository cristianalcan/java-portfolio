package unidad2;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Esta clase será la ventana de nuestro programa
 * 
 * @author crist
 */
public class WindowFlowLayout extends JFrame {
	/**
	 * Estos seran los atributos de mi ventana, y son botones, uno para aceptar y
	 * otro para cancelar. El textfield es para mostrar un texto
	 */
	private JButton btDeleteName;
	private JButton btQuit;
	private JTextField tfName;

	public WindowFlowLayout() {
		/**
		 * Con esto lo que estamos haciendo es asignar un FlowLayout que dice que los
		 * elementos de mi ventana se van a organizar de izquierda a derecha y de arriba
		 * a abajo
		 */
		setLayout(new FlowLayout());
		initComponents();
		/**
		 * Con esto ajustamos de que nuestros elementos tengan un tamaño minimos visible
		 * y que se ajusten a segun como tengamos abierto la Ventana(el tamaño).
		 */
		pack();
		/**
		 * Con esto lo que estamos diciendo es que cuando ejecutemos nuestra ventana se
		 * muestre esta ventana en el centro de nuestra pantalla
		 */
		setLocationRelativeTo(null);
		/**
		 * Con esto decimos que sea visible
		 */
		setVisible(true);
	}

	/**
	 * Este metodo es para inicializar nuestros botones
	 */
	private void initComponents() {
		btDeleteName = new JButton("Borrar nombre");
		/**
		 * Aqui con el Action Listener lo que estamos haciendo es que nuestro boton
		 * ejecute un codigo, en este caso, cuando se clicla sobre nuestro boton, se va
		 * a borrar el texto. Recordemos que tenemos muchas clases de Listener, y en
		 * este caso se va ejecutar nuestro codigo siempre y cuando se haga un click
		 * sobre este boton. El "event" hace referencia al click
		 */
		btDeleteName.addActionListener(event -> {
			tfName.setText("");
		});
		btQuit = new JButton("Salir");
		/**
		 * Aqui lo que estamos haciendo es que primero, vamos a llamar a esta clase para
		 * confirmar o no la ejecucion de un boton. En la parte "null" es para que esta
		 * confirmacion salga en la posicion central de nuestra pantalla, luego con
		 * "Estas seguro" es el mensaje que se muestra por pantalla, "Salir" es el boton
		 * del que se trata, y luego tenemos la YES_NO_OPTION, y es que nos saldra 2
		 * opciones, si y no, luego lo que hacemos es igualar a la decision NO, y es que
		 * si el usuario ha PULSADO EL BOTON NO, esto es true y por tanto no retorna
		 * nada y el programa sigue, en cambio si el usuario ha PULSADO SI, pues no
		 * seria igual, y esta sentencia se saltaria y entonces se pasaria a system.exit
		 * para finalizar el programa
		 */
		btQuit.addActionListener(event -> {
			if (JOptionPane.showConfirmDialog(null, "Está seguro?", "Salir",
					JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
				return;
			}
			System.exit(0);// Con esto finalizaremos el programa de forma inmediata
		});
		tfName = new JTextField(50);// El 50 es el tamaño maximo del texto
		/**
		 * Con esto añadimos nuestros botones a la ventana
		 */
		getContentPane().add(btDeleteName);
		getContentPane().add(btQuit);
		getContentPane().add(tfName);
	}
}
