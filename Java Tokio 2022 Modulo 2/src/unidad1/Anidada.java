package unidad1;

public class Anidada {
	private int dato1;
	private int dato2;
	private int dato3;
	private interna1 an1;
	private interna2 an2;

	public Anidada(int dato1, int dato2, int dato3) {
		super();
		this.dato1 = dato1;
		this.dato2 = dato2;
		this.dato3 = dato3;
		an1 = new interna1("Esto es un texto", "Otro texto");
		an2 = new interna2(true);
	}

	public int getDato1() {
		return dato1;
	}

	public void setDato1(int dato1) {
		this.dato1 = dato1;
	}

	public int getDato2() {
		return dato2;
	}

	public void setDato2(int dato2) {
		this.dato2 = dato2;
	}

	public int getDato3() {
		return dato3;
	}

	public void setDato3(int dato3) {
		this.dato3 = dato3;
	}

	public interna1 getAn1() {
		return an1;
	}

	public void setAn1(interna1 an1) {
		this.an1 = an1;
	}

	public interna2 getAn2() {
		return an2;
	}

	public void setAn2(interna2 an2) {
		this.an2 = an2;
	}

	@Override
	public String toString() {
		return "Anidada [dato1=" + dato1 + ", an1=" + an1 + ", an2=" + an2 + "]";
	}

	public class interna1 {
		private String texto1;
		private String texto2;

		public interna1(String texto1, String texto2) {
			super();
			this.texto1 = texto1;
			this.texto2 = texto2;
		}

		public String getTexto1() {
			return texto1;
		}

		public void setTexto1(String texto1) {
			this.texto1 = texto1;
		}

		public String getTexto2() {
			return texto2;
		}

		public void setTexto2(String texto2) {
			this.texto2 = texto2;
		}

		@Override
		public String toString() {
			return "interna1 [texto1=" + texto1 + ", texto2=" + texto2 + "]";
		}

	}

	private class interna2 {
		private boolean condicion;

		public interna2(boolean condicion) {
			super();
			this.condicion = condicion;
		}

		public boolean isCondicion() {
			return condicion;
		}

		public void setCondicion(boolean condicion) {
			this.condicion = condicion;
		}

		@Override
		public String toString() {
			return "interna2 [condicion=" + condicion + "]";
		}

	}

	public static class estatica {
		int x;

		public estatica(int x) {
			super();
			this.x = x;
		}

		public void mostrar() {
			System.out.println(x);
		}
		public static void mostrar2() {
			System.out.println("Mensaje desde clase estatica");
		}
	}
}
