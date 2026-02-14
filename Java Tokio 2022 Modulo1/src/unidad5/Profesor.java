package unidad5;

import java.util.Arrays;
import java.util.Objects;

public class Profesor {
	private String nombreApellido;
	private double salario;
	private int experiencia;
	private Estudiante[] estudiantes;
	private int indice;
	private Estudiante est;

	public Profesor(String nombreApellido, double salario, int experiencia, Estudiante est) {
		super();
		this.nombreApellido = nombreApellido;
		this.salario = salario;
		this.experiencia = experiencia;
		this.est = est;
	}

	public Profesor(String nombreApellido, double salario, int experiencia) {
		super();
		this.nombreApellido = nombreApellido;
		this.salario = salario;
		this.experiencia = experiencia;
		this.estudiantes = new Estudiante[15];
		this.indice = 0;
	}

	public Profesor(String nombreApellido, double salario, int experiencia, Estudiante[] estudiantes) {
		super();
		this.nombreApellido = nombreApellido;
		this.salario = salario;
		this.experiencia = experiencia;
		this.estudiantes = estudiantes;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public double getSalario() {
		return salario;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public boolean agregarEstudiante(Estudiante e) {
		if (indice == estudiantes.length) {
			return false;
		}
		estudiantes[indice++] = e;
		return true;

	}

	public int cantidadEstudiantes() {
		return indice;
	}

	public void eliminarRepetidos() {
		for (int i = 0; i < indice; i++) {
			for (int j = i + 1; j < indice; j++) {
				if (estudiantes[i].equals(estudiantes[j])) {
					eliminar(j);

				}
			}
		}
	}

	private void eliminar(int pos) {
		for (int i = pos; i < estudiantes.length - 1; i++) {
			estudiantes[i] = estudiantes[i + 1];
		}
		indice--;
	}

}
