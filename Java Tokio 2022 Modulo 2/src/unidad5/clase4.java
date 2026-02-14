package unidad5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class clase4 {

	public static void main(String[] args) {
		Stack<Integer> pila = new Stack<>();
		pila.clear();// Es para limpiar toda la lista, para eliminar todos los elementos
		pila.push(5);
		pila.push(4);
		pila.push(23);
		pila.push(7);
		pila.push(2);
		pila.push(8);

		Stack<Integer> auxP = new Stack<>();// Este stack lo creamos porque en este caso queremos mostra el elemento 23,
											// y para mostrarlo tenemos que eliminar los elementos que estan arriba de
											// el, y entonces lo que haremos sera guardar los elementos que tendremos
											// que eliminar para mostrar el 23
		while (!pila.isEmpty()) {
			int aux = pila.pop();
			if (aux == 23) {
				System.out.println("Encontrado");
			}
			auxP.push(aux);
		}
		System.out.println(pila.size() + " " + auxP.size());
		while (!auxP.isEmpty()) {
			pila.push(auxP.pop());
		}
		System.out.println(pila.size() + " " + auxP.size());

		Queue<Integer> cola = new ArrayDeque<>();// Es un array de cola y con el remove elimina el primer elemento, hay
													// que tener claro que es un Queue y es una cola, muy parecido al
													// Stack pero en este caso elimina el primer elemento y añade en la
													// ultima posicion un elemento
		Queue<Integer> cola2 = new PriorityQueue<>();// Esta cola se ira ejecutando segun la prioridad que tu le hayas
														// dado a los elementos
		// cola2.poll(); este metodo es para eliminar los elementos de la cola

		// Ejemplos que son buenos para utilizar Map es el caso de una persona, ya que
		// podemos asociar su NIF con su Nombre y demas datos
		Map<Integer, String> dic = new HashMap<>();// Esta implementacion almacenara las claves en una tabla hash
		Map<Integer, String> dic3 = new LinkedHashMap<>();// Esta implementacion es la mas adecuada cuadno tenemos
															// muchos datos
		Map<Integer, String> dic2 = new TreeMap<>();// Esta implementacion ordenara los elementos segun su valor, y
		// debemos implementar la funcion comparable
		// Map es la mejor implementacion para buscar elementos ya que con sabernos
		// las claves podemos acceder al valor, el problema viene si no nos sabemos las
		// claves
		dic2.put(123, "Luis");
		dic2.put(345, "Pedro");
		dic2.put(234, "Antonio");
		dic2.put(678, "Ana");
		dic2.put(434, "Maria");

		System.out.println(dic2.get(678));// Con la clave nos muestra el Valor del elemento
		Collection<String> lista = dic2.values();// Esto basicamente es para iterar todos los valores

	}

}
