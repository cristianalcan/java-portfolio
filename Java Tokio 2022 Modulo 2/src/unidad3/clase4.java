package unidad3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class clase4 {

	static volatile int x = 10;// Esta variable volatil lo que hace es alertar al programa que puede tener
								// cambios constantes de una manera muy rapida, de un hilo a otro. Esto no
								// garantiza que se sincronicen los datos

	public static void main(String[] args) {
		CountDownLatch cont = new CountDownLatch(8);// Esto te permite tener un contador de hilos sincronizados, ademas
													// de esto es como si tuvieras un .join de todos los hilos.Hasta que
													// no se ejecuten el numero de hilos que he puesto, no habra mas
													// hilos
		for (int i = 0; i < 8; i++) {
			hilo4 h = new hilo4(cont);// Se tiene que poner dentro porque si se pone afuera seria el mismo hilo el que
										// se ejecutaria
			h.start();
		}
		try {
			cont.await();// Cuando se ejecute el bucle for, solo se haran los 8 primeros hilos, ya que es
							// la cantidad que hemos establecido en el count, y ejecutara el syso y luego
							// los 2 hilos restantes
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin del programa");
		CyclicBarrier cb = new CyclicBarrier(8);
		for (int i = 0; i < 8; i++) {
			hilo5 h = new hilo5(cb);
			h.start();
		}
		cb.reset();// Esto lo que hace es reiniciar la cantidad de hilos que puede tener el cyclic
					// barrier

		List<Integer> lista = Collections.synchronizedList(new ArrayList<Integer>());// Con esto hacemos que nuestra
																						// lista este sincronizada
		lista.add(100);
		// while (true) {
		hilo6 h = new hilo6(lista);
		h.start();

		// }

		AtomicBoolean abool = new AtomicBoolean(false);// Los tipos de variables atomic, ya estan sincronizados, aparte
														// de esto para poder usarlos tenemos que usar metodos
		AtomicReference<String> astring = new AtomicReference<>("Hola"); // Esto es para crear una variable que no sea
																			// de tipo primitivo, no es recomendable
																			// ustilizarlo con clases que nosotros
																			// hayamos creado
		System.out.println(abool.compareAndExchange(false, true));
		System.out.println(astring.get());

		System.out.println(x);

		Lock l = new ReentrantLock();// Esto lo que hace es bloquearte la zona critica
		// Lock l2= new ReentrantReadWriteLock(); Esto lo que hace es solo permitir
		// lectura
		l.lock();// Con esto me aseguro que ningun otro hilo ejecute la variable que yo ya estoy
					// ejecutando, y bloquea todos los hilos, y solo se desbloquean con:
		try {// Es recomendable ponerlo en un try finally por si hay cualquier error, los
				// otros hilos se desbloqueen

		} finally {
			l.unlock();
		}
		try {
			while (!l.tryLock(1, TimeUnit.SECONDS)) {// Esto es para que cada 1 segundo se intente desbloquear los demas
													// hilos. Ponemos el "!" por si no ha conseguido desbloquearse antes

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
