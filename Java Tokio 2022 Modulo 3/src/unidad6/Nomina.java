package unidad6;

public class Nomina {
	private int mes;
	private double salario;
	private double irpf;

	public Nomina(int mes, double salario, double irpf) {
		super();
		this.mes = mes;
		this.salario = salario;
		this.irpf = irpf;
	}

	public int getMes() {
		return mes;
	}

	public double getSalario() {
		return salario;
	}

	public double getIrpf() {
		return irpf;
	}

	@Override
	public String toString() {
		return "Nomina [mes=" + mes + ", salario=" + salario + ", irpf=" + irpf + "]";
	}

}
