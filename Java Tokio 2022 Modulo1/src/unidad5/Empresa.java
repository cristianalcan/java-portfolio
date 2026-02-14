package unidad5;

public class Empresa {
	private Cliente[] clientes;
	private Producto[] productos;

	public Empresa(Cliente[] clientes) {
		super();
		this.clientes = clientes;
		productos = new Producto[10];
	}

	public Producto[] getProductos() {
		return productos;
	}

	public double gananciasTotales() {
		double sum = 0;
		int pos = 0;
		while (clientes[pos] != null) {
			sum = clientes[pos++].getProducto().getPrecio();
		}
		return sum;
	}

	public boolean addCliente(Cliente c) {
		return true;
	}

	public void removeSuscription(Cliente c) {
		c.setProducto(productos[0]);
	}

}
