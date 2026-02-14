package unidad6;

import java.util.ArrayList;
import java.util.List;

public class clase4 {

	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>();
		numeros.add(4);
		numeros.add(7);
		numeros.add(2);
		numeros.add(5);
		numeros.forEach(n -> System.out.println(n));
		System.out.println("Con lambda");

		// Que es lo que estamos haciendo aqui, bien pues el foreach nos pide ingresar
		// un consumer, recordemos que un consumer solo nos pide que especifiquemos el
		// dato de entrada, pero no el que retorna, pues bien aqui, lo que pasa es que
		// separamos el syso y ponemos los 4 puntos antes del println que es de tipo
		// VOID, es decir, no retorna nada, como un consumer, y asi se muestran todos
		// los datos de numeros.
		numeros.forEach(System.out::println);// Esto es un METODO REFERENCIADO

		List<ObjetoSimple3> lista = new ArrayList<>();
		ObjetoSimple3 obs1 = new ObjetoSimple3(5, "hola");
		ObjetoSimple3 obs2 = new ObjetoSimple3(5, "hola");
		ObjetoSimple3 obs3 = new ObjetoSimple3(5, "hola");
		ObjetoSimple3 obs5 = new ObjetoSimple3(8, "adios");
		ObjetoSimple3 obs4 = new ObjetoSimple3(2, "hola");

		lista.add(obs1);
		lista.add(obs2);
		lista.add(obs3);
		lista.add(obs4);
		lista.add(obs5);
	}

}
