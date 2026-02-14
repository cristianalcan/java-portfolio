package unidad6;

public class clase1 {

	public static void main(String[] args) {
		Estudiante e1 = new Tarde("Pedro", 22, "Repartidor");
		System.out.println(e1.NotaFinal());
		Diurno e2 = new Beca("Javier", 21, 88);
		System.out.println(e2.NotaFinal());
		System.out.println();
		e2.Proyecto();
		System.out.println();
		Estudiante e3 = new Financiado("Ana", 15, 99);
		Estudiante e4 = new Tarde("Lucas", 23, "Tecnico");
		Estudiante[] estudiantes = { e1, e2, e3, e4 };
		System.out.println(e3.NotaFinal()); // Vemos que coge la nota de Diurno porque es un objeto Diurno
											// Sin embargo, no podemos utilizar los metodos Diurnos porque es Estudiante
		System.out.println(((Diurno) e3).getAsistencia()); // Si no utilizamos el get, nos da error
		for (int i = 0; i < estudiantes.length; i++) {
			System.out.println(estudiantes[i]);
			System.out.println(estudiantes[i].NotaFinal());
			if (estudiantes[i] instanceof Diurno)
				System.out.println(((Diurno) estudiantes[i]).Proyecto()); // Tenemos que castearlo para que aparezca el
																			// metodo
			System.out.println(estudiantes[i].Aprobado());
			System.out.println(estudiantes[i].Titulacion());
			if (estudiantes[i] instanceof Diurno)
				System.out.println(((Diurno) estudiantes[i]).NotaExamenFinal());

		}

	}

}
