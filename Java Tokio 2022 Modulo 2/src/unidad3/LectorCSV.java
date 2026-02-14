package unidad3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class LectorCSV implements Callable<Integer> {
	AtomicLong analizado;// Esto sera para aumentarle la cantidad de datos que hemos cargado, ya que es
							// un archivo grande

	public LectorCSV(AtomicLong analizado) {
		this.analizado = analizado;

	}

	@Override
	public Integer call() throws Exception {
		File f = new File("datos_cita_previa.csv");
		BufferedReader br = new BufferedReader(new FileReader(f));
		String linea = br.readLine();
		int cont = 0;
		while ((linea = br.readLine()) != null) {
			analizado.addAndGet(linea.getBytes().length);// Se pone el getbyte para saber la cantidad de bytes que se
															// han almacenado del texto, y length para el tamaño
			String[] aux = linea.split(";");
			if (aux[6].equals("Si")) {
				cont++;
			}
			if (cont % 100 == 0) {
				Thread.sleep(1);
			}

		}
		br.close();
		return cont;
	}
}
