package unidad4;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Clase2 {

	public static void main(String[] args) {
		LocalDate fech3 = LocalDate.now().plusDays(150);
		LocalDate fech2 = LocalDate.now();

		// Para operar con 2 fechas vamos a ver como operar con ChronoUnit
		System.out.println(ChronoUnit.DAYS.between(fech2, fech3));// Asi calculamos la diferencia en dias
		System.out.println(ChronoUnit.MONTHS.between(fech2, fech3));// Asi calculamos la diferencia en meses

		// Para convertir por ejemplo fechas implementadas con la clase date y la
		// queremos convertir a una clase del paquete java.time haremos lo siguiente
		Date fech1 = new Date();
		System.out.println(fech1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());// Para mostrar la fecha
		System.out.println(fech1.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());// Para mostrar tambien
																								// la hora
		// Y si queremos por ejemplo convertir un date a un localdate
		// En el caso de abajo se mostraria el 19 de agosto de 2023 ya que el local date
		// es 150 dias despues del dia de su ejecucion
		System.out.println(Date.from(fech3.atStartOfDay(ZoneId.systemDefault()).toInstant()));

	}

}
