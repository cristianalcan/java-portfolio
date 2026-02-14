package unidad4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class clase2 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce un texto");
		String texto = entrada.nextLine();
		System.out.println("Introduce un texto");
		String texto1 = entrada.nextLine();
		System.out.println(texto);
		System.out.println("tamaño " + texto.length());
		System.out.println("primera letra " + texto.charAt(0));
		System.out.println("ultima letra " + texto.charAt(texto.length() - 1));
		System.out.println("comparando " + texto.compareTo(texto1));
		System.out.println("posicion de un texto dentro de otro " + texto.indexOf(texto1));
		System.out.println("cantidad de palabras " + texto.split(" ").length);
		System.out.println("subtexto " + texto.substring(5, 8));
		System.out.println("a mayuscula " + texto.toUpperCase());

		// Para mostrar un array o funcion que return array por pantalla en un syso lo
		// que haremos sera poner
		// Arrays.toString(nombreArray())); el primero que nos salga (que es boolean).
		//Para ver si un objeto pertenece a una clase usaremos el metodo instanceOf que se pone en medio
		//De el objeto que queremos analizar y la clase que queremos saber si pertenece o no y siempre lo tenemos
		//Que usar en un sentencia condicional

	}

}
