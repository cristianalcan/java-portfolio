package Practica14;

public class Investigador extends PDI {

	public Investigador(String nombre, String dni) {
		super(nombre, dni);
		salario = 35 * 7 * 4;
	}

	/**
	 * Con este metodo se obtiene el salario del Investigador
	 */
	@Override
	public double CalcularSalario() {
		return salario;
	}

	@Override
	public String toString() {
		return nombre + ", soy Investigador";
	}

	public static void main(String[] args) {
		Investigador prueba = new Investigador("Pepe", "123456");
		System.out.println(prueba.CalcularSalario());
	}

}
