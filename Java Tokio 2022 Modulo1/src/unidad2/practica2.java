package unidad2;

import java.util.Scanner;

public class practica2 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int a;
		int b;
		int c;

		System.out.println("Dime 3 numeros enteros");
		a = Integer.parseInt(entrada.nextLine());
		b = Integer.parseInt(entrada.nextLine());
		c = Integer.parseInt(entrada.nextLine());

		System.out.println("Ahora realizaremos distintas operaciones con estos numeros:");
		System.out.println("La primera operacion da el resultado:  " + a * b / c);
		System.out.println("La segunda operacion da el resultado: " + (a * c) % b);
		System.out.println("La tercera operacion da el resultado: " + 2 * (a + c - b) / (b * c));
		System.out.println("La cuarta operacion da el resultado: " + (((a * c) + (b % a)) / a - c));

	}

}
