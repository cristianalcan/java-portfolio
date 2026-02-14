package practica18;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		try {
			System.out.println("Introduce un numero para hallar su logaritmo");
			double x = Integer.parseInt(entrada.nextLine());
			System.out.println("El logaritmo neperiano del numero es: " + CalculosNumericos.logaritmo(x));
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Introduce un numero para hallar su raiz cuadrada");
			double x = Integer.parseInt(entrada.nextLine());
			System.out.println("La raiz cuadrada del numero es: " + CalculosNumericos.raizCuadrada(x));
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
