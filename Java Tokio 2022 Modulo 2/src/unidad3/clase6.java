package unidad3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class clase6 {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);// Es para poder ejecutar 3 hilos
		Future<String> res = es.submit(new hilo7("Hola Mundo"));// Esto devuelve un future
		try {

			while (!res.isDone()) {// Esto es para saber si ya se ha ejecutado el future
				System.out.println("Esperando por respuesta...");
				Thread.sleep(100);
			}

			/*
			 * while (res.isCancelled()) {// Esto es para preguntar si mi programa esta
			 * cancelado System.out.println("Esperando por respuesta...");
			 * Thread.sleep(100); res.cancel(true);// Al poner esto antes del get da error
			 * porque no nos puede devolver el future }
			 */
			System.out.println(res.get());
			System.out.println("asd2");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		CompletableFuture.runAsync(new hilo3()).whenComplete((x, y) -> System.out.println("Ha terminado "));
		// Con esto solo puedo ejecutar runnable, y se hace de manera asincrona. la gran
		// ventaja de esto es que puedes concatenar funciones, y se ejecutan de manera
		// consecutiva

		CompletableFuture.supplyAsync(() -> {
			try {
				return new hilo7("Hola ").call();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return "";
		}).thenAccept(t -> {
			try {
				t += new hilo7("Mundo").call();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}).whenComplete((mensaje, e) -> System.out.println(mensaje));// La primera variable es lo que devuelve y "e" es
																		// el error

	}
}
