package unidad8;

import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Practica8 {
	/**
	 * En esta clase diremos y ejecutaremos cuales son las recomendaciones para
	 * tener un software seguro y robusto
	 */
	/**
	 * NUMERO 1, encapsular los atributos de una clase, recordemos que el
	 * modificador de acceso sirve para mantener la visibilidad de una variable o
	 * constante, y en nuestro caso la pondremos como private para que solo se pueda
	 * utilizar en esta clase
	 */
	private String dni;
	private String correo;
	private SecretKey k;
	private Cipher ci;

	/**
	 * NUMERO 2.Lanzar excepciones en campos que no se pueden hacer con sentencias
	 * de control como los if o switch.
	 */
	String documento = "^[a-zA-Z]?[0-9]+[a-zA-Z]";

	public boolean validarDni(String dni) throws Exception {
		if (!Pattern.matches(documento, dni)) {
			throw new Exception("Documento de identificacion no valido ingreso uno que cumpla el patron");
		}
		return true;
	}

	/**
	 * NUMERO 3. Tener mucho cuidado con los datos de entrada, como tambien con los
	 * de salida. En este caso por ejemplo lo que haremos será cerrar el buffer
	 * entrada, ya que un hacker podria interceptar el buffer y ejecutar acciones
	 * perjudiciales para la aplicacion. Ademas de esto cuando queramos que se
	 * ingrese datos por consola, utilizaremos el nextline, para que sea lo mas
	 * generico posible, ya que si por ejemplo ponemos nextInt y el usuario pone un
	 * dato que no sea de tipo int, el programa colapsara.
	 */

	/**
	 * NUMERO 4.Cifrar nuestros datos mas sensibles como por ejemplo el DNI
	 * 
	 */
	public Practica8(String dni) {
		try {
			this.dni = dni;
			k = KeyGenerator.getInstance("AES").generateKey();

			ci = Cipher.getInstance("AES");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public byte[] cifrar() {
		try {
			ci.init(Cipher.ENCRYPT_MODE, k);
			return ci.doFinal(dni.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String descifrar(byte[] cript) {
		try {
			ci.init(Cipher.DECRYPT_MODE, k);
			return new String(ci.doFinal(cript));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * NUMERO 5. Autenticar los usuarios, y es que crearemos metodos para validar
	 * una sesion. Si en nuestro metodo el nombre y contraseña de nuestra base de
	 * datos coinciden con los que ingresa el usuario, la sesion será validada, pero
	 * en caso de que no coincida en algun campo, notificaremos que hay un error en
	 * la entrada de datos
	 */

}
