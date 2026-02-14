package models;

public class Coche {
	private String marca;
	private String modelo;
	private double precio;
	private int anyo;
	private String descripcion;
	private String imagen;

	public Coche(String marca, String modelo, double precio, int anyo, String descripcion, String imagen) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.anyo = anyo;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
