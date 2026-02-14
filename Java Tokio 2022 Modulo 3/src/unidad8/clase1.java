package unidad8;

import java.util.Scanner;

public class clase1 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		// En esta unidad de Programacion Segura, estaremos viendo porque la entrada de
		// datos por consola es un peligro. En este caso hay que tener en cuenta algo, y
		// es que nosotros ponemos nextline para que asi el usuario introduzca lo que
		// sea y no de error. Es lo mas generico posible
		String dato = entrada.nextLine();

		/**
		 * Otra cosa a tener en cuenta sera que debemos incluir excepciones en aquellas
		 * partes del programa en las que pueden haber fallos. Por ejemplo en el de
		 * ahora, que vamos a tratar de convertir un string en un entero
		 */
		try {
			int n = Integer.parseInt(dato);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * Otro aspecto importante en nuestros programas es por ejemplo que no cerramos
		 * el scanner, y esto lo que puede provocar es que un atacante interfiera en
		 * nuestro buffer que es el scanner y podria enviar comandos que pueden
		 * perjudicar nuestro programa
		 */
		entrada.close();

	}
}
