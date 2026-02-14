package unidad8;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * En esta clase vamos a ver lo que es la funcion Hash y para que sirve. Una
 * funcion hash es es un algoritmo matemático que transforma los datos de
 * entrada en un código único.
 * 
 * @author crist
 *
 */

public class Hash {

	/**
	 * Normalmente esta clase tiene 2 funciones, una que es generar y otra que es
	 * comprobar
	 */

	public static String generateHash(String password) {
		try {
			/**
			 * En Java para poder usar un algoritmo que genera un codigo para un dato, pues
			 * lo que se hace es usar la clase MessageDigest para asi poder usar los
			 * algoritmos que queramos, en este caso usaremos el MD5
			 */
			MessageDigest md = MessageDigest.getInstance("MD5");

			/**
			 * Ahora lo que vamos a hacer es que nuestro MessageDigest reciba el password,
			 * obtenemos sus bytes.
			 */
			md.update(password.getBytes());
			/**
			 * Luego ya si que generamos el codigo unico para nuestra password
			 */
			return new BigInteger(1, md.digest()).toString(16);// De esta manera convertimos el array de bytes a un
																// string, y seria la mejor manera

			// return new String(md.digest()); Esta seria otra opcion, pero la de arriba es
			// mejor
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";

	}

	public static boolean checkPassword(String password, String hash) {
		try {
			/**
			 * Aqui lo que haremos sera comprobar si el hash que se introduce por parametro
			 * es igual al password
			 */
			MessageDigest md = MessageDigest.getInstance("MD5");

			/**
			 * Ahora lo que vamos a hacer es que nuestro MessageDigest reciba el password,
			 * obtenemos sus bytes.
			 */
			md.update(password.getBytes());
			/**
			 * Aqui lo que hacemos es comparar nuestro arreglo de bytes pasado a string, con
			 * el string hash que recibimos por parametro
			 */
			return new BigInteger(1, md.digest()).toString(16).equals(hash);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return false;
	}

}
