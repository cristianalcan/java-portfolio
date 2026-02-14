package unidad5;

public class clase6 {

	public static void main(String[] args) {
		Cliente[] clientes = new Cliente[1000];
		clientes[0] = new Cliente("Juan", "juan@gmail.com", null);
		clientes[1] = new Cliente("Pedro", "pedro@gmail.com", null);
		Empresa emp = new Empresa(clientes);
		emp.getProductos()[0] = new Producto("Gratis", 0); // Esto se puede cambiar porque es un arreglo, si no lo fuera
		emp.getProductos()[1] = new Producto("Familiar", 15); // lo tendriamos que cambiar con el metodo set
		emp.getProductos()[2] = new Producto("Premium", 11);

		System.out.println(emp.getProductos()[1]);

	}

}
