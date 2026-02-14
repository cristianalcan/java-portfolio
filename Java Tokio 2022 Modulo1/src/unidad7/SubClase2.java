package unidad7;

import java.util.Random;

public class SubClase2 implements Interface1 {
	private int x;

	public SubClase2() {
		x = new Random().nextInt(100);
	}

	@Override
	public void funcion1() {
		System.out.println("Aleatorio " + x);

	}

	@Override
	public int funcion2() {
		return x / Interface1.x;
	}

	public void funcion3() {
		System.out.println("Hola desde SubClase2");

	}

	@Override
	public int funcion5() {
		return 150;
	}

}
