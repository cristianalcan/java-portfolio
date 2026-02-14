package componentes;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Aqui se encuentran todos los numeros y operadores que nos haran falta
 * 
 * @author crist
 *
 */
public class DigitosPanel extends JPanel {
	private GridLayout g;
	public JButton uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero, suma, resta, division, multiplicacion,
			punto, igual;

	/**
	 * Detalle, aqui he puesto que se pasen por parametro un GridLayout, y esto lo
	 * he hecho para poder usar el metodo setBorder que lo intente sin tener que
	 * pasar por parametro pero no pude, si ves otra alternativa mejor me gustaria
	 * que me lo comentases(Esto tambien lo hice con la otra clase)
	 * 
	 * @param g
	 */
	public DigitosPanel(GridLayout g) {
		super();
		this.g = g;
		initComponents();
	}

	private void initComponents() {
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setLayout(g);
		g.setHgap(15);
		g.setVgap(15);
		cero = new JButton("0");
		cero.setActionCommand("0");
		uno = new JButton("1");
		uno.setActionCommand("1");
		dos = new JButton("2");
		dos.setActionCommand("2");
		tres = new JButton("3");
		tres.setActionCommand("3");
		cuatro = new JButton("4");
		cuatro.setActionCommand("4");
		cinco = new JButton("5");
		cinco.setActionCommand("5");
		seis = new JButton("6");
		seis.setActionCommand("6");
		siete = new JButton("7");
		siete.setActionCommand("7");
		ocho = new JButton("8");
		ocho.setActionCommand("8");
		nueve = new JButton("9");
		nueve.setActionCommand("9");
		suma = new JButton("+");
		suma.setActionCommand("+");
		resta = new JButton("-");
		resta.setActionCommand("-");
		division = new JButton("/");
		division.setActionCommand("/");
		multiplicacion = new JButton("*");
		multiplicacion.setActionCommand("*");
		punto = new JButton(".");
		punto.setActionCommand(".");
		igual = new JButton("=");
		igual.setActionCommand("");

		add(uno);
		add(dos);
		add(tres);
		add(suma);
		add(cuatro);
		add(cinco);
		add(seis);
		add(resta);
		add(siete);
		add(ocho);
		add(nueve);
		add(multiplicacion);
		add(cero);
		add(punto);
		add(igual);
		add(division);
	}
}
