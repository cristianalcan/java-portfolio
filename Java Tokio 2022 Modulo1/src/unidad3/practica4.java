package unidad3;

import java.util.Scanner;

public class practica4 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		String letra;
		int c = 0;
		boolean punto = false;
		do {
			System.out.println("Introduce caracteres");
			letra = entrada.nextLine();
			for (int i = 0; i < letra.length(); i++) {
				if (letra.charAt(i) == ' ') {
					c++;
				} else if (letra.charAt(i) == '.') {
					punto = true;
					break;
				}

			}

		} while (!punto);
		System.out.println("El numero de espacios es " + c);

	}

}
