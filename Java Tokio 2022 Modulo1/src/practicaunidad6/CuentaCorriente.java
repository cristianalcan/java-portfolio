package practicaunidad6;

public class CuentaCorriente extends Cuenta {
	private int sobregiro;
	private int indice;

	public CuentaCorriente(float saldo, float tasaAnual) {
		super(saldo, tasaAnual);
		this.sobregiro = 0;
		this.indice = 0;
	}

	public int getSobregiro() {
		return sobregiro;
	}

	@Override
	public int retiroCuenta(int retiros) {
		if (retiros > saldo) {
			indice++;
			sobregiro = retiros - (int) saldo;
			saldo = 0;
			return (int) saldo;
		}
		indice++;
		saldo -= retiros;

		return (int) saldo;
	}

	@Override
	public int ingresoCuenta(int ingresos) {
		if (ingresos > sobregiro) {
			indice++;
			ingresos -= sobregiro;
			saldo += ingresos;
			sobregiro = 0;
			return (int) saldo;
		} else
			indice++;
		saldo = 0;
		sobregiro -= ingresos;
		return (int) saldo;

	}

	@Override
	public float extractoMensual() {
		return super.extractoMensual();// Esto lo dejo tal cual porque el PDF pone que solo lo invoque
	}

	public int transacciones() {
		return indice;
	}

	@Override
	public String toString() {
		return "CuentaCorriente [sobregiro=" + sobregiro + ", indice=" + indice + "]";
	}

	public static void main(String[] args) {
		CuentaCorriente prueba = new CuentaCorriente(49, 15);
		System.out.println("El saldo disponible es: " + prueba.getSaldo());
		System.out.print("Despues del retiro el saldo es: " + prueba.retiroCuenta(60));
		System.out.println(" y el sobregiro es " + prueba.getSobregiro());
		System.out.print("El saldo despues del ingreso es " + prueba.ingresoCuenta(50));
		System.out.println(" y el sobregiro es " + prueba.getSobregiro());
		System.out.println("Despues del extracto mensual el saldo es " + prueba.extractoMensual());
		System.out.println("El numero de transacciones fue " + prueba.transacciones());

	}
}
