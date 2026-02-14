package unidad3;

import java.util.concurrent.Callable;

public class hilo7 implements Callable<String> {
	private String mensaje;

	public hilo7(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);// Espero 1 segundo para que el future me devuelva el dato, hay que tener en
							// cuenta que si hay otro metodo que tenemos que ejecutar despues del get, se
							// mostrara tambien despues de 1 segundo
		return mensaje;
	}

}
