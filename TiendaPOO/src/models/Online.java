package models;

import java.util.Random;

public class Online extends Cliente implements Factura, Comparable {
	private String direccion;

	public Online(String nombre, String contacto, String direccion) {
		super(nombre, contacto);
		this.direccion = direccion;
	}

	@Override
	public int oferta() {
		switch (new Random().nextInt(10)) {
		case 0:
			return 5;

		case 1:
			return 10;

		case 2:
			return 15;

		}

		return 0;
	}

	public double costeEnvio() {
		return 5 + new Random().nextDouble() * 15;
	}

	@Override
	public double precioFinal() {
		double sum = 0;
		for (Producto p : getProductos()) {
			sum += calcularPrecioIVA(p)* p.getCantidad();
		}
		return sum;
	}

	@Override
	public int tipoIVACorrespondiente(Producto p) {
		if (p.getTipo().equals("medicamento")) {
			return IVA[0];
		}
		return Factura.super.tipoIVACorrespondiente(p); // Esto lo dejamos asi por si en caso no es un medicamento,
														// queremos que se calcule de la misma forma que en factura
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Factura) {
			Factura f = (Factura) o;
			if (precioFinal() < f.precioFinal()) {
				return -1;

			}
			if (precioFinal() == f.precioFinal()) {
				return 0;

			}

		}
		if (o instanceof Fisico) {
			Fisico f = (Fisico) o;
			if (precioFinal() < f.precioFinal()) {
				return -1;

			}
			if (precioFinal() == f.precioFinal()) {
				return 0;

			}
		}
		return 1;
	}

}
