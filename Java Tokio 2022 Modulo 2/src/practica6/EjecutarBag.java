package practica6;

public class EjecutarBag {

	public static void main(String[] args) {
		Bag<Integer> prueba= new Bag<>();
		prueba.add(8);
		prueba.add(10);
		prueba.add(7);
		prueba.add(23);
		prueba.add(17);
		prueba.add(3);
		prueba.add(14);
		
		System.out.println("Cantidad de elementos en bag: "+prueba.size());
		prueba.clear();
		System.out.println("Cantidad de elementos en bag despues de usar clear: "+prueba.size());
		prueba.add(23);
		System.out.println("El elemento se encuentra en la mochila: "+prueba.contains(23)); 
		System.out.println("Bag esta vacio: "+prueba.isEmpty());
		prueba.add(8);
		prueba.add(10);
		prueba.add(7);
		prueba.add(23);
		prueba.add(17);
		prueba.add(3);
		prueba.add(14);
		System.out.println("El elemento aleatorio es :"+prueba.extract());
		

	}

}
