package unidad4;

public enum GradoAcademico {
	ESO(1, "Educacion Secundaria Obligatoria"), BACHILLER(2, "Bachiller"), FP(3, "Formacion Profesional"),
	UNIVERSITARIO(4, "Universitario"), ESPECIAL(5, "Regimen especial");

	private int nivel;
	private String texto;

	GradoAcademico(int nivel, String texto) {
		this.nivel = nivel;
		this.texto = texto;
	}

	public int getNivel() {
		return nivel;
	}

	@Override
	public String toString() {// Esto es para que cuando imprimamos el grado academico aparezca el texto
		return texto;
	}

	public double SalarioMinimo() {
		switch (this) {// Estamos hablando de este enumerado como tal, y engloba todas las constantes
		case ESO:
			return 1200;
		case BACHILLER:
			return 1500;
		case FP:
			return 1800;
		case UNIVERSITARIO:
			return 2500;
		}
		return 0;
	}

}
