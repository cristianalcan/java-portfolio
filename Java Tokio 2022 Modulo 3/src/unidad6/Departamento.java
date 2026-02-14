package unidad6;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
	private String Nombre;
	private int plantilla;
	private List<Personal> personal;

	public Departamento(String nombre, int plantilla) {
		super();
		Nombre = nombre;
		this.plantilla = plantilla;
		this.personal = new ArrayList<>();
	}

	public String getNombre() {
		return Nombre;
	}

	public int getPlantilla() {
		return plantilla;
	}

	public List<Personal> getPersonal() {
		return personal;
	}

}
