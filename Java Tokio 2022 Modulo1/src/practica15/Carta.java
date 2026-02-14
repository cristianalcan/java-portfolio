package practica15;

public class Carta implements Comparable<Carta> {
	private final String numero;
	private final String palo;

	public Carta(String numero, String palo) {
		this.numero = numero;
		this.palo = palo;
	}

	public String getNumero() {
		return numero;
	}

	public String getPalo() {
		return palo;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 47 * hash + (this.numero != null ? this.numero.hashCode() : 0);
		hash = 47 * hash + (this.palo != null ? this.palo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Carta other = (Carta) obj;
		if (this.numero != other.numero) {
			return false;
		}
		if (this.palo != other.palo) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return numero + " " + palo;
	}

	/**
	 * Aqui le asignamor un valor a cada carta, ya que como son String, no las
	 * podemos comparar en funcion de su valor numerico(si que se puede pero con
	 * codigo ASCII y en este ejercicio no nos sirve)
	 * 
	 * @return un numero que saldra en funcion de la carta de la que se trate
	 */
	public int obtenerValor() {
		switch (numero) {
		case "AS":
			return 1;
		case "DOS":
			return 2;
		case "TRES":
			return 3;
		case "CUATRO":
			return 4;
		case "CINCO":
			return 5;
		case "SEIS":
			return 6;
		case "SIETE":
			return 7;
		case "SOTA":
			return 10;
		case "CABALLO":
			return 11;
		case "REY":
			return 12;
		}
		return 0;
	}

	/**
	 * Este metodo es para poder darle un "valor" a como estan instanciadas los
	 * palos dentro del array de palos de la clase Baraja
	 * 
	 * @return un numero en funcion de que palo haya salido
	 */
	public int ordenNatural() {
		switch (palo) {
		case "ESPADAS":
			return 1;
		case "COPAS":
			return 2;
		case "BASTOS":
			return 3;
		case "OROS":
			return 4;
		}
		return 0;
	}

	/**
	 * Aqui implementamos la interfaz Comparable que nos pide el ejercicio, y con
	 * este metodo lo que haremos sera comparar las cartas en funcion de su "valor"
	 * por ejemplo :AS es menor que DOS.
	 */
	@Override
	public int compareTo(Carta o) {
		if (obtenerValor() < o.obtenerValor()) {
			return -1;
		} else if (obtenerValor() > o.obtenerValor()) {
			return 1;
		}
		return 0;
	}
}
