package unidad6;

public class Beca extends Diurno {

	public Beca(String nombre, int edad, double asistencia) {
		super(nombre, edad, asistencia);
	}

	@Override
	public String Titulacion() {
		return "Nivel Medio Informatica Publico";
	}

}
