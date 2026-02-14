package utils;

public class Utils {
	public static boolean esCorreo (String contacto) {
		if (contacto.contains("@")) { //Esto es para saber si el contacto tiene un arroba y por tanto es un correo
			return true;
		}
		return false;
	}

}
