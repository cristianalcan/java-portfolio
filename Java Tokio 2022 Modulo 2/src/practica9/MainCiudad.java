package practica9;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainCiudad {

	public static void main(String[] args) {
		List<Ciudad> ciudades = new ArrayList<>();
		Ciudad madrid = new Ciudad("Madrid", "Madrid", 10000);
		Ciudad barcelona = new Ciudad("Cataluña", "Barcelona", 20000);
		Ciudad valencia = new Ciudad("Comunidad Valenciana", "Valencia", 5000);
		Ciudad almeria = new Ciudad("Andalucia", "Almeria", 3000);
		Ciudad lugo = new Ciudad("Galicia", "Lugo", 500);
		ciudades.add(madrid);
		ciudades.add(barcelona);
		ciudades.add(valencia);
		ciudades.add(almeria);
		ciudades.add(lugo);

		// ¿Cuántas ciudades hay en total?
		System.out.print("Numero de ciudades: ");
		System.out.println(ciudades.size());

		// ¿Cuántas ciudades de “Madrid” tienen más de 1.000 habitantes?
		System.out.print("Ciudades de Madrid con mas 1000 habitantes: ");
		Predicate<Ciudad> masHabitantes = c -> {
			if (c.getProvincia() == "Madrid" && c.getHabitantes() > 1000) {
				return true;
			}
			return false;
		};
		System.out.println(ciudades.stream().filter(masHabitantes).count());

		// ¿De que provincias son las ciudades?
		System.out.println("Provincias de las ciudades: ");
		ciudades.forEach(c -> System.out.println(c.getProvincia()));

		// ¿De cuantas provincias diferentes son las ciudades?
		System.out.print("Provincias diferentes: ");
		System.out.println(ciudades.stream().distinct().count());// En la clase Ciudad implementé hashCode y equals,pero
																	// quite la compracion de numero de habitantes y
																	// solo puse que fueran repetidos los que tuvieran
																	// mismo nombre y provincia

		// ¿Alguna ciudad de Madrid tiene más de 50.000 habitantes?
		System.out.print("Ciudad de Madrid con mas de 50000 habitantes: ");
		Predicate<Ciudad> mas50 = c -> {
			if (c.getProvincia() == "Madrid" && c.getHabitantes() > 50000) {
				return true;
			}
			return false;
		};
		System.out.println(ciudades.stream().filter(mas50).count());

		// HOLA LUIS MIGUEL, tengo unas pequeñas dudas con respecto a este tema, el
		// primero es como yo podria agregar todos los objetos creados(por ejemplo las 5
		// ciudades de arriba) sin tener que poner ciudades.add para cada ciudad, si
		// llego a tener 100 objetos eso seria muy poco eficiente, en segundo lugar, te
		// queria preguntar con la expresion lambda de arriba el mas50, yo creo que
		// soluciona muy bien la duda de la practica, pero sin embargo me gustaria saber
		// como yo podria con tan solo poner la lista de ciudades y con que haya una
		// ciudad que cumpla con los requisitos en este caso ser mayor de 50000
		// habitantes y de Madrid me de true, lo que pasa es que ya lo intente con un
		// foreach pero la verdad no me gusta como queda ya que examina evidentemente
		// ciudad a ciudad y me devuelve true o false por cada ciudad, entonces se me
		// llena de essas respuestas... por eso queria saber si tu ves alguna otra forma
		// en la que con que una ciudad cumpla la condicion me de true, pero solo un
		// true para toda la lista, o si ninguna ciudad se cumple, que me de solo un
		// false. Te agradeceria si me contestaras como mensaje de correcion de esta
		// practica y si ves algo que mejorar, para hacer mi programa mas eficiente o
		// que me podria ayudar, que me lo comentases, muchas gracias por todo!

	}

}
