package unidad8;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * En esta clase vamos a ver como cifrar un dato de forma simetrica, que
 * recordemos que es, generando solo una llave para guardar el dato, y luego
 * para decifrarlo
 * 
 * @author crist
 *
 */
public class Simetrico {

	private SecretKey k;
	private Cipher ci;

	/**
	 * Aqui si que es necesario tener un constructor para poder crear una llave y
	 * guardarla
	 * 
	 * @throws NoSuchPaddingException
	 */
	public Simetrico() {
		try {
			k = KeyGenerator.getInstance("AES").generateKey();// Asi nosotros generamos una llave secreta y la guardamos
																// en nuestra secretkey, en getInstance ponemos el
																// algoritmo que queramos para generar la llave

			ci = Cipher.getInstance("AES");// Aqui lo que haremos será cifrar nuestra llave
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Aqui lo que vamos a hacer es un metodo para generar el codigo unico de los
	 * datos que queramos encriptar, aqui nos va a devolver un array de bytes debido
	 * a que si lo convertimos a string existe la posibilidad de perder datos, por
	 * tanto vamos a hacer que retorne el array de bytes, y asi podriamos encriptar
	 * todo tipo de datos, ficheros, imagenes, etc
	 */
	public byte[] cifrar(String mensaje) {
		try {
			/**
			 * Aqui lo que hacemos es cifrar nuestra llave, utilizando el cipher que hemos
			 * creado, su metodo init, en el que del lado izquierdo ponemos que queramos
			 * hacer, y al lado derecho el atributo que queremos encriptar en este caso
			 */
			ci.init(Cipher.ENCRYPT_MODE, k);
			/**
			 * Con el dofinal ya obtenemos el arreglo de bytes, que es nuestro codigo, o la
			 * llave encriptada, en este caso, lo que vamos a encriptar es nuestro mensaje
			 */
			return ci.doFinal(mensaje.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String descifrar(byte[] cript) {
		try {
			/**
			 * Aqui lo que hacemos es lo mismo que lo de arriba, solo que en modo
			 * desencriptar
			 */
			ci.init(Cipher.DECRYPT_MODE, k);

			/**
			 * Con el dofinal ya obtenemos el arreglo de bytes, que es nuestro codigo, o la
			 * llave encriptada, en este caso, lo que vamos a descifrar va a ser nuestro
			 * codigo pasado por parametro
			 */
			return new String(ci.doFinal(cript));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * Recordemos que la llave es MUY IMPORTANTE, la tenemos que guardar en algun
	 * lugar,como un fichero por ejemplo, ya que si no la tenemos, no podremos
	 * descifrar informacion, por eso, los datos que no sean sensibles, no los vamos
	 * a encriptar, porque seria una tonteria.
	 */
}
