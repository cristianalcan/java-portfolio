package unidad3;

public class clase1 {

	public static void main(String[] args) {
		int x = 20;
		if (x > 10) {
			System.out.println("Condicion cumplida");
			int y = 9;
			if (y < x) {

			}
		}

		if (x < 10) {
			System.out.println("Entraria todos los valores inferiores a 10");
		} else {
			System.out.println("Entraria todos los valores igual o superior a 10");
		}

		int edad = 15;

		if (edad < 0 || edad > 130) {
			System.out.println("Error edad no valida");

		} else {
			if (edad < 18) {
				System.out.println("Menor de edad");
			} else if (edad < 30) {
				System.out.println("Joven");
			} else if (edad < 65) {
				System.out.println("Adulto");
			} else {
				System.out.println("Anciano");
			}
		}
		x = 1;
		String y= "b";
		switch (x) {
		case 1:
			System.out.println("Opcion 1");
			break;
		case 2:
			System.out.println("Opcion 2");
			break;
		case 3:
			System.out.println("Opcion 3");
			break;

		default:
			System.out.println("Por defecto");
			break;
		}
		if (y=="b") {
			System.out.println("ha comparado correctamente");
			
		}
	}

}
