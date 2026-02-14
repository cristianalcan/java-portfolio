package practica4;

public class Tienda {

	public static void main(String[] args) {
		Producto p = new Producto();
		Productor produ = new Productor(p);
		Consumidor c = new Consumidor(p);
		produ.start();
		c.start();
		
		

	}

}
