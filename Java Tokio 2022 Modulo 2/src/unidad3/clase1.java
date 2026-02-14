package unidad3;

public class clase1 {

	public static void main(String[] args) {
		hilo1 h1 = new hilo1();
		hilo2 h2 = new hilo2();
		hilo3 r3 = new hilo3();
		Thread h3 = new Thread(r3);
		h2.setPriority(Thread.MAX_PRIORITY);
		h1.start();
		h2.start();
		h3.start();

		try {
			// Thread.sleep(3000);
			h1.join();// hasta que no se ejecuten todos los elementos del hilo 1, no se mostrara las
						// ejecuciones del programa como el syso terminado
			h2.join();
			h3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Terminado");// Esto se muestra primero por consola ya que pertenece al programa principal,
										// mientras que los hilos se siguen ejecutando pero a su ritmo
	}
}
