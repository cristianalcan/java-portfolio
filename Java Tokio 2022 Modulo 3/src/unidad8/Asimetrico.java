package unidad8;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class Asimetrico {
	/**
	 * Aqui lo que vamos a tener son 2 llaves, una privada y una publica, la privada
	 * nunca la compartiremos, y la publica sera la que enviaremos a gente que
	 * enviemos datos, para que pueda descifrar el dato
	 */
	private PrivateKey prik;
	private PublicKey pubk;
	private Cipher ci;

	public Asimetrico() {
		try {
			/**
			 * Aqui lo que hacemos es generar una llave con el algoritmo RSA
			 */
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			/**
			 * Esta es la version del algoritmo RSA, la version 1024, pero tambien hay una
			 * de 2048
			 */
			kpg.initialize(1024);
			/**
			 * Aqui lo que vamos a hacer es almacenar en un KeyPair nuestras claves, lo
			 * almacenamos aqui ya que si lo hacemos directamente a las key que hemos
			 * creado, pues seran los mismo codigos, entonces este KeyPair tiene 2 claves,
			 * una public y otra privada
			 */
			KeyPair kp = kpg.generateKeyPair();
			prik = kp.getPrivate();
			pubk = kp.getPublic();
			/**
			 * Y por ultimo inicializamos nuestro cipher, para que tenga el algoritmo RSA
			 */
			ci = Cipher.getInstance("RSA");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Aqui lo que vamos a hacer son los 2 metodos iguales que los simetricos, solo
	 * cambiando las llaves
	 * 
	 * @param mensaje
	 * @return
	 */
	public byte[] cifrar(String mensaje) {
		try {
			/**
			 * Aqui lo que hacemos es cifrar nuestra llave, utilizando el cipher que hemos
			 * creado, su metodo init, en el que del lado izquierdo ponemos que queramos
			 * hacer, y al lado derecho la llave publica, y tiene que ser la publica sino no
			 * funcionará
			 */
			ci.init(Cipher.ENCRYPT_MODE, pubk);
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
			 * desencriptar, y con la llave PRIVADA, y tiene que ser la privada sino no
			 * funcionará
			 */
			ci.init(Cipher.DECRYPT_MODE, prik);

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
}
