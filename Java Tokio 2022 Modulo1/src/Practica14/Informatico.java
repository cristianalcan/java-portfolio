package Practica14;

public class Informatico extends PAS {
	private int i;

	public Informatico(String nombre, String dni, int horasTrabajoAdicional) {
		super(nombre, dni, horasTrabajoAdicional);
		this.salario = 40 * 6 * 4;
		this.horasTrabajoAdicional = horasTrabajoAdicional;
		this.i = 0;
	}

	/**
	 * En este metodo se toman en cuenta las horas extra que haya trabajado el
	 * Informatico
	 */
	@Override
	public double CalcularSalario() {
		int sum;
		if (i < 1) {
			sum = horasTrabajoAdicional * 6;
			i++;
		} else {
			sum = 0;
		}

		return salario + sum;
	}

	@Override
	public String toString() {
		return nombre + ", soy Informatico";
	}

	public static void main(String[] args) {
		Informatico prueba = new Informatico("Jorge", "654321", 5);
		System.out.println(prueba.getSalario());
		System.out.println(prueba.getHorasTrabajoAdicional());
		System.out.println(prueba.CalcularSalario());
		System.out.println(prueba.CalcularSalario());

	}

}
