package practica18;

public class CalculosNumericos {
	public static double logaritmo(double l) {
		double x = 0;
		try {
			if (l < 0) {
				throw new ArithmeticException("Para hallar el logaritmo tienes que introducir un numero positivo");
			} else {
				x = Math.log(l);
			}
			return x;
		} finally {
		}
	}

	public static double raizCuadrada(double r) {
		double x = 0;
		try {
			if (r < 0) {
				throw new ArithmeticException("Para hallar la raizCuadrada tienes que introducir un numero positivo");
			} else {
				x = Math.sqrt(r);
			}
			return x;
		} finally {
		}
	}

}
