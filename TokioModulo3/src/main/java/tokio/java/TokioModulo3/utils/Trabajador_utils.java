package tokio.java.TokioModulo3.utils;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import tokio.java.TokioModulo3.DAOInterfaces.TrabajadorDAO;
import tokio.java.TokioModulo3.models.Trabajador;

public class Trabajador_utils {
	/**
	 * Esta funcion nos sirve para importar los datos de los trabajadores. Es static
	 * para que no tengamos que crear un objeto de esta clase para poder usar el
	 * metodo
	 * 
	 * @return una lista de trabajadores
	 */
	public static List<Trabajador> importarDatos() {
		List<Trabajador> l = new ArrayList<>();
		try {
			Reader in = new FileReader("resource/file.csv");// Ponemos resource asi porque se encuentra en esa carpeta
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
			for (CSVRecord record : records) {
				String nombre = record.get(0);// Se pone 0 ya que es la posicion en la que se encuentra en el fichero
				int edad = Integer.parseInt(record.get(1));
				double salario = Double.parseDouble(record.get(2));
				// l.add(new Trabajador(nombre, edad, salario));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	public static void accesoTrabajadores(TrabajadorDAO accesoDatos) {
		accesoDatos.insertarTrabajador(new Trabajador("98765432E", "Ricardo", "alguna calle", 36));
	}

}
