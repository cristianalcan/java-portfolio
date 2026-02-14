package practica11;

public class Persona {
	private String nombre;
	private String nif;
	private String correo;

	public Persona(String nombre, String nif, String correo) {
		super();
		this.nombre = nombre;
		this.nif = nif;
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNIF() {
		return nif;
	}

	public String getCorreo() {
		return correo;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", nif=" + nif + ", correo=" + correo + "]";
	}

}
