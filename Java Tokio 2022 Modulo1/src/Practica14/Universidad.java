package Practica14;

public class Universidad {
	/**
	 * Con este metodo vamos a imprimir las nominas de los trabajadores
	 * 
	 * @param listaPersonal son los trabajadores que pasamos por parametro y
	 *                      calculamos sus nominas
	 */
	public static void imprimirNominas(Personal[] listaPersonal) {
		for (int i = 0; i < listaPersonal.length; i++) {
			System.out.println(
					"Mi nombre es " + listaPersonal[i] + " y mi nomina es " + listaPersonal[i].CalcularSalario());
		}

	}

	/**
	 * En este metodo vamos a sumar todos los salarios, OJO, en el main,
	 * ejecutaremos primero el metodo imprimirNominas, lo que va a hacer que cuendo
	 * ejecutemos este metodo, ya no se cuenten las horas extra de los trabajadores,
	 * recordemos que, una vez contadas las horas extra, se igualan a 0
	 * 
	 * @param listaPersonal son los trabajadores que se van a calcular el salario y
	 *                      sumar
	 * @return la suma total de todos los salarios
	 */
	public static double obtenerPresupuestoTotal(Personal[] listaPersonal) {
		double suma = 0;
		for (int i = 0; i < listaPersonal.length; i++) {
			if (listaPersonal[i] instanceof Informatico) {
				suma += listaPersonal[i].CalcularSalario();
			} else if (listaPersonal[i] instanceof Administrativo) {
				suma += listaPersonal[i].CalcularSalario();
			} else if (listaPersonal[i] instanceof Profesor) {
				suma += listaPersonal[i].CalcularSalario();
			} else if (listaPersonal[i] instanceof Investigador) {
				suma += listaPersonal[i].CalcularSalario();
			}
		}
		return suma;
	}
}
