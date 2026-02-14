package practicaunidad6;

public class Cuenta {
	protected float saldo;
	protected int ingresos;
	protected int retiros;
	protected float tasaAnual;
	protected float comisionMensual;

	public Cuenta(float saldo, float tasaAnual) {
		super();
		this.saldo = saldo;
		this.tasaAnual = tasaAnual;
		this.comisionMensual = 0;
	}

	public float getSaldo() {
		return saldo;
	}

	public int getIngresos() {
		return ingresos;
	}

	public int getRetiros() {
		return retiros;
	}

	public float getTasaAnual() {
		return tasaAnual;
	}

	public float getComisionMensual() {
		return calculoInteres();
	}

	public int ingresoCuenta(int ingresos) {
		if (ingresos > 0) {
			this.saldo += ingresos;
		}
		return (int) saldo;
	}

	public int retiroCuenta(int retiros) {
		if (this.saldo >= retiros) {
			if (retiros > 0) {
				this.saldo -= retiros;
			}
		}
		return (int) saldo;
	}

	public float calculoInteres() {
		return (saldo * tasaAnual / 100) / 12;
	}

	public float extractoMensual() {
		saldo += calculoInteres();
		return saldo;
	}

	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", ingresos=" + ingresos + ", retiros=" + retiros + ", tasaAnual=" + tasaAnual
				+ ", comisionMensual=" + comisionMensual + "]";
	}

	public static void main(String[] args) {
		Cuenta c = new Cuenta(100, 15);
		System.out.println("El saldo es de: " + c.getSaldo());
		System.out.println("El saldo despues del retiro es: " + c.retiroCuenta(30));
		System.out.println("El saldo despues del ingreso es: " + c.ingresoCuenta(50));
		System.out.println("El interes es de " + c.calculoInteres() + " por ciento");
		System.out.println("El saldo despues del extracto es de: " + c.extractoMensual());
	}

}
