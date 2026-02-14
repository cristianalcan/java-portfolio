package unidad3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class hilo5 extends Thread {
	private CyclicBarrier cb;

	public hilo5(CyclicBarrier cb) {
		super();
		this.cb = cb;
	}

	@Override
	public void run() {
		System.out.println("Hilo " + getName());
		try {
			sleep(new Random().nextInt(100));
			cb.await();// Si dentro del tiempo que hemos establecido en el sleep de arriba, no se han
						// ejecutado todos los hilos, con este await se ejecutaran todos al mismo
						// tiempo,OJO, hay que tener en cuenta que nuestro programa puede que este
						// ejecutando otros hilos antes y tambien use un sleep, pues ese tiempo se descontara tambien
			System.out.println("Fin hilo " + getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
