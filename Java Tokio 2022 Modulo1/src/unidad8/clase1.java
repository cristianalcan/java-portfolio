package unidad8;

import java.util.Scanner;

import javax.xml.transform.TransformerException;

public class clase1 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		try {
			int edad = entradaEdad(entrada);
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		int y = EntradaDatosException.entradaEntero();
		int x = EntradaDatosException.entradaEntero();
		System.out.println("y: " + y);
		System.out.println("x: " + x);

		try {
			System.out.println("primero");
			x = 10 / 2;
			System.out.println("segundo");
			y = Integer.parseInt("-18");
			System.out.println("tercero");
			if (y < 0) {
				throw new clase2("Numero negativo", y);
			}

		} catch (NumberFormatException e) {
			System.out.println("Error al convertir texto a numero");
			y = 5;
		} catch (ArithmeticException e) {
			System.out.println("Error al dividir entre 0");
			y = 5;
			x = 3;
		} catch (clase2 e) {
			System.out.println(e.getMessage());
			y = e.getCorrectNumber();
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		} finally {
			System.out.println("MOSTRAR");
		}
		System.out.println("y: " + y);
		System.out.println("x: " + x);

		while (true) {

			try {
				System.out.println("Entre divisor");
				x = Integer.parseInt(entrada.nextLine());
				System.out.println("Entre dividendo");
				y = Integer.parseInt(entrada.nextLine());
				System.out.println(x / y);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	public static int entradaEdad(Scanner entrada) throws TransformerException, NumberFormatException, Exception {
		System.out.println("Entre su edad");
		int edad = Integer.parseInt(entrada.nextLine());
		if (edad < 0 || edad > 130) {
			throw new TransformerException("Edad no admitida");
		}
		return 0;
	}

}
