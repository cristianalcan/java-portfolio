package models;

import java.util.Random;

public class Producto {
	private String nombre;
	private int codigo;
	private double precio;
	private int cantidad;
	private int pvp;
	private String tipo;

	public Producto(String nombre, double precio, int cantidad, int pvp, String tipo) {
		super();
		this.nombre = nombre;
		this.codigo = new Random().nextInt(1000000);
		this.precio = precio;
		this.cantidad = cantidad;
		this.pvp = pvp;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getPvp() {
		return pvp;
	}

	public String getTipo() {
		return tipo;
	}

}
