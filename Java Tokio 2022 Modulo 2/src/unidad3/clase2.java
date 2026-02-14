package unidad3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class clase2 {
	public static void main(String[] args) {
		ExecutorService ex = Executors.newCachedThreadPool();// Esto es para crear un pool de hilos, y este metodo va a
																// ejecutar todos los hilos y gestionar como se va a
																// ejecutar
		ex.execute(new hilo1());// Esto es para lanzar los hilos
		ex.execute(new hilo2());
		ex.execute(new hilo1());
		ex.shutdown();// Esto es para que no se acepten tareas nuevas, para que no se lancen nuevos
						// hilos
		try {
			ex.awaitTermination(5, TimeUnit.SECONDS);// Aqui controlamos el tiempo en el que queremos que se ejecute la
														// instruccion siguiente, en este caso el syso
			if (ex.isShutdown()) {
				System.out.println("Terminado apagado");// Esto sale en el tiempo que hemos programado siempre y cuando
														// hallamos utilizado el metodo shutdown
			}
			if (ex.isTerminated()) {// Para ver si todos los hilos se han ejecutado
				System.out.println("Terminado completamente");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ExecutorService ex2 = Executors.newFixedThreadPool(2);// Aqui tambien creamos una piscina de hilos pero aqui
																// definiremos la cantidad de hilos, entonces como aqui
																// tenemos 3 hilos lo que pasara es que se ejecutara el
																// tercero cuando se haya terminado alguno de los 2
																// primeros
		ex2.execute(new hilo1());
		ex2.execute(new hilo2());
		ex2.execute(new hilo1());
		try {
			ex2.awaitTermination(22, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ExecutorService ex3 = Executors.newSingleThreadExecutor();// Este metodo sirve para que se ejecuten los hilos 1
																	// por 1, y de manera consecutiva segun hayamos
																	// puesto los hilos
		ex3.execute(new hilo1());
		ex3.execute(new hilo2());
		ex3.execute(new hilo1());

		ScheduledExecutorService ex4 = Executors.newScheduledThreadPool(2);
		ScheduledExecutorService ex5 = Executors.newSingleThreadScheduledExecutor();
		ex4.execute(new hilo1());
		ex4.schedule(new hilo1(), 5, TimeUnit.SECONDS);// Esto es para que despues de 5 segundos se ejecute este hilo
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Mensaje desde runable 1");
			}
		};
		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Mensaje desde runable 2");
			}
		};
		ex4.scheduleAtFixedRate(r1, 3, 1, TimeUnit.SECONDS);// Esto lo que hace es que en 3 segundos se ejecute y luego
															// se mantenga ejecutandose cada 1 segundo
		ex4.scheduleWithFixedDelay(r2, 3, 1, TimeUnit.SECONDS);
		
		try {
			Thread.sleep(10000);//Y con esto decimos que en 10 segundos se duerma y luego no se siga ejecutando los hilos
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ex4.shutdown();
	}
}
