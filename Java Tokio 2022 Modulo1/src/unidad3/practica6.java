package unidad3;

public class practica6 {

	public static void main(String[] args) {
		double metro;
		// una pulgada equivale a 0.0254 metros
		final int NUM_MAX_PULGADAS = 144;

		System.out.println("Vamos a pasar pulgadas a metros ");
		int c = 0; // contador

		for (int i = 1; i <= NUM_MAX_PULGADAS; i++) {
			metro = i * 0.0254;
			System.out.println(i + " pulgadas equivale a " + metro + " metros");
			c++;
			if (c % 12 == 0) {
				System.out.println("");
			}

		}
	}
}
