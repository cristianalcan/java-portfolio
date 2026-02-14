package practica15;

import java.util.Comparator;
import java.util.List;

public class OrdPalNumDec extends AlgoritmoOrdenacion  {

	@Override
	public void ordenar(List<Carta> listaCartas) {
		listaCartas.sort(comparadorCarta);
	}
	Comparator<Carta> comparadorCarta = (c1, c2) -> {
		if (c1.getPalo().compareTo(c2.getPalo()) < 0) {
			return -1;
		} else if (c1.getPalo().compareTo(c2.getPalo()) > 0) {
			return 1;
		}
		return comparadorCarta(c1, c2);
	};
	public static int comparadorCarta(Carta c1, Carta c2) {
		if (c1.obtenerValor() > c2.obtenerValor()) {
			return -1;
		} else if (c1.obtenerValor() < c2.obtenerValor()) {
			return 1;
		}
		return 0;
	}

}
