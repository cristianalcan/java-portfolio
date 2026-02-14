package Practica14;

public class Administrativo extends PAS {
	private int i;

	public Administrativo(String nombre, String dni, int horasTrabajoAdicional) {
		super(nombre, dni, horasTrabajoAdicional);
		salario = 37 * 7.5 * 4;
		this.i = 0;
	}

	/**
	 * En este metodo se toman en cuenta las horas extra que haya trabajado el
	 * Administrativo
	 */
	@Override
	public double CalcularSalario() {
		int horasExtra;
		if (i < 1) {
			horasExtra = horasTrabajoAdicional * 6;
			i++;
		} else {
			horasExtra = 0;
		}

		return salario + horasExtra;

	}

	@Override
	public String toString() {
		return nombre + ", soy Administrativo";
	}

	public static void main(String[] args) {
		Administrativo prueba = new Administrativo("Sara", "67890", 10);
		System.out.println(prueba.getSalario());
		System.out.println(prueba.getHorasTrabajoAdicional());
		System.out.println(prueba.CalcularSalario());
		System.out.println(prueba.CalcularSalario());
	}
}
