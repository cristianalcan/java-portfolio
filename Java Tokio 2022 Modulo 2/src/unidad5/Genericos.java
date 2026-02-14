package unidad5;

import java.util.ArrayList;
import java.util.List;

public class Genericos {

	public static void main(String[] args) {
		List<Object> lista1 = new ArrayList<>();
		List<Integer> lista2 = new ArrayList<>();

		lista1.add(12);
		lista1.add("hola");

		ArrayCola<Integer> cola = new ArrayCola<>();//Ponemos arraycola ya que es la que implementa iterable
		cola.enColar(3);
		cola.enColar(7);
		cola.enColar(5);
		cola.enColar(9);

		Cola<Integer> auxC = new ArrayCola<>();
		while (!cola.Vacia()) {
			int aux = cola.desEnColar();
			System.out.println(aux);
			auxC.enColar(aux);
		}
		System.out.println("Cola Vacia");
		while (!auxC.Vacia()) {
			cola.enColar(auxC.desEnColar());
		}
		System.out.println("Cola iterable");
		for (Integer i : cola) {
			System.out.println(i);
		}
		System.out.println(cola.Vacia());

	}

}
