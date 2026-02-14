package unidad3;

import java.util.Scanner;

public class practica3 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int mates;
		int fisica;
		int quimica;
		int lengua;
		int histo;

		System.out.println("Dime tus notas con numeros enteros de las siguientes asignaturas: ");
		System.out.println("Matematicas: ");
		mates = Integer.parseInt(entrada.nextLine());
		System.out.println("Fisica: ");
		fisica = Integer.parseInt(entrada.nextLine());
		System.out.println("Quimica: ");
		quimica = Integer.parseInt(entrada.nextLine());
		System.out.println("Lengua: ");
		lengua = Integer.parseInt(entrada.nextLine());
		System.out.println("Historia: ");
		histo = Integer.parseInt(entrada.nextLine());

		int media = (mates + fisica + quimica + lengua + histo) / 5;
		System.out.println("La media de tus notas es: " + media);

		media = (mates + fisica + quimica + lengua + histo) / 5;
		switch (media) {
		case 0:
		case 1:
		case 2:
			System.out.println("Tu media es muy deficiente");
			break;
		case 3:
		case 4:
			System.out.println("Tu media es insuficiente");
			break;
		case 5:
			System.out.println("Tu media es suficiente");
			break;
		case 6:
			System.out.println("Tu media esta bien");
			break;
		case 7:
		case 8:
			System.out.println("Tu media es notable");
			break;
		case 9:
		case 10:
			System.out.println("Tu media es sobresaliente");
			break;

		default:
			break;
		}

	}

}
