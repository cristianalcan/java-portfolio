package unidad4;

import java.util.Random;
import java.util.Scanner;

public class clase1 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int[] x = new int[] { 8, 9, 10, 4, 6, 6, 3, 2, 7, 8 };
		System.out.println(x.length);

		x[0] = 123;
		x[4] = 345;
		System.out.println(x[0]);

		/*
		 * for (int i = 0; i < x.length; i++) {
		 * System.out.println("Introduzca un numero"); x[i] =
		 * Integer.parseInt(entrada.nextLine()); }
		 */
		for (int i = 0; i < x.length; i++) {
			x[i] = new Random().nextInt(11);
		}

		System.out.println("Datos");
		for (int i = 0; i < x.length; i++) {
			System.out.println(x[i]);

		}
		// Contador
		int c = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] >= 5) {
				c++;
			}

		}
		System.out.println("Has aprobado " + c + " asignaturas");

		// Sumador
		int s = 0;
		for (int i = 0; i < x.length; i++) {
			s += x[i];
		}
		System.out.println("La suma es " + s);

		// Hallar maximos y minimos
		int max = -1;
		int min = 11;
		for (int i = 0; i < x.length; i++) {
			if (max < x[i]) {
				max = x[i];
			}
			if (min > x[i]) {
				min = x[i];
			}
		}
		System.out.println("Maximo " + max + " Minimo " + min);
		
		System.out.println("La media de notas es "+(s/x.length));

	}

}
