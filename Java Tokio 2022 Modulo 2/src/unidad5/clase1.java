package unidad5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;

import unidad4.GradoAcademico;
import unidad4.Persona;

public class clase1 {

	public static void main(String[] args) {
		List<Integer> lista = new ArrayList<>();
		lista.add(new Random().nextInt(1000));
		lista.add(new Random().nextInt(1000));
		lista.add(new Random().nextInt(1000));
		lista.add(new Random().nextInt(1000));
		lista.add(new Random().nextInt(1000));
		Iterator it = lista.iterator();// Es importante ponerlo despues de que hayamos añadido los elementos a
										// la lista, ya que sino nos dara un error, OTRA COSA IMPORTANTE es
										// porque guardamos la lista.iterator aqui y es para poder usar el
										// metodo hasNext
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		System.out.println("--------------------");
		/*
		 * System.out.println(it.next());// Con esto lo que hacemos es ir sacando los
		 * elementos de la lista, y // generalmente son en orden
		 * System.out.println(it.next());//Este seria el siguiente elemento al de arriba
		 */

		while (it.hasNext()) {// Esta seria la forma correcta de enseñar todos los elementos con un iterador
			System.out.println(it.next());

		}
		System.out.println("--------------------");

		Persona[] personas = { new Persona("Luis", 34, GradoAcademico.UNIVERSITARIO),
				new Persona("Maria", 27, GradoAcademico.FP), new Persona("Ana", 26, GradoAcademico.BACHILLER),
				new Persona("Pedro", 32, GradoAcademico.FP), new Persona("Juan", 24, GradoAcademico.UNIVERSITARIO) };
		GrupoPersona gp = new GrupoPersona(personas);
		Iterator<Persona> it2 = gp.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next().getNombre());

		}
		System.out.println("--------------------");
		for (Persona persona : gp) {// Nosotros implementamos en nuestra clase GrupoPersona el iterable para que asi
									// solo con un for each podamos mostrar los elementos iterados, en este caso los
									// que cumplan las condiciones dentro del next y hasnext de nuestra clase
									// GrupoPersona, asi no hace falta tener que crear lo de arriba. Las clases que
									// implementan iterable normalmente es porque trabajan con muchos datos y
									// funciona como filtro
			System.out.println(persona.getNombre());
		}

	}

}
