package practica19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * En esta clase definiremos los atributos y metodos con los que cuenta nuestro
 * equipo de programacion
 * 
 * @author crist
 *
 */

public class EquipoProgramacion {
	Scanner entrada = new Scanner(System.in);
	protected String nombre;
	protected String universidad;
	protected String lenguaje;
	protected int tamañoEquipo;
	protected List<Programador> programadores;

	public EquipoProgramacion(String nombre, String universidad, String lenguaje, int tamañoEquipo) {
		super();
		this.nombre = nombre;
		this.universidad = universidad;
		this.lenguaje = lenguaje;
		this.tamañoEquipo = tamañoEquipo;
		this.programadores = new ArrayList<>();

	}

	public Scanner getEntrada() {
		return entrada;
	}

	public String getNombre() {
		return nombre;
	}

	public String getUniversidad() {
		return universidad;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public int getTamañoEquipo() {
		return tamañoEquipo;
	}

	public List<Programador> getProgramadores() {
		return programadores;
	}

	/**
	 * Este metodo nos va a servir para determinar si nuestro equipo esta completo o
	 * no
	 * 
	 * @return true si el equipo esta completo, return false si no esta completo
	 */
	public boolean equipoCompleto() {
		if (tamañoEquipo == 3) {
			return true;
		}
		return false;
	}

	/**
	 * Este metodo nos servira para añadir programadores al equipo
	 * 
	 * @param programadores son los que se van a añadir
	 * @return true si el equipo aun no esta lleno, return exception si el equipo
	 *         esta lleno
	 */
	public boolean añadirProgramadores(Programador programadores) {
		try {
			if (tamañoEquipo >= 0 && tamañoEquipo < 3) {
				this.programadores.add(programadores);
				return true;
			} else {
				throw new Exception("No se puede añadir mas programadores");
			}
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		return false;
	}

	/**
	 * Este metodo nos servira para comprobar que el tamaño del equipo sea valido
	 * 
	 * @return true si el tamaño del equipo es validdo, return exception si no lo es
	 * @throws Exception
	 */
	public boolean validarTamaño() throws Exception {
		if (tamañoEquipo >= 2 && tamañoEquipo <= 3) {
			return true;
		} else {
			throw new Exception("El tamaño del equipo tiene que ser de 2 o 3 integrantes");
		}
	}

	public void eliminarProgramadores() {
		tamañoEquipo = 0;
	}

	@Override
	public String toString() {
		return "EquipoProgramacion [entrada=" + entrada + ", nombre=" + nombre + ", universidad=" + universidad
				+ ", lenguaje=" + lenguaje + ", tamañoEquipo=" + tamañoEquipo + ", programadores=" + programadores
				+ "]";
	}

}
