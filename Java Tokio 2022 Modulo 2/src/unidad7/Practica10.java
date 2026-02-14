package unidad7;

public class Practica10 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Hay coches");
		System.out.println(sb.toString());
		System.out.println("Capacidad: " + sb.capacity());
		System.out.println("Tamaño: " + sb.length());
		sb.append(" en el desguace");
		System.out.println(sb.toString());
		int i = 1000;
		sb.insert(3, " mas de ");
		sb.insert(11, i);
		System.out.println(sb.toString());
		String ultimos = sb.substring(33, 37);
		System.out.println("Ultimas 4 palabras del String Builder: " + ultimos);
		System.out.println("Capacidad final del StringBuilder: " + sb.capacity());
		System.out.println("Tamaño final del StringBuilder: " + sb.length());
		
		System.out.println();
		StringBuffer sf= new StringBuffer("Hay coches");
		System.out.println(sf.toString());
		System.out.println("Capacidad: " + sf.capacity());
		System.out.println("Tamaño: " + sf.length());
		sf.append(" en el desguace");
		System.out.println(sf.toString());
		int x = 1000;
		sf.insert(3, " mas de ");
		sf.insert(11, x);
		System.out.println(sf.toString());
		String ultimos4 = sf.substring(33, 37);
		System.out.println("Ultimas 4 palabras del StringBuffer: " + ultimos4);
		System.out.println("Capacidad final del StringBuffer: " + sf.capacity());
		System.out.println("Tamaño final del StringBuffer: " + sf.length());
		

	}

}
