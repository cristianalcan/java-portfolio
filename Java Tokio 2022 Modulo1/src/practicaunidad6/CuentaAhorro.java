package practicaunidad6;

public class CuentaAhorro extends Cuenta {
	private boolean cuentaActiva;
	private int indice;

	public CuentaAhorro(float saldo, float tasaAnual) {
		super(saldo, tasaAnual);
		this.saldo = saldo;
		if (saldo < 100) {
			this.cuentaActiva = false;
		} else {
			this.cuentaActiva = true;
		}
		this.indice = 0;

	}

	public boolean isCuentaActiva() {
		return cuentaActiva;
	}

	@Override
	public int ingresoCuenta(int ingresos) {
		if (cuentaActiva == true) {
			indice++;
			saldo += ingresos;
			return (int) saldo;
		} else
			return 0;
	}

	@Override
	public int retiroCuenta(int retiros) {
		if (this.saldo >= retiros) {
			if (cuentaActiva == true) {
				indice++;
				saldo -= retiros;
			}
		}
		return (int) saldo;
	}

	@Override
	public float extractoMensual() {
		float j = 0;
		for (int i = 4; i < indice; i++) {
			j += 1.5F;

		}
		return saldo -= j;

	}

	public int transacciones() {
		return indice;
	}

	@Override
	public String toString() {
		return "CuentaAhorro [cuentaActiva=" + cuentaActiva + ", indice=" + indice + "]";
	}

	public static void main(String[] args) {
		CuentaAhorro prueba = new CuentaAhorro(120, 20);
		System.out.println("La cuenta esta activa: " + prueba.isCuentaActiva());
		System.out.println("La comision mensual es del " + prueba.calculoInteres() + " por ciento");
		System.out.println("El saldo es de: " + prueba.getSaldo());
		System.out.println("El saldo despues del retiro es: " + prueba.retiroCuenta(30));
		System.out.println("El saldo despues del ingreso es: " + prueba.ingresoCuenta(50));
		System.out.println("El saldo despues del extracto es de: " + prueba.extractoMensual());
		System.out.println("El numero de transacciones fue: " + prueba.transacciones());

	}

}
