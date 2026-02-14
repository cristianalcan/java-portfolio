package unidad5;

public class Cuerda extends Instrumento {

	@Override
	public String tocar(String nota) {
		return "vibrar " + nota;
	}

}
