package models;

public class Fisico extends Cliente implements Comparable {

	public Fisico(String nombre, String contacto) {
		super(nombre, contacto);
	}

	@Override
	public int oferta() {
		int i = 0, j = 0;
		int sumT = 0; // Suma total
		while (compras[i] != null) {
			int sumC = 0; // Suma de la compra
			while (compras[i][j] != null) {
				sumC += compras[i][j].getPvp() * compras[i][j].getCantidad();
			}
			if (sumC > 200) {
				sumT += 20;

			} else if (sumC > 100) {
				sumT += 10;
			} else if (sumC > 50) {
				sumT += 5;
			}

		}

		return sumT;
	}

	public double precioFinal() {
		double sum = 0;
		for (Producto p : getProductos()) {
			sum += p.getPvp() * p.getCantidad();
		}
		return sum;
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
