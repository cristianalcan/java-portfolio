package unidad3;

public class hilo1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Mensaje desde el hilo " + this.getName() + " op " + i);
			try {
				sleep(0);// Siempre se pone una cantidad de milisegundos porque sera el tiempo que estara
							// dormido o el tiempo qe tardara en ejecutarse la siguiente instruccion del hilo
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
