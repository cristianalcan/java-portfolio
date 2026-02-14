package unidad5;

public class Cliente {
	private String nombre;
	private String correo;
	private String telefono;
	private Producto producto;

	public Cliente(String nombre, String correo, Producto p) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		producto = p;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
