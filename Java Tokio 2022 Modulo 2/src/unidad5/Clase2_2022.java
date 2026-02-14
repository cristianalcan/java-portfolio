package unidad5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Clase2_2022 {

	public static void main(String[] args) {
		Collection<Integer> col1;
		List<Integer> l1;
		ArrayList<Integer> al1;
		LinkedList<Integer> al2;

		l1 = new ArrayList<Integer>();
		l1.add(10);
		col1 = new LinkedList<Integer>();
		col1.add(24);

		al2 = new LinkedList<>();
		al2.add(35);

		List<Object> listagen = new ArrayList<Object>();
		listagen.add("Texto");
		listagen.add(10);

		Pila<Integer> pila = new Pila<Integer>(null);

		Stack<Integer> st = new Stack<Integer>();// Lo que hace esta clase es seguir una estructura que siempre modifica
													// el ultimo elemento
		st.push(null);// Con esto añado un elemento en vez de el add, concretamente el ultimo elemento
		st.pop();// Con esto elimino un elemento, concretamente el ultimo, en lugar de usar el
					// remove
		

	}

}
