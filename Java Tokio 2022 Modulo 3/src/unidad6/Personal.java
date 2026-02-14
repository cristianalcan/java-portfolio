package unidad6;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase "representará" la tabla de nuestra base de datos
 * 
 * @author crist
 *
 */
public class Personal {
	/**
	 * Estas son las "Filas" con las que contará nuestra tabla
	 */
	private String DNI;
	private String Nombre;
	private String Direccion;
	private int edad;
	private List<Nomina> nom;
	private List<Departamento> dep;

	public Personal(String dNI, String nombre, String direccion, int edad) {
		super();
		DNI = dNI;
		Nombre = nombre;
		Direccion = direccion;
		this.edad = edad;
		this.nom = new ArrayList<>();
		dep = new ArrayList<>();
	}

	public void addNomina(Nomina nom) {
		this.nom.add(nom);
	}

	public String getDNI() {
		return DNI;
	}

	public String getNombre() {
		return Nombre;
	}

	public String getDireccion() {
		return Direccion;
	}

	public int getEdad() {
		return edad;
	}

	public List<Nomina> getNom() {
		return nom;
	}

	public List<Departamento> getDep() {
		return dep;
	}

	@Override
	public String toString() {
		String r = "Personal [DNI=" + DNI + ", Nombre=" + Nombre + ", Direccion=" + Direccion + "" + "" + ", edad="
				+ edad + "]";
		/**
		 * Esto es para que con cada una de las nominas se vaya concatenando con el
		 * toString
		 */
		for (Nomina nomina : nom) {
			r += "\n" + nom.toString();
		}
		return r;
	}

}
