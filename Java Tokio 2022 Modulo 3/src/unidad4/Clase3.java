package unidad4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import unidad6.ConexionBD;

public class Clase3 {

	public static void main(String[] args) {
		/**
		 * En Java contamos con la clase Locale para saber la localidad del usuario. En
		 * este caso vamos a especificar en el lado izquierdo el idioma que siempre va a
		 * estar en minusculas y en el derecho el pais que siempre va a estar en
		 * mayusculas. Esta clase nos sirve por ejemplo para especificar el idioma de
		 * nuestra aplicacion, aunque tambien por ejemplo si estamos trabajando con
		 * bases de datos pues nos sirve para especificar el idioma de esta
		 */
		// Locale loc = new Locale("en", "USA");
		// System.out.println(loc.getLanguage());// Con esto nos devuelve el idioma,
		// pero la abreviatura o sea es "es"
		// System.out.println(loc.getDisplayLanguage());// Con esto me devuelve el
		// nombre del idioma
		// System.out.println(loc.getCountry());// Con esto me devuelve la abreviatura
		// del pais o sea el "ES"
		// System.out.println(loc.getDisplayCountry());// Con esto me devuelve el nombre
		// del pais
		// System.out.println();

		/**
		 * Para que nosotros podamos obtener el idioma y pais del usuario usaremos esto
		 */
		// loc = Locale.getDefault();
		/*
		 * System.out.println(loc.getDisplayCountry());
		 * System.out.println(loc.getDisplayLanguage()); System.out.println();
		 */
		/**
		 * Esta clase nos permite trabajar directamente con los ficheros que usamos para
		 * traducir, en el lado izquierdo ponemos el nombre de nuestro fichero, aqui
		 * podria haber una confusion en caso de que solo pongamos el nombre de nuestro
		 * fichero, ya que por ejemplo hay 2 con el mismo nombre, por eso al lado
		 * derecho ponemos la localizacion por defecto, en este caso va a seleccionar
		 * nuestro primer fichero, que es textos_es_ES.properties
		 */
//		ResourceBundle lang = ResourceBundle.getBundle("textos", loc);
		/**
		 * Aqui por ejemplo estamos obteniendo el valor de la "variable" saludo de
		 * nuestro fichero, y abajo el valor de pregunta1
		 */
		/*
		 * System.out.println(lang.getString("saludo"));
		 * System.out.println(lang.getString("pregunta1"));
		 */

		/**
		 * Vamos a crear una pequeña aplicacion para poder trabajar con bases de datos
		 */
		Scanner entrada = new Scanner(System.in);
		Locale loc = Locale.getDefault();
		ConexionBD con = new ConexionBD("localhost", "trabajadores", "root", "");
		ResourceBundle idioma = ResourceBundle.getBundle("textos", loc);
		while (true) {
			System.out.println("1- " + idioma.getString("opcion1"));
			System.out.println("2- " + idioma.getString("opcion2"));
			System.out.println("3- " + idioma.getString("salir"));
			int R = Integer.parseInt(entrada.nextLine());
			switch (R) {
			case 1:
				System.out.println(idioma.getString("pedir_titulo"));
				String titulo = entrada.nextLine();
				System.out.println(idioma.getString("pedir_contenido"));
				String contenido = entrada.nextLine();
				con.insertarPublicacion(titulo, contenido);
				break;
			case 2:
				System.out.println(con.obtenerPublicaciones(idioma));
				break;
			case 3:
				break;
			default:
				break;
			}
		}

	}

}
