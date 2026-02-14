package unidad4;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Clase1 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		// Vamos a comenzar esta Unidad que se trata de las APIS de fecha y localizacion
		// Comenzaremos hablando primero de la API que es antigua
		Date fech1 = new Date();// Es la forma de especificar una fecha mas antigua

		System.out.println(fech1.toString());// Con este metodo nos muestra cuando ejecutemos, la fecha en la que lo
												// estamos ejecutando, con dia, año y mes, todo detallado

		System.out.println(fech1.getTime());// Con este metodo nos obtiene el tiempo que ha pasado desde 1970 hasta el
											// momento en el que se ha ejecutado el syso en milisegundos
		System.out.println();

		// Ahora enseñaremos cual es el paquete con el que se trabaja normalmente ya que
		// es mas moderno

		// Primero hay que especificar que creando esta variable, no podemos crearla con
		// un new localdate, sino que ya tenemos que asignarle un "valor" y en este caso
		// usamos el localdate now que significa la fecha de ahora
		LocalDate fech2 = LocalDate.now();
		System.out.println(fech2);
		System.out.println();

		// Luego este localdate tiene muchos metodos, este por ejemplo, lo que hace es
		// añadirle 10 dias a la fecha en la que se ejecuta
		LocalDate fech3 = LocalDate.now().plusDays(100);
		System.out.println(fech3);
		System.out.println();

		// Luego tenemos esta clase en la que solo muestra la hora, nada mas
		LocalTime time1 = LocalTime.now();
		System.out.println(time1);
		System.out.println();

		// Con esta clase lo que hace es juntar la fecha con la hora
		LocalDateTime fech4 = LocalDateTime.now();
		System.out.println(fech4);
		System.out.println();

		// Luego contamos con una clase que nos permite formatear o manipular las fechas

		// Cuando ponemos esto la fecha tiene que cumplir al 100% el patron, los guiones
		// tambien en el orden correcto, y tiene que haber 2 digitos en el dia y mes, y
		// 4 en el año, ademas tienen que cumplir que por ejemplo el dia no puede ser
		// mayor de 31 o el mes mayor que 12
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

//		System.out.println("Introduce una fecha");
//		String fechatext = entrada.nextLine();// Aqui recibimos la fecha por consola
		LocalDate fech5 = LocalDate.now();// Asignamos el valor de ahora a la fecha
		try {
//			fech5 = LocalDate.parse("19/02/2021", format);// Aqui intentamos que la fecha que se ha introducido por
			// consola sea la que se quede, pero tambien ponemos que se
			// tiene que cumplir el patron de formato
		} catch (Exception e) {
			System.out.println("Fecha incorrecta introduzcala nuevamente");
		}
		System.out.println(fech5);
		System.out.println();

		// Java tiene tambien la clase Month y es que como los meses tambien tienen
		// nombre, pues con esta clase utilizamos los nombres de los meses
		Month mes = Month.APRIL;
		System.out.println(mes);
		System.out.println();

		// Pasa algo similar con los dias de la semana ya que los dias tienen tambien
		// nombres
		DayOfWeek diaSem = DayOfWeek.MONDAY;
		System.out.println(diaSem);
		System.out.println(diaSem.getValue());// Aqui por ejemplo con este metodo lo que hace es devolver el numero en
												// el que se posiciona dentro de una semana
		System.out.println();

		// Tambien contamos con una clase para hayar un periodo de tiempo, normalmente
		// esta clase es para fechas
		Period per = Period.between(fech5, fech3);// Aqui estamos comparando la diferencia entre la fecha 3 y la 5
		System.out.println(per.getMonths());
		System.out.println(per.getDays());
		System.out.println(per);
		System.out.println();

		// Tambien tenemos una clase que es para contar una duracion, esto es para la
		// hora, no fechas
		Duration dur = Duration.ofHours(20);
		System.out.println(dur.toMinutes());// Aqui pasamos las horas de la duration a minutos
		System.out.println();

		// Tambien tenemos la clase Instant que es para obtener el instante de la
		// ejecucion
		Instant inst = Instant.now();
		System.out.println(inst);// Cuando la ejecutamos nos da el tiempo con una hora menos
		

	}

}
