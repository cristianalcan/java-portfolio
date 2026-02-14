package unidad5;

import java.util.Iterator;

public class clase1 {

	public static void main(String[] args) {
		int[] x = new int[] { 4, 9, 10, 4, 6, 6, 3, 2, 7, 8 };
		int[] y = new int[] { 8, 9, 6, 4, 6, 10, 3, 7, 7, 8 };
		int[] z = new int[] { 8, 2, 3, 4, 6, 9, 3, 9, 7, 10 };

		 System.out.println("Has aprobado " + contarAprobados(x) + " asignaturas");
		 System.out.println("Has aprobado " + contarAprobados(y) + " asignaturas");
		 System.out.println("Has aprobado " + contarAprobados(z) + " asignaturas");
		 aprobarEstudiantes(z);
		 System.out.println("Has aprobado " + contarAprobados(z) + " asignaturas");
		 
		 int n=5;
		 n= convertirSigno(n);
		 System.out.println(n);
		// Sumador
		int s = 0;
		for (int i = 0; i < x.length; i++) {
			s += x[i];
		}
		System.out.println("La suma es " + s);

		// Hallar maximos y minimos
		int max = -1;
		int min = 11;
		for (int i = 0; i < x.length; i++) {
			if (max < x[i]) {
				max = x[i];
			}
			if (min > x[i]) {
				min = x[i];
			}
		}
		System.out.println("Maximo " + max + " Minimo " + min);

		System.out.println("La media de notas es " + (s / x.length));

	}

	public static int contarAprobados(int[] notas) {
		// Contador
		int c = 0;
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] >= 5) {
				c++;
			}

		}
		return c;
	}
	
	public static void aprobarEstudiantes(int [] notas) {
		for (int i = 0; i < notas.length; i++) {
			if (notas[i]<5) {
				notas[i]=5;
			}
		}
	}
	public static int convertirSigno(int x) {
		x*=-1;
		return x;
	}

}
