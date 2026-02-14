package Practica14;

public class Profesor extends PDI {
	protected int sexenios;

	public Profesor(String nombre, String dni, int sexenios) {
		super(nombre, dni);
		salario = 37 * 8 * 4;
		this.sexenios = sexenios;
	}

	public int getAñosTrabajados() {
		return sexenios;
	}

	/**
	 * En este metodo se toma en cuenta los sexenios que haya trabajado el Profesor
	 */
	@Override
	public double CalcularSalario() {
		int sum = 0;
		if (sexenios == 1) {
			sum += 100;
		} else if (sexenios == 2) {
			sum += 200;
		} else if (sexenios == 3) {
			sum += 300;
		} else if (sexenios == 4) {
			sum += 400;
		} else if (sexenios == 5) {
			sum += 500;
		} else if (sexenios >= 6) {
			sum += 600;
		}
		return salario + sum;
	}

	@Override
	public String toString() {
		return nombre + ", soy Profesor";
	}

	public static void main(String[] args) {
		Profesor prueba = new Profesor("Cristian", "654321", 3);
		System.out.println(prueba.getSalario());
		System.out.println(prueba.getAñosTrabajados());
		System.out.println(prueba.CalcularSalario());
	}

}
