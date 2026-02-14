package practica17;

import practica15.Baraja;
import practica15.Mazo;

public class EjecutarPractica17 {

	public static void main(String[] args) {
		Baraja baraja = new Baraja();
		Mazo mazo = baraja.getMazo();
		/**
		 * Aqui tenemos nuestro mazo ya creado y lo mostraremos, este mazo se genera en
		 * un orden aleatorio las cartas
		 */
		System.out.println(mazo.toString());
		System.out.println();
		System.out.println("Ordenado primero por orden natural y en orden creciente");
		/**
		 * Aplicamos el metodo que hemos implementado en la clase Mazo para ordenar la
		 * lista de cartas en orden natural y luego en forma creciente
		 */
		mazo.ordenaNatural();
		System.out.println(mazo.toString());
		System.out.println();
		System.out.println("Ordenado primero de forma creciente y en orden natural");
		/**
		 * Aqui lo que hacemos es aplicar un orden distinto del natural
		 */
		mazo.ordenaDistinto(new OrdenDistNatural());
		System.out.println(mazo.toString());
	}

}
