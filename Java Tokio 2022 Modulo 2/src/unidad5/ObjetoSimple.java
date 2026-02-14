package unidad5;

import java.util.Objects;

public class ObjetoSimple implements Comparable<ObjetoSimple> {
	private int num;
	private String texto;

	public ObjetoSimple(int num, String texto) {
		super();
		this.num = num;
		this.texto = texto;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num, texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjetoSimple other = (ObjetoSimple) obj;
		return num == other.num && Objects.equals(texto, other.texto);
	}

	@Override
	public int compareTo(ObjetoSimple o) {
		if (this.num < o.getNum()) {
			return -1;
		} else if (this.num > o.getNum()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "ObjetoSimple [num=" + num + ", texto=" + texto + "]";
	}

}
