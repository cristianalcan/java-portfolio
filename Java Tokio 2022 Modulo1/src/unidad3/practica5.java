package unidad3;

import java.util.Scanner;

public class practica5 {

	public static void main(String[] args) {

		/*
		 * Vamos a declarar una variable a la que le otorgaremos un numero y
		 * determinaremos si es amstrong o no.
		 */

		int numero = 712;
		/* Con este syso mostraremos por consola si el numero que introduzcamos 
		 es o no es amstrong */
		System.out.println((isAmstrong(numero)) ? "Es un Amstrong" : "No es un Amstrong");
	}

	private static boolean isAmstrong(int numero) {
		int temporal = numero, digitos = 0, ultimoDigito = 0, suma = 0;
		digitos = (int) (Math.log10(numero) + 1);
		temporal = numero;
		while (temporal > 0) {
			ultimoDigito = temporal % 10;
			suma += (Math.pow(ultimoDigito, digitos));
			temporal = temporal / 10;

		}
		/* Aqui usaremos el if para que en caso de que sea amstrong salga que es verdadero
		y el false que no es un amstrong     */
		if (numero == suma) {
			return true;
		} else {
			return false;
		}

	}
}