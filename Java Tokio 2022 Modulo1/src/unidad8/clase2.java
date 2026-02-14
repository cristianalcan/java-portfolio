package unidad8;

public class clase2 extends Exception {
	private int num;

	public clase2(String mensaje, int num) {
		super(mensaje);
		this.num = num;
	}

	public clase2() {
	}

	public int getCorrectNumber() {
		return -num;
	}

}
