package unidad5;

public class Percusion extends Instrumento {

	@Override
	public String tocar(String nota) {
		return "golpear " + nota;
	}

}
