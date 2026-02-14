package unidad6;

import java.util.Random;

public abstract class Diurno extends Estudiante {
	private double asistencia;

	public Diurno(String nombre, int edad, String telefono, String correo, double asistencia) {
		super(nombre, edad, telefono, correo);
		this.asistencia = asistencia;
	}

	public Diurno(String nombre, int edad, double asistencia) {
		super(nombre, edad);
		this.asistencia = asistencia;
	}

	public double getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(double asistencia) {
		this.asistencia = asistencia;
	}

	public double Proyecto() {

		return Math.round(new Random().nextDouble() * 10 * 100) / 100.0;  //Con esto generamos numeros random entre el 0 y 10
	}

	@Override
	public double NotaFinal() {
		return super.NotaFinal() * 0.6 + Proyecto() * 0.4;    //Con esto hallamos la media entre la nota final y el proyecto
	}

	@Override
	public String toString() {
		return super.toString() + " asisto en el horario Diurno";
	}
	public double NotaExamenFinal() {
		return 8;
	}

}
