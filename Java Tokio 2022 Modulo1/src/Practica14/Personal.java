package Practica14;

/**
 * Esta clase sera abstracta debido a que se tratara de la superclase de los
 * tipos de trabajadores, por tanto no queremos implementar trabajadores de esta
 * clase
 * 
 * @author crist
 *
 */
public abstract class Personal {
	protected String nombre;
	protected String dni;
	protected double salario;

	public Personal(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public double getSalario() {
		return salario;
	}

	/**
	 * Metodo para calcular salario, en si no tendria ni que estar implementado con
	 * los salarios, pero Jorge me dijo que las implementara igualmente
	 * 
	 * @return
	 */
	public double CalcularSalario() {
		if (this instanceof Informatico) {
			salario = 40 * 6 * 4;
		} else if (this instanceof Administrativo) {
			salario = 37 * 7.5 * 4;
		} else if (this instanceof Profesor) {
			salario = 37 * 8 * 4;
		} else if (this instanceof Investigador) {
			salario = 35 * 7 * 4;
		}
		return salario;
	}

	@Override
	public String toString() {
		return "Soy " + nombre;
	}

}
