package models;

import java.util.Random;

public class Empresa extends Cliente implements Factura, Comparable {
	public Empresa(String nombre, String contacto) {
		super(nombre, contacto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double precioFinal() {
		double sum = 0;
		for (Producto p : getProductos()) {
			sum += p.getPvp() * p.getCantidad();
		}
		return Factura.calcularPrecioIVA(sum);
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
