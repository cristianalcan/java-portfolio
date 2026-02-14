package unidad6;

import java.util.Random;

public abstract class Estudiante {
	protected String nombre;
	protected int edad;
	protected String telefono;
	protected String correo;
	private double[] notas;

	public Estudiante(String nombre, int edad, String telefono, String correo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.telefono = telefono;
		this.correo = correo;
		notas = new double[10];
		for (int i = 0; i < notas.length; i++) {
			notas[i] = new Random().nextDouble() * 10; // Con esto generamos 10 numeros random entre 0 y 10
		}
	}

	public Estudiante(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		notas = new double[10];
		for (int i = 0; i < notas.length; i++) {
			notas[i] = new Random().nextDouble() * 10;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public double NotaFinal() {
		double sum = 0;
		for (int i = 0; i < notas.length; i++) {
			sum += notas[i];
		}
		return Math.round(sum / notas.length * 100) / 100.0;
	}

	public abstract String Titulacion();

	@Override
	public String toString() {
		return "Soy el estudiante " + nombre; // Con esto enseñamos los nombres del array
	}

	public boolean Aprobado() {

		if (this instanceof Diurno) {
			System.out.print("Diurno ");
			if (NotaFinal() >= 5 && ((Diurno) this).Proyecto() >= 5) { // Se castea this para que aparezca el metodo
																		// proyecto
				return true;
			} else {
				return false;
			}

		}
		if (this instanceof Tarde) {
			System.out.print("Tarde ");
			if (NotaFinal() >= 5 && ((Tarde) this).Progreso() >= 90) {
				return true;
			} else {
				return false;
			}
		}
		System.out.print("Estudiante ");
		if (NotaFinal() >= 5)
			return true;

		return false;
	}

}
