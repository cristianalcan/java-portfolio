package unidad5;

import java.util.Arrays;
import java.util.Objects;

public class Estudiante {
	private String nombre;
	private String curso;
	private int edad;
	private String telefono;

	private double promedio;
	String[] comentarios;

	public Estudiante(String nombre, String curso, int edad, String telefono, double promedio) {

		this.nombre = nombre;
		this.curso = curso;
		this.edad = edad;
		this.telefono = telefono;
		this.promedio = promedio;

	}

	public Estudiante(String nombre, int edad, String telefono) {

		this.nombre = nombre;
		this.edad = edad;
		this.telefono = telefono;
		this.curso = "Sin asignar";
		promedio = 0;
		comentarios = new String[100];
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		if (promedio > 0 && promedio <= 10) {
			this.promedio = promedio;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public String getTelefono() {
		return telefono;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", curso=" + curso + ", edad=" + edad + ", telefono=" + telefono
				+ ", promedio=" + promedio + "]";
	}
	// No seleccionamos comentarios porque al ser un array no se veria por consola

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(comentarios);
		result = prime * result + Objects.hash(curso, edad, nombre, promedio, telefono);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		return nombre.equals(other.getNombre()) && edad == getEdad() && telefono.equals(other.getTelefono());
	}

}
