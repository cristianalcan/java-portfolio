package learning.tokioschool.helloworld;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		double notas[] = { 9.5, 10, 1.5, 6.3, 4.5, 5, 9, 8.5 };
		DescriptiveStatistics estadisticas = new DescriptiveStatistics();
		for (double item : notas) {
			estadisticas.addValue(item);
		}
		System.out.println("El percentil 50 de las notas es:" + estadisticas.getPercentile(50));
		/**
		 * Detalle importante cuando vayamos a crear un proyecto Maven, recordemos que
		 * en esta version de Eclipse aparece una casilla ya marcada al final que pone
		 * run archetype, pues esto lo vamos a desactivar ya que hace mucho mas lento el
		 * proceso y nos puede provocar problemas, por tanto la desactivaremos
		 */
	}
}
