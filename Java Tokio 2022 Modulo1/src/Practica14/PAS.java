package Practica14;

/**
 * Superclase para los trabajadores que si que cuenten con horas extra, como los
 * Informaticos y los Administrativos
 * 
 * @author crist
 *
 */
public class PAS extends Personal {
	protected int horasTrabajoAdicional;

	public PAS(String nombre, String dni, int horasTrabajoAdicional) {
		super(nombre, dni);
		this.horasTrabajoAdicional = horasTrabajoAdicional;
	}

	public int getHorasTrabajoAdicional() {
		return horasTrabajoAdicional;
	}

}
