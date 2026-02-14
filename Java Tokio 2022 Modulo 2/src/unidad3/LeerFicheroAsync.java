package unidad3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

public class LeerFicheroAsync {

	public static void main(String[] args) {
		AtomicLong analizado = new AtomicLong(0);
		ExecutorService ex = Executors.newSingleThreadExecutor();
		Future<Integer> res = ex.submit(new LectorCSV(analizado));// Aqui se pone por parametro el analizado
																	// ya que lo va cambiando
		ComprobarEstado ce = new ComprobarEstado(analizado, res);
		ce.start();
		try {
			System.out.println(res.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("FIN");

	}

}
