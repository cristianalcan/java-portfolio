package practica4;

import java.util.Random;

public class Consumidor extends Thread {
	Producto p;

	public Consumidor(Producto p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		while (true) {
			Random boleo = new Random();
			int aleatorio = boleo.nextInt(5);
			try {
				p.consumirProducto(generarProducto(aleatorio));
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String generarProducto(int numero) {
		String[] productos = { "pan", "arroz", "aguacate", "cereales", "pollo" };
		try {
			return productos[numero];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
