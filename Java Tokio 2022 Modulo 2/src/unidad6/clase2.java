package unidad6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class clase2 {
	public static void main(String[] args) {
		Calculadora suma = (n1, n2) -> (n1 + n2);
		Calculadora resta = (n1, n2) -> (n1 - n2);
		Calculadora multiplicacion = (n1, n2) -> (n1 * n2);
		Calculadora division = (n1, n2) -> (n1 / n2);
		List<Calculadora> operaciones = new ArrayList<>();
		operaciones.add(suma);
		operaciones.add(resta);
		operaciones.add(multiplicacion);
		operaciones.add(division);
		// Cuando no queremos o no tenemos una interfaz funcional, podemos usar la
		// interfaz Function, el primer parametro es el tipo que recibimos y el segundo
		// parametro es el tipo que retorna. Hay que recordar que del lado izquierdo del
		// operador lambda se encuentran los parametros, en este caso ops representa la
		// lista de calculadora y retornara un entero que es el tamaño de la lista
		Function<List<Calculadora>, Integer> tamaño = ops -> ops.size();
		System.out.println("Tamaño " + tamaño.apply(operaciones));// Para ejecutar el cuerpo lambda con esta interfaz
																	// usamos este metodo

		Function<Integer, Void> repetir = n -> {// Cuando ponemos el tipo void que retorne, no hace ni falta que
												// ejecutemos la expresion lambda dentro de un syso
			for (int i = 0; i < n; i++) {
				System.out.println("Hola " + i);
			}
			return null;// Se tiene que poner un return de forma obligatoria, lo ponemos null para que
						// no retorne nada
		};

		repetir.apply(5);

		List<ObjetoSimple2> lista = new ArrayList<>();
		ObjetoSimple2 obs1 = new ObjetoSimple2(3, "hola");
		ObjetoSimple2 obs2 = new ObjetoSimple2(1, "hola");
		ObjetoSimple2 obs3 = new ObjetoSimple2(4, "hola");
		ObjetoSimple2 obs5 = new ObjetoSimple2(4, "adios");
		ObjetoSimple2 obs4 = new ObjetoSimple2(2, "hola");

		lista.add(obs1);
		lista.add(obs2);
		lista.add(obs3);
		lista.add(obs4);
		lista.add(obs5);

		// Para ordenar elementos viene bien crear expresiones lambda
		Comparator<ObjetoSimple2> compararTexto = (ob1, ob2) -> ob1.getTexto().compareTo(ob2.getTexto());
		lista.sort(compararTexto);
		lista.forEach(el -> System.out.println(el));// Aqui solo comparamos el texto, y los numeros dan igual
		System.out.println();

		lista.sort((ob1, ob2) -> {// Aqui ya estariamos ejecutando la expresion lambda, hay que tener en cuenta
									// que hemos creado la expresion lambda dentro del parametro que nos pide un
									// comparador, en este caso nuestra expresion lambda es el comparador
			if (ob1.getNum() < ob2.getNum()) {
				return -1;
			} else if (ob1.getNum() > ob2.getNum()) {
				return 1;
			}
			return ob1.getTexto().compareTo(ob2.getTexto());// Con esto se compara los textos, y se ordena en orden
															// alfabetico
		});

		lista.forEach(el -> System.out.println(el));// Con este metodo mostramos todos los elementos de la lista de
													// forma ordenada en cuanto a numeros y luego texto

	}
}
