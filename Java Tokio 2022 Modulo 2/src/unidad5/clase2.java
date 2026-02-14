package unidad5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class clase2 {
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();// Hay diferencias entre declarar unas variables con list o con arraylist y
		// es basicamente los metodos que nos ofrecen, cuando implementamos con
		// ArrayList tenemos mas metodos, lo mismo pasa con Vector
		ArrayList<Integer> al = new ArrayList<>();
		List<Integer> l2 = new Vector<>();
		Vector<Integer> v = new Vector<>();
		l1.add(12);
		l1.add(0, 10);// En el primer numero indica la posicion que va a reemplazar
		l1.add(11);
		l1.add(2);
		l1.add(20);
		System.out.println(l1.contains(10));// Esto es para ver si la lista contiene el elemento 10
		l1.get(0);// Esto es para obtener el elemento de la posicion, en este caso, en 0
		l1.isEmpty();// Para saber si esta vacio
		// l1.remove(0) con este metodo podemos eliminar el elemento tanto por su nombre
		// como por su posicion
		l1.sort((o1, o2) -> o1 - o2);// Con esto ordeno la lista y es que va a ir de menor a mayor, si fuese o2 -o1
		// seria de mayor a menor los elementos
		for (Integer num : l1) {
			System.out.println(num);
		}
		Stack<Integer> s = new Stack<>();// Es una lista que es una "pila" ya que solo se modifica el ultimo elemento y
		// por tanto solo deberiamos usar estos 3 metodos
		System.out.println("--------------------");
		s.push(5);
		s.push(8);
		s.push(2);
		s.push(4);
		s.push(9);
		System.out.println(s.peek());// Me devuelve el ultimo numero que contiene el stack
		System.out.println(s.pop());// Con esto elimina el ultimo elemento del stack
		System.out.println(s.peek());// Me muestra el actual ultimo elemento del stack
		s.push(3);
		System.out.println(s.peek());
		System.out.println("--------------------");
		while (!s.isEmpty()) {// Mientras no haya acabado
			System.out.println(s.pop());// Se muestran todos los elementos hasta llegar al ultimo
		}
		LinkedList<Integer> ll = new LinkedList<>();// Para trabajar con muchos datos esta es la mejor implementacion,
													// tiene los mismo metodos que arraylist y funciona practicamente
													// igual
	}

}
