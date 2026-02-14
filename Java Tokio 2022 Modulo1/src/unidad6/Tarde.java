package unidad6;

import java.util.Random;

public class Tarde extends Estudiante {
	private String trabajo;

	public Tarde(String nombre, int edad, String trabajo) {
		super(nombre, edad);
		this.trabajo = trabajo;
	}
	public int Progreso() {
		return new Random().nextInt(20)+80;
	}
	@Override
	public String Titulacion() {
		return "Nivel Medio Informatica Diferido";
	}
	public double NotaExamenFinal() {
		return 7;
	}

}
