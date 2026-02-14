package unidad2;

import java.util.Scanner;

public class unidad2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero = 14;
		long grande = 123l;
		double a = 12.56;
		float b = 23.45f;
		char letra = 'a';
		char salto = '\n';
		char letraM = 77;
		boolean x = true;
		boolean y;
		y = false;
		System.out.print(numero);
		System.out.print(salto);
		System.out.println(letra);
		System.out.println(letraM);
		System.out.println(grande);

		long r1 = numero + grande;
		double r2 = numero * a;
		int r3 = 19 / 5;
		int r4 = 19 % 5;
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);

		numero++;
		++numero;
		System.out.println(numero);
		numero--;
		System.out.println(numero);
		int dato = 0;
		System.out.println(dato++);
		System.out.println(++dato);
		dato += 5 * 3;
		System.out.println(dato);
		boolean logico = (5 >= 4) || (4 <= 3);
		System.out.println(logico);

		System.out.println("hola el numero es " + dato + " otro numero " + numero);
		/*
		 * En la linea anterior ponemos separada la comilla doble del es porque asi se
		 * separa de el dato, y luego separamos la comilla doble de otro para que no se
		 * junte con el dato, y tambien separamos numero de la comilla para que no se
		 * junte con numero
		 */
		System.out.println("la suma de 17 mas 15 es " + (dato + numero));

		// Tipos de datos complejos

		String texto = "hola ";
		Integer numint = 10;
		Double numdouble = 10.4;
		Character letrachar = 'l';

		texto += "mundo";
		System.out.println(texto);

		Scanner entrada = new Scanner(System.in);

		System.out.println("entre un numero:");
		int num = Integer.parseInt(entrada.nextLine());

		System.out.println("entre un texto:");
		String texto2 = entrada.nextLine();

		System.out.println("el numero es " + num + " el texto es " + texto2);

	}

}
