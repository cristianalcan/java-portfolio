package practica5;

import java.util.Random;

public class Carta {
	private Palo palo;
	private Numero numero;

	public Carta(Palo palo, Numero numero) {
		super();
		this.palo = palo;
		this.numero = numero;
	}

	@Override
	public String toString() {
		return numero.getAbreviatura() + "" + palo.getAbreviatura();
	}

	public static void main(String[] args) {
		Carta[] c = new Carta[8];
		for (int i = 0; i < c.length; i++) {
			c[i] = new Carta(Palo.values()[new Random().nextInt(4)], Numero.values()[new Random().nextInt(10)]);
			System.out.println(c[i]);
		}

	}

}
