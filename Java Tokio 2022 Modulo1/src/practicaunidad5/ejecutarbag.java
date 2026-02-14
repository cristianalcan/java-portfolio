package practicaunidad5;

public class ejecutarbag {

	public static void main(String[] args) {
		Bag prueba = new Bag();
		prueba.add(false);
		System.out.println(prueba.extract());
		prueba.clear();
		System.out.println(prueba.contains("hola"));
		System.out.println(prueba.isEmpty());
		System.out.println(prueba.size());

	}

}
