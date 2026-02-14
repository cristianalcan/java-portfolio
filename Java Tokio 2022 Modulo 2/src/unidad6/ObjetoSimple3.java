package unidad6;

import java.util.Objects;

public class ObjetoSimple3 {
	private int num;
	private String texto;

	public ObjetoSimple3(int num, String texto) {
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
	public String toString() {
		return "ObjetoSimple3 [num=" + num + ", texto=" + texto + "]";
	}

	public static boolean esMenor(ObjetoSimple3 num) {// Aqui estamos creando un metodo que se pueda referenciar, lo
														// hacemos para un removeIf, y este metodo necesita pasar por
														// parametro un ObjetoSimple3
		return num.getNum() < 5;
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
		ObjetoSimple3 other = (ObjetoSimple3) obj;
		return num == other.num && Objects.equals(texto, other.texto);
	}

}
