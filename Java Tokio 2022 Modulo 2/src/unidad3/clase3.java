package unidad3;

import java.util.Random;

public class clase3 {

	public static void main(String[] args) {
		Fichero f = new Fichero();
		Escritor esc = new Escritor(f);
		esc.start();
		while (true) {
			Lector lec = new Lector(f);
			lec.start();
			try {
				Thread.sleep(new Random().nextInt(10000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
