package unidad2;

import java.util.Scanner;

public class practica1conversion {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int Tierra;
		double Luna;

		System.out.println("Dime tu peso con numeros enteros");
		Tierra = Integer.parseInt(entrada.nextLine());
		Luna = Tierra * 0.17;
		System.out.println("En la luna pesarias: " + Luna + " kg");

	}

}
