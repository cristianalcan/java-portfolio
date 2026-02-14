package unidad1;

public class clase1 {

	public static void main(String[] args) {
		Anidada an = new Anidada(1, 2, 3);
		System.out.println(an);
		Anidada.interna1 i1 = an.getAn1(); // Para poder crear un objeto de una clase interna, tenemos que hacerlo a
											// partir de un objeto ya creado de la clase externa.
		Anidada.estatica est = new Anidada.estatica(10);
		est.mostrar();
		Anidada.estatica.mostrar2();
		claseLocal();
	}

	public static void claseLocal() {
		class Local {
			private int v1;
			private String v2;

			public Local(int v1, String v2) {
				super();
				this.v1 = v1;
				this.v2 = v2;
			}

			public int getV1() {
				return v1;
			}

			public void setV1(int v1) {
				this.v1 = v1;
			}

			public String getV2() {
				return v2;
			}

			public void setV2(String v2) {
				this.v2 = v2;
			}

			@Override
			public String toString() {
				return "Local [v1=" + v1 + ", v2=" + v2 + "]";
			}

		}
		Local l = new Local(123, "Texto");
		System.out.println(l);
	}
}
