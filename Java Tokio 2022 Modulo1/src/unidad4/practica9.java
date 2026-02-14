package unidad4;

import java.util.Scanner;

public class practica9 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce una palabra o un texto");
		String palabra = entrada.nextLine();

		int c = 0; // Contador
		for (int i = 0; i < palabra.length(); i++) {

			if (palabra.charAt(i) == 'a' || palabra.charAt(i) == 'A') {
				c++;
			} else if (palabra.charAt(i) == 'e' || palabra.charAt(i) == 'E') {
				c++;
			} else if (palabra.charAt(i) == 'i' || palabra.charAt(i) == 'I') {
				c++;
			} else if (palabra.charAt(i) == 'o' || palabra.charAt(i) == 'O') {
				c++;
			} else if (palabra.charAt(i) == 'u' || palabra.charAt(i) == 'U') {
				c++;
			}

		}
		System.out.println("El numero de vocales es " + c);

	}

}
