package practicaunidad6;

public class Practica13 {

	public static void main(String[] args) {
		Cuenta prueba = new Cuenta(0, 0);
		System.out.println("El ingreso fue :"+prueba.ingresoCuenta(0));
		System.out.println("El saldo despues del ingreso es de : "+prueba.getSaldo());
		System.out.println("El retiro fue : "+prueba.retiroCuenta(0));
		System.out.println("El saldo despues del retiro es de : "+prueba.getSaldo());
		System.out.println("El interes es de: "+prueba.calculoInteres());
		System.out.println("El saldo despues de los intereses es: " + prueba.extractoMensual());
		System.out.println(prueba.getIngresos());
		System.out.println(prueba.getRetiros());
		System.out.println(prueba.getSaldo());
		System.out.println(prueba.getTasaAnual());
		System.out.println(prueba.getComisionMensual());

	}

}
