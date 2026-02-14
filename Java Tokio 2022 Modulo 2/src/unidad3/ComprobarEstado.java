package unidad3;

import java.io.File;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class ComprobarEstado extends Thread {
	AtomicLong analizado;
	Future<Integer> lector;

	public ComprobarEstado(AtomicLong analizado, Future<Integer> lector) {
		super();
		this.analizado = analizado;
		this.lector = lector;
	}

	@Override
	public void run() {
		File f = new File("datos_cita_previa.csv");
		while (!lector.isDone()) {// Mientras lector no haya terminado de ejecutarse y por tanto mostrar datos
			double porcentaje = analizado.get() * 100.0 / f.length();
			System.out.println("Porcentaje leido " + porcentaje);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
