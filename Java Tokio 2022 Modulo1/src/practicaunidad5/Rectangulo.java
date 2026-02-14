package practicaunidad5;

public class Rectangulo {
	private int base;
	private int altura;

	public Rectangulo(int base, int altura) {
		super();
		this.base = Math.abs(base);
		this.altura = Math.abs(altura);
	}

	public Rectangulo() {
		super();
		base = 2;
		altura = 1;
	}

	public boolean esCuadrado() {
		if (base == altura) {
			return true;
		} else {
			return false;
		}

	}

	public int area() {
		int a;
		a = base * altura;
		return a;
	}

	public int perimetro() {
		int p;
		p = base + base + altura + altura;
		return p;
	}

	public void gira() {
		int cambio;
		cambio = base;
		base = altura;
		altura = cambio;

	}

}
