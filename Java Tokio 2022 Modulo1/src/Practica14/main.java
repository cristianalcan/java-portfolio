package Practica14;

public class main {

	public static void main(String[] args) {
		Personal t1 = new Informatico("Luis", "123456", 5);
		Personal t2 = new Investigador("Sergio", "4565689");
		Personal t3 = new Profesor("David", "694357358", 7);
		Personal t4 = new Administrativo("Ana", "8484338", 5);
		Personal[] plantilla = { t1, t2, t3, t4 };
		Universidad prueba = new Universidad();

		System.out.println("Nominas contando las horas extras de administrativos e informaticos:");
		prueba.imprimirNominas(plantilla);
		System.out.println();
		System.out.print("El presupuesto total es ");
		System.out.println(prueba.obtenerPresupuestoTotal(plantilla) + " ya que no contamos las horas extras");
		System.out.println();
		System.out.println("Nominas sin contar las horas extras de administrativos e informaticos:");
		prueba.imprimirNominas(plantilla);

	}

}
