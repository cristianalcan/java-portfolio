package practica9;

import java.util.Objects;

public class Ciudad {
	private String nombre;
	private String provincia;
	private int habitantes;

	public Ciudad(String nombre, String provincia, int habitantes) {
		super();
		this.nombre = nombre;
		this.provincia = provincia;
		this.habitantes = habitantes;
	}

	public String getNombre() {
		return nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public int getHabitantes() {
		return habitantes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, provincia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciudad other = (Ciudad) obj;
		return Objects.equals(nombre, other.nombre) || Objects.equals(provincia, other.provincia);
	}

	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + ", provincia=" + provincia + ", habitantes=" + habitantes + "]";
	}
	
	

}
