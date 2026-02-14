package unidad7;

public class SubClase1 implements Interface1 {
	private int x;

	public SubClase1(int x) {
		super();
		this.x = x;
	}

	@Override
	public void funcion1() {
		System.out.println("Nombre " + x);

	}

	@Override
	public int funcion2() {
		return x * Interface1.x;
	}

	public static void funcion6() {
		System.out.println("funcion estatica objeto");
	}

}
