package unidad5;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class clase3 {

	public static void main(String[] args) {
		// Recordemos que para usar la interfaz set y que la funcionalidad principal es
		// que no contenga elementos duplicados es necesario implementar en los objetos
		// que vayamos a utlizar que presenten los metodos equals y hashcode
		Set<Integer> lista = new HashSet<>();
		lista.add(4);// No puede contener elementos duplicados
		lista.add(4);

		Set<ObjetoSimple> los = new HashSet<>();
		Set<ObjetoSimple> los2 = new LinkedHashSet<>();// Es practicamente lo mismo que hashset solo que para iterar los
														// elementos es mas eficiente, y para buscar elementos concretos
														// es menos eficiente
		ObjetoSimple ob1 = new ObjetoSimple(5, "hola");
		ObjetoSimple ob2 = new ObjetoSimple(5, "hola");

		los.add(ob1);
		los.add(ob2);

		Set<Integer> lordenada = new TreeSet<>();// Esta implementacion ordena los elementos de acuerdo a su valor de
													// menos a mas, hay que recordar que los elementos que vayan a ser
													// alineados de menor a mayor tienen que implementar comparable
		lordenada.add(5);
		lordenada.add(2);
		lordenada.add(3);
		lordenada.add(1);
		lordenada.add(6);

		for (int i : lordenada) {
			System.out.println(i);
		}
		System.out.println("-------------------------");

		Set<ObjetoSimple> losOrdenada = new TreeSet<ObjetoSimple>();
		ObjetoSimple obs1 = new ObjetoSimple(3, "hola");
		ObjetoSimple obs2 = new ObjetoSimple(1, "hola");
		ObjetoSimple obs3 = new ObjetoSimple(4, "hola");
		ObjetoSimple obs4 = new ObjetoSimple(2, "hola");

		losOrdenada.add(obs1);
		losOrdenada.add(obs2);
		losOrdenada.add(obs3);
		losOrdenada.add(obs4);

		for (ObjetoSimple i : losOrdenada) {
			System.out.println(i);
		}
		System.out.println("--------------------------");

		System.out.println(los.size());
		System.out.println("Fin de programa");

	}

}
