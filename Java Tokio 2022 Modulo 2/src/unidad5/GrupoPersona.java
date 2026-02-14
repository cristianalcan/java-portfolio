package unidad5;

import java.util.Iterator;

import unidad4.GradoAcademico;
import unidad4.Persona;

public class GrupoPersona implements Iterable<Persona> {
	private Persona[] personas;

	public GrupoPersona(Persona[] personas) {
		super();
		this.personas = personas;
	}

	@Override
	public Iterator<Persona> iterator() {
		return new Iterator<Persona>() {
			int indice = 0;//Esto es para saber en que posicion nos encontramos

			@Override
			public boolean hasNext() {
				for (int i = indice; i < personas.length; i++) {
					if (personas[i].getEdad() < 30 && (personas[i].getGrado() == GradoAcademico.UNIVERSITARIO
							|| personas[i].getGrado() == GradoAcademico.FP)) {
						return true;

					}
				}
				return false;
			}

			@Override
			public Persona next() {
				for (int i = indice; i < personas.length; i++) {
					if (personas[i].getEdad() < 30 && (personas[i].getGrado() == GradoAcademico.UNIVERSITARIO
							|| personas[i].getGrado() == GradoAcademico.FP)) {
						indice = i + 1;//Con esto pasaria a la siguiente posicion
						return personas[i];

					}
				}
				return null;
			}
		};
	}
}
