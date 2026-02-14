package practica19;

import java.util.regex.Pattern;

/**
 * En esta clase estaremos viendo los atributos y metodos con los que va a
 * contar un programador
 * 
 * @author crist
 *
 */
public class Programador {
	protected String nombre;
	protected String apellido;

	public Programador(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	/**
	 * Con este metodo vamos a validar los nombres y apellidos de los programadores
	 * 
	 * @return exception si no se cumplen las expresiones regulares, que solo se
	 *         pueden escribir letras, return true si se cumple la expresion regular
	 * @throws Exception
	 */
	public boolean validacionNombres() throws Exception {
		String nom = "[a-zA-Z]+";
		if (!Pattern.matches(nom, nombre)) {
			throw new Exception("No se puede poner numeros ni signos auxiliares como nombre");
		}
		if (!Pattern.matches(nom, apellido)) {
			throw new Exception("No se puede poner numeros ni signos auxiliares como apellido");
		}

		if (nombre.length() + apellido.length() > 20) {
			throw new Exception("Cantidad de caracteres superior a 20");
		}

		return true;
	}

	@Override
	public String toString() {
		return "Programador [nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	

}
