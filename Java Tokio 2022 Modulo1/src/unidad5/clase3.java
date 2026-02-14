package unidad5;

public class clase3 {

	public static void main(String[] args) {
		Profesor pro = new Profesor("Luis", 1500, 10);
		System.out.println(pro.cantidadEstudiantes());
		Estudiante est1 = new Estudiante("Pedro", 25, "657123456");
		Estudiante est2 = new Estudiante("Ricardo", 24, "5342345789");
		Estudiante est3 = new Estudiante("Ricardo", 24, "5342345789");
		pro.agregarEstudiante(est1);
		System.out.println(pro.cantidadEstudiantes());
		for (int i = 0; i < 20; i++) {
			if (pro.agregarEstudiante(est2)) {
				System.out.println("Se ha agregado el estudiante");
			} else {
				System.out.println("No se pudo agregar el estudiante");
			}
		}
		System.out.println(pro.cantidadEstudiantes());
		if (est2.equals(est3)) {
			System.out.println("Iguales");
		}
		pro.eliminarRepetidos();
		System.out.println(pro.cantidadEstudiantes());

	}

}
