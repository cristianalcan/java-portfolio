package practica4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Producto {
	private List<String> productos;
	volatile int cantidad;

	public Producto() {
		super();
		this.productos = Collections.synchronizedList(new ArrayList<String>());
		this.cantidad = 0;
	}

	public void consumirProducto(String p) {
		int cont = 0;
		if (cantidad == 0) {
			synchronized (productos) {
				try {
					productos.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
		synchronized (productos) {
			productos.notifyAll();
		}
		if (cantidad > 0) {
			productos.remove(p);
		}
		cont++;
		cantidad--;
		System.out.println("El cliente " + cont + " ha consumido " + p + " y quedan " + cantidad + " productos");

		try {
			Thread.sleep(1350);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void producirProducto(String p) {
		int cont = 0;
		if (cantidad < 20) {
			productos.add(p);
		}
		cont++;
		cantidad++;
		System.out.println("El productor " + cont + " ha producido " + p + " y quedan " + cantidad + " productos");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (cantidad == 20) {
			try {
				synchronized (productos) {
					productos.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		synchronized (productos) {
			productos.notifyAll();
		}
	}
}
