package unidad4;

import java.util.Arrays;

public class Practica7 {

	public static void main(String[] args) {
		int numeroDeCupones = 128; // Aqui podemos cambiar el numero de cupones obtenidos
		System.out.println(Arrays.toString(candyCalculator(numeroDeCupones)));
	}

	public static int[] candyCalculator(int numeroCupones) {

		int[] tiposDeGastos = new int[3];

		tiposDeGastos[0] = numeroCupones / 10;
		System.out.print("El numero de barras es " + tiposDeGastos[0]);

		tiposDeGastos[1] = numeroCupones - tiposDeGastos[0] * 10;

		if (tiposDeGastos[1] < 3) {
			tiposDeGastos[2] = tiposDeGastos[1];
			tiposDeGastos[1] = 0;

		} else if (tiposDeGastos[1] >= 3) {
			tiposDeGastos[1] = (numeroCupones - tiposDeGastos[0] * 10) / 3;
			tiposDeGastos[2] = ((numeroCupones - tiposDeGastos[0] * 10) % 3);

		}
		System.out.print(" el numero de chicles es " + tiposDeGastos[1]);
		System.out.println(" y lo que sobra es " + tiposDeGastos[2]);
		return tiposDeGastos;

	}

}
