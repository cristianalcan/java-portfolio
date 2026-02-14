package unidad1;

import java.util.Random;

public class unidad1 {

	public static void main(String[] args) {

		/*
		 * for (int i = 4; i < 5; i++) { System.out.println("Hola Mundo"); }
		 */
		/*
		 * boolean t; boolean f; t=true; f=false; Integer o= new Random().nextInt(80);
		 * int value; for (value = o.intValue(); value < 20; value++) { t=false; f=true;
		 * if (f) { System.out.println(o); break; } }
		 * 
		 * if (t) { System.out.println("Hola Mundo"); System.out.println(o); }else {
		 * System.out.println("Error"); }
		 */

		int[] numeros = { 2, 5, 1, 8, 4 };
		int tamanyo = numeros.length;
		for (int i = 0; i < tamanyo - 1; i++) {
			for (int j = 0; j < tamanyo - 1 - i; j++) {
				if (numeros[j + 1] < numeros[j]) {
					int correcto = numeros[j];
					numeros[j] = numeros[j + 1];
					numeros[j + 1] = correcto;
				}
			}
		}
		for (int k : numeros) {
			System.out.println(k);
		}

	}

}
