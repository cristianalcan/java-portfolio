package unidad8;

import java.math.BigInteger;

public class Clase2 {

	public static void main(String[] args) {
		/**
		 * En esta clase veremos como cifrar nuestros datos, la clase Hash tambien es de
		 * la clase 2
		 */
		String hash = Hash.generateHash("hola");
		System.out.println(hash);
		System.out.println(Hash.checkPassword("hola", hash));// Aqui comprobamos que el hola sea una contraseña
		System.out.println();
		/**
		 * Aqui lo que hacemos es crear un objeto de la clase simetrico, para utilizar
		 * el metodo cifrar
		 */
		Simetrico sim = new Simetrico();
		/**
		 * Aqui almacenamos en un array de bytes el codigo cifrado de nuestro mensaje
		 */
		byte[] cifrado = sim.cifrar("Hola");
		/**
		 * Aqui vamos a imprimir nuestro codigo cifrado pero transformado a String,
		 * recordemos que existe la posibilidad de perder codigo si en el metodo de
		 * cifrar devolviera un string, pero en este caso nuestro metodo devuelve el
		 * array de bytes. Nos damos cuenta de que cada vez que lo ejecutamos nos da un
		 * codigo distinto a diferencia del de arriba, que es la funcion hash
		 */
		System.out.println(new BigInteger(1, cifrado).toString(16));
		/**
		 * Aqui desciframos nuestro array de bytes y nos devuelve el mensaje
		 */
		System.out.println(sim.descifrar(cifrado));
		System.out.println();
		/**
		 * Hacemos lo mismo que lo de arriba, creamos un objeto de asimetrico, y a
		 * nuestro array de bytes le pasamos nuestro mensaje cifrado
		 */
		Asimetrico asim = new Asimetrico();
		cifrado = asim.cifrar("Hola2");
		/**
		 * Los 2 sysos de abajo son lo mismo que lo de arriba, pero nos podemos dar
		 * cuenta de que nuestro array de bytes es mucho mas grande que el de arriba, lo
		 * cual lo hace mas seguro
		 */
		System.out.println(new BigInteger(1, cifrado).toString(16));
		System.out.println(asim.descifrar(cifrado));

	}

}
