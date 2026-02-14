package unidad7;

import java.util.Random;

public interface Interface1 {
	public final int x = 10;

	public void funcion1();

	public abstract int funcion2();

	public static void funcion4() {
		System.out.println("Mensaje desde funcion estatica");
	}

	default int funcion5() {
		return new Random().nextInt(100) + x;
	}

}
