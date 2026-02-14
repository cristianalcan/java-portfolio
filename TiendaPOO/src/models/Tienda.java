package models;

public class Tienda {
	private Producto[] productos;
	private Cliente[] clientes;

	public Tienda(Producto[] productos) {
		super();
		this.productos = productos;
		this.clientes = new Cliente[1000];
	}

}
