package models;

public interface Factura {

	int[] IVA = { 4, 10, 21 };

	double precioFinal();

	default int tipoIVACorrespondiente(Producto p) {
		if (p.getTipo().equals("alimentos")) {
			return IVA[0];
		}
		if (p.getTipo().equals("agua") || p.getTipo().equals("gafas")) {
			return IVA[1];
		}
		return IVA[2];
	}

	default double calcularPrecioIVA(Producto p) {
		return masIVA(p.getPvp(), tipoIVACorrespondiente(p));
	}

	public static double calcularPrecioIVA(double precio) {
		return masIVA(precio, 21);
	}

	public static double calcularPrecioIVA(double precio, int iva) {
		return masIVA(precio, iva);
	}

	private static double masIVA(double precio, int iva) {
		return precio * ((100 + iva) / 100);
	}
}
