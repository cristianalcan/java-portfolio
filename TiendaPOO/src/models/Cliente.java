package models;

public abstract class Cliente {
	private String nombre;
	private String correo;
	private String telefono;
	protected Producto[][] compras; // Esto es bidimensional porque se trata de la cantidad de veces que compramos
									// Y dentro de estas cantidades esta lo que compramos

	public Cliente(String nombre, String contacto) { // Se pone contacto para que si introduces correo o telefono
		super(); // Lo reconozcas tu sin problema, podriamos crear una variable Object n tambien
					// que no hace nada
		this.nombre = nombre;
		if (utils.Utils.esCorreo(contacto)) {
			this.correo = contacto;// Si es correo lo guardo en correo
		} else {
			this.telefono = contacto;// Si no es correo lo guardo en telefono
		}

		compras = new Producto[100][100];
	}

	public String getNombre() {
		return nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public Producto[] getProductos() {
		int i = 0, j = 0;
		int cont = 0;
		while (compras[i] != null) { // Aqui se refiere a que si hubo una compra, se refiere al primer array
			while (compras[i][j] != null) { // Aqui se refiere al objeto que se compra o no, es el segundo array
				cont++;

			}

		} // En el primer while lo que hemos hecho es contar las veces que hemos comprado
		i = 0;
		j = 0;
		Producto[] dev = new Producto[cont];
		cont = 0;
		while (compras[i] != null) {
			while (compras[i][j] != null)
				dev[cont++] = compras[i][j]; // Con esto agregamos los productos que hemos comprado

		}
		return dev;// En este segundo while lo que hemos hecho es contar los productos que hemos
					// comprado, por eso el margen
	}// Es la cantidad de veces que hemos comprado, y teniendo en cuenta esto, los

	public abstract int oferta();

}
