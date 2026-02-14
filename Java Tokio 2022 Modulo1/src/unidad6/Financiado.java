package unidad6;

public class Financiado extends Diurno {

	public Financiado(String nombre, int edad, double asistencia) {
		super(nombre, edad, asistencia);
	}

	@Override
	public String Titulacion() {
		return "Nivel Medio Informatica Privado";
	}

}
