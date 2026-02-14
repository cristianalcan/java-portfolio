package practica17;

import java.util.Comparator;
import java.util.List;

import practica15.Carta;

public class OrdenDistNatural implements Comparator<Carta> {
	public void ordenar(List<Carta> listaCartas) {
		listaCartas.sort(comparadorCarta);
	}

	/**
	 * Aqui lo que se hace es implementar una interfaz funcional para poder comparar
	 * las cartas primero por orden de valor y luego por su orden Natural, es decir
	 * como viene implementada en la clase Baraja
	 */
	Comparator<Carta> comparadorCarta = (c1, c2) -> {
		if (c1.obtenerValor() < c2.obtenerValor()) {
			return -1;
		} else if (c1.obtenerValor() > c2.obtenerValor()) {
			return 1;
		}
		return compare(c1, c2);
	};

	@Override
	public int compare(Carta c1, Carta c2) {
		if (c1.ordenNatural() > c2.ordenNatural()) {
			return 1;
		} else if (c1.ordenNatural() < c2.ordenNatural()) {
			return -1;
		}
		return 0;
	}
}
