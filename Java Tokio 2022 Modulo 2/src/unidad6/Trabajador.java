package unidad6;

public class Trabajador {
	private String nombre;
	private double salario;
	private int horas;

	public Trabajador(String nombre, double salario, int horas) {
		super();
		this.nombre = nombre;
		this.salario = salario;
		this.horas = horas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

}
