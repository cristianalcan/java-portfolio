package practica11;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Comprobar {

	public static void main(String[] args) {
		List<Persona> personas = new ArrayList<>();
		Persona jorge = new Persona("Jorge", "12345678E", "jorge@gmail.com");
		Persona luis = new Persona("Luis", "98765432V", "luis@gmail.com");
		Persona ana = new Persona("Ana", "Z12345678K", "ana@gmail.@");
		Persona enrique = new Persona("Enrique", "ZD13848", "@nrique.@hotmail.com");
		Persona guillermo = new Persona("Guillerm0", "X12398745B", "guille.java@outlook.com");
		personas.add(jorge);
		personas.add(luis);
		personas.add(ana);
		personas.add(enrique);
		personas.add(guillermo);

		String nom = "[a-zA-Z]+";
		String documento = "^[a-zA-Z]?[0-9]+[a-zA-Z]";
		String email = "^[a-zA-Z-_]+(\\.[a-zA-Z0-9-_]+)*@[a-zA-Z-_]+\\.[a-zA-Z]+$";
		personas.forEach(p -> System.out.println(
				"El objeto " + p.getNombre() + " tiene el nombre correcto: " + Pattern.matches(nom, p.getNombre())));
		System.out.println();
		personas.forEach(p -> System.out.println(
				"El objeto " + p.getNIF() + " tiene el documento correcto: " + Pattern.matches(documento, p.getNIF())));
		System.out.println();
		personas.forEach(p -> System.out.println(
				"El objeto " + p.getCorreo() + " tiene el correo correcto: " + Pattern.matches(email, p.getCorreo())));

	}

}
