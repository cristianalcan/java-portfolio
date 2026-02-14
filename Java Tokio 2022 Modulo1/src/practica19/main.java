package practica19;

import java.util.Scanner;

public class main {

	public static void main(String[] args) throws Exception {
		Scanner entrada = new Scanner(System.in);
		int tamaño;
		try {
			System.out.println("Introduce el nombre del equipo de programacion");
			String nombreEquipo = entrada.nextLine();
			System.out.println("Introduce el nombre de la universidad");
			String nombreUniversidad = entrada.nextLine();
			System.out.println("Introduce el lenguaje de Programacion");
			String lenguaje = entrada.nextLine();
			do {
				System.out.println("Introduce el tamaño del equipo (mínimo 2 - máximo 3)");
				tamaño = Integer.parseInt(entrada.nextLine());

			} while (tamaño < 2 || tamaño > 3);
			EquipoProgramacion equipo1 = new EquipoProgramacion(nombreEquipo, nombreUniversidad, lenguaje, tamaño);
			/**
			 * He puesto el bucle for para que se repita el numero de veces que hemos puesto
			 * como tamaño del equipo, es decir, si hemos puesto que nuestro tamaño es de 3,
			 * se repite 3 veces pidiendo el nombre de 3 programadores
			 */
			for (int i = 0; i < tamaño; i++) {// Aqui pongo 3 menos el tamaño del equipo, ya que el tamaño del
												// equipo siempre va a ser o 2 o 3, entonces si es 3, pues no se
												// piden los nombres, en caso de que sean 2, se pide el nombre una
												// vez
				System.out.println("Introduce el nombre de un programador");
				String nombre = entrada.nextLine();
				System.out.println("Introduce el apellido de un programador");
				String apellido = entrada.nextLine();
				Programador javier = new Programador(nombre, apellido);
				System.out.print("La validacion del nombre y apellido es: ");
				System.out.println(javier.validacionNombres());
				/**
				 * Aqui lo que hago es eliminar los programadores que se ha introducido por
				 * teclado ya que en la practica se pide que como maximo el tamaño del equipo
				 * sea 3,es decir, lo que hago es basicamente poner el tamaño del equipo igual a
				 * 0, ya que si hemos puesto el tamaño del equipo igual a 3, no nos deberia
				 * dejar añadir un programador mas, y nos lanzaria un excepcion.
				 */
				equipo1.eliminarProgramadores();
				equipo1.añadirProgramadores(javier);
			}
			System.out.println("El equipo cuenta con los programadores: " + equipo1.getProgramadores());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println();
	}
}
