package unidad8;

import java.util.Scanner;

public class EntradaDatosException {
	public static int entradaEntero() {
		Scanner entrada = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("Introduce un numero");
				return Integer.parseInt(entrada.nextLine());
			} catch (Exception e) {
				System.out.println("Error en el numero");
			}
		}
	}
}
