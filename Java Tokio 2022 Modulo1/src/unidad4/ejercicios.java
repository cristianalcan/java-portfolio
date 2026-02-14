package unidad4;

import java.util.Random;

public class ejercicios {

	public static void main(String[] args) {
		// String[] nombres = { "Luis Molina", "Antonio Perez", "Ana Fernandez", "Pedro
		// Rodriguez", "Laura Alfonso" };
		// int[] notas = { 6, 8, 9, 10, 5 };
		// for (int i = 0; i < notas.length; i++) {
		// System.out.println(nombres[i]+ " - "+ notas[i]);
		// }
		//Array bidimensional ejemplo
		String[] nombres = { "Luis Molina Betancourt", "Antonio Perez", "Ana Fernandez", "Pedro Rodriguez Perez", "Laura Alfonso Garcia" };
		int[][] notas = new int[5][8]; 
		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[i].length; j++) {
				notas[i][j] = new Random().nextInt(11);
			}
		}
		for (int i = 0; i < notas.length; i++) {
			System.out.print(nombres[i]);
			for (int j = 0; j < notas[i].length; j++) {
				System.out.print("  "+notas [i][j]);
			}
			System.out.println();
		}
		//Para hallar la media de los estudiantes haremos un sumador
		for (int i = 0; i < notas.length; i++) {
			System.out.print(nombres[i]);
			int s=0;
			for (int j = 0; j < notas[i].length; j++) {
				s+=notas[i][j];
			}
			System.out.println(" "+ s / notas[i].length);
		}
		//Vamos a obtener el nombre y apellido de las personas
		
		for (int i = 0; i < nombres.length; i++) {
			String[] aux =nombres[i].split(" "); //Es importante solo dejar un espacio ya que asi reconoce que son apellidos
			if (aux.length < 3) {
				System.out.println("El nombre es incorrecto");
			} else {
				System.out.println("Nombre: "+aux[0]);
				System.out.println("Apellidos: "+aux[aux.length -2] +" "+ aux[aux.length -1]);
			}
			
		}
	}

}
