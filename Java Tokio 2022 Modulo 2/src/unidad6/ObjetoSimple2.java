package unidad6;

public class ObjetoSimple2 {
	private int num;
	private String texto;

	public ObjetoSimple2(int num, String texto) {
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
		return "ObjetoSimple2 [num=" + num + ", texto=" + texto + "]";
	}
	
}
