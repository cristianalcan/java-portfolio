package unidad6;

public class Online extends Estudiante {

	public Online(String nombre, int edad) {
		super(nombre, edad);
	}

	@Override
	public String Titulacion() {
		return "Nivel Medio Informatica Online";
	}
	

}
