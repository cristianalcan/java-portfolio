package practica15;

public class algoritmoPrueba {

	public static void main(String[] args) {
		String[] p = new String[4];
		p[0] = "e";
		p[1] = "v";
		p[2] = "i";
		p[3] = "a";
		String aux = "";
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p.length - 1; j++) {
				if (p[i].compareTo(p[j] + 1) < 0) {
					aux = p[i];
					p[i] = p[j];
					p[j] = aux;
				}
			}
		}
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}

	}

}
