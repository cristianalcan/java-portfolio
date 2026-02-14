package unidad4;

public class Prenda implements Comparable<Prenda> {
	private Tallas talla;
	private double precio;
	private int prioridad;

	public Prenda(Tallas talla, double precio) {
		super();
		this.talla = talla;
		this.precio = precio;
		this.prioridad = 0; // El valor por defecto sera 0
	}

	public Tallas getTalla() {
		return talla;
	}

	public double getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return "Prenda [talla=" + talla + ", precio=" + precio + "]";
	}

	@Override
	public int compareTo(Prenda o) {
		if (prioridad == 0) {
			if (this.talla.compareTo(o.talla) == 0) {
				if (precio < o.precio) {
					return -1;
				} else if (precio > o.precio) {
					return 1;
				} else {
					return 0;
				}
			} else {
				return this.talla.compareTo(o.talla);
			}
		} else {
			if (precio == o.precio) {
				return this.talla.compareTo(o.talla);
			} else if (precio > o.precio) {
				return 1;
			} else {
				return -1;
			}
		}
	}

/*	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}*/

}
