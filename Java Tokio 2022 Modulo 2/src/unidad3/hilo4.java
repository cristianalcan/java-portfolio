package unidad3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class hilo4 extends Thread {
	private CountDownLatch cont;

	public hilo4(CountDownLatch cont) {
		super();
		this.cont = cont;
	}

	@Override
	public void run() {
		System.out.println("Hilo "+getName());
		try {
			sleep(new Random().nextInt(100));
			cont.countDown();//Esto es para que cuando se ejecute el hilo, se reduzca en uno el numero de hilos a ejecutar
			System.out.println(cont.getCount());//Con esto vemos la cantidad de hilos que hay
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
