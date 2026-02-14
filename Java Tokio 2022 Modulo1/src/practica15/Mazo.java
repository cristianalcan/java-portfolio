package practica15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import practica17.OrdenDistNatural;

public class Mazo {
	List<Carta> cartas;
	private AlgoritmoOrdenacion algoritmo;

	public void setAlgoritmo(AlgoritmoOrdenacion algoritmo) {
		this.algoritmo = algoritmo;

	}

	/**
	 * Este metodo nos permite ordenar nuestras cartas en un orden distinto del
	 * natural
	 * 
	 * @param o es nuestro objeto de la Clase OrdenDistNatural, que nos va a servir
	 *          para poder utilizar el metodo ordenar de la clase OrdenDistNatural
	 */
	public void ordenaDistinto(OrdenDistNatural o) {
		o.ordenar(cartas);
	}

	/**
	 * Con este metodo vamos a ordenar las cartas en un orden Natural, es decir,
	 * primero por el orden del tipo de palo que se ha implementado en la clase
	 * Baraja, y luego en orden ascendente de los numeros
	 */
	public void ordenaNatural() {
		cartas.sort(comparadorCarta);

	}

	/**
	 * Aqui implementamos la interfaz funcional Comparator para ordenar las clases
	 * primero por orden Natural y luego, por valor de la carta
	 */
	Comparator<Carta> comparadorCarta = (c1, c2) -> {
		if (c1.ordenNatural() > c2.ordenNatural()) {
			return 1;
		} else if (c1.ordenNatural() < c2.ordenNatural()) {
			return -1;
		}
		return c1.compareTo(c2);
	};

	/*
	 * Los metodos siguientes no nos haran falta, excepto el toString, por eso no
	 * las voy a comentar
	 */

	public Mazo() {
		cartas = new ArrayList();
	}

	public Carta getCarta(int posicion) {
		return (Carta) cartas.get(posicion);
	}

	public void insertarCarta(int posicion, Carta carta) {
		List<Carta> aux = new ArrayList<>();
		for (int i = cartas.size() - 1; i >= posicion; i--) {
			aux.add((Carta) cartas.remove(i));
		}
		cartas.add(carta);
		for (int i = aux.size() - 1; i >= 0; i--) {
			cartas.add(aux.get(i));
		}
	}

	public Carta extraerCarta(int posicion) {
		return (Carta) cartas.remove(posicion);
	}

	public Carta extraerCarta() {
		return (Carta) cartas.remove(cartas.size() - 1);
	}

	public void anadirCarta(Carta carta) {
		cartas.add(carta);
	}

	public int numCartas() {
		return cartas.size();
	}

	public void barajar() {
		Collections.shuffle(cartas);
	}

	@Override
	public String toString() {
		return "" + cartas;
	}

}
