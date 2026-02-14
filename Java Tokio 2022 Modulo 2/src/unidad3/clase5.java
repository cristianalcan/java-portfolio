package unidad3;

import java.util.Random;

public class clase5 {

	public static void main(String[] args) {
		Estacionamiento est = new Estacionamiento();
		while (true) {
			new Thread(new Runnable() {// Esto se considera una clase anonima ya que solo la creamos para el run

				@Override
				public void run() {
					while (!est
							.estacionarCoche(new Coche(new Random().nextInt(9000) + 1000, new Random().nextInt(120)))) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				}
			}).start();
			;
			try {
				Thread.sleep(1000);//Lo ponemos fuera de la clase anonima, para que se creen hilos cada 1 segundo
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
