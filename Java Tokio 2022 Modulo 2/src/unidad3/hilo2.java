package unidad3;

public class hilo2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Mensaje desde el hilo " + this.getName() + " op " + i);
		}
	}
}
