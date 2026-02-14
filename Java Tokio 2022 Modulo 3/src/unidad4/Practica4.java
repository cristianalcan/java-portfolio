package unidad4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Practica4 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Fecha y hora actual: " + LocalDateTime.now());
		LocalDate fechaValida = null;
		while (fechaValida == null) {
			try {
				System.out.println("Introduce tu fecha de nacimiento en formato AAAA-MM-DD");
				String fecha = entrada.nextLine();
				fechaValida = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				fechaValida = fechaValida.withYear(LocalDate.now().getYear());
				if (fechaValida.isBefore(LocalDate.now())) {
					fechaValida = fechaValida.plusYears(1);
				}
				long diasFaltantes = ChronoUnit.DAYS.between(LocalDate.now(), fechaValida);
				if (fechaValida.isAfter(LocalDate.now())) {
					System.out.print("Aun quedan " + diasFaltantes + " dias para tu cumpleaños");
				} else if (fechaValida.isEqual(LocalDate.now())) {
					System.out.println("Feliz cumpleaños");
				} else if (fechaValida.isBefore(LocalDate.now())) {
					System.out.println("Tu cumpleaños ya pasó y quedan: " + diasFaltantes + " dias para tu cumpleaños");
				}
			} catch (Exception e) {
				System.err.println("Formato de fecha incorrecto, intentalo nuevamente");
			}
		}
	}
}
