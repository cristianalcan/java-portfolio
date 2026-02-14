package tokio.java.TokioModulo3.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Trabajador {
	private String DNI;
	private String Nombre;
	private String Direccion;
	private int edad;
}
