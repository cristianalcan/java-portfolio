package unidad4;

import java.util.Random;

public class practica8 {

	public static void main(String[] args) {
		int[] duplicados = { 1, 2, 3, 3, 9, 8, 7, 4, 6, 7, 0, 4, 5 };  
		int[] duplicados2 = new int[duplicados.length]; 

		int k, contados = 0; 
		boolean condicion;

		for (int i = 0; i < duplicados.length; i++) {
			int c = 0;
			condicion = false;
			k = 0;

			while ((!condicion) && (k < contados)) {
				if (duplicados[i] == duplicados2[k]) {
					condicion = true;
				}
				k++;
			}
			if (!condicion) {
				duplicados2[contados] = duplicados[i];
				contados++;

				for (int j = 0; j < duplicados.length; j++) {

					if (duplicados[i] == duplicados[j]) {
						c++;
					}

				}
				System.out.println("El numero " + duplicados[i] + " se ha repetido " + c + " veces");
			}
		}

	}

}
