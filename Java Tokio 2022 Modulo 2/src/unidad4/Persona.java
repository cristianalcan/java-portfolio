package unidad4;

public class Persona {
	String nombre;
	int edad;
	GradoAcademico grado;

	public Persona(String nombre, int edad, GradoAcademico grado) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.grado = grado;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public GradoAcademico getGrado() {
		return grado;
	}

}
