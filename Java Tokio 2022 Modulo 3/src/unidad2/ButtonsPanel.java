package unidad2;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel {
	private JButton button1, button2, button3, button4;
	public ButtonsPanel() {
		/**
		 * Al primer panel que es el de los botones le vamos a poner el flow layout que
		 * recordemos que organiza los componentes de izquierda a derecha y de arriba a
		 * abajo
		 */
		setLayout(new FlowLayout());
		initComponents();
	}
	private void initComponents() {
		button1 = new JButton("Button 1");
		button2 = new JButton("Button 2");
		button3 = new JButton("Button 3");
		button4 = new JButton("Button 4");
		/**
		 * Le añadimos los botones a nuestro panel de botones
		 */
		add(button1);
		add(button2);
		add(button3);
		add(button4);
	}
}
