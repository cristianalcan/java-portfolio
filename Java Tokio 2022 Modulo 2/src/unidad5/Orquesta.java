package unidad5;

public class Orquesta {
	Instrumento[] instrumentos;

	public Orquesta(Instrumento[] instrumentos) {
		super();
		this.instrumentos = instrumentos;
	}

	public String tocar(String nota) {
		String dev = "";
		for (int i = 0; i < instrumentos.length; i++) {
			dev += instrumentos[i].tocar(nota);
		}
		return dev;
	}
}
