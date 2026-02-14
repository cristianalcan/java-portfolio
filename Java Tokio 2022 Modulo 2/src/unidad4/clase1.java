package unidad4;

public class clase1 {
	public static void main(String[] args) {
		Integer x = 10;
		Character y = 'r';
		Double z;
		int x1 = 15;
		char y1 = 'f';

		x = Integer.valueOf(x1);// Unboxing, le pasas el valor de un int a un Integer
		x1 = x.intValue();// Autoboxing

		y = Character.valueOf(y1);
		y1 = y.charValue();

		Persona p = new Persona("Pedro", 24, GradoAcademico.FP); // Asi es como se pondria el grado, y para esto sirve
																	// las enumeraciones
		if (p.getGrado() == GradoAcademico.FP) {
			System.out.println("Grado Academico Formacion profesional");
		}

		if (p.getGrado().getNivel() > GradoAcademico.ESO.getNivel()) {
			System.out.println("Tiene un grado superior a la Secundaria");
		}
		System.out.println(GradoAcademico.UNIVERSITARIO);
		System.out.println(p.getGrado());
		System.out.println(GradoAcademico.ESO + " " + GradoAcademico.ESO.SalarioMinimo());
		System.out.println(GradoAcademico.FP + " " + GradoAcademico.FP.SalarioMinimo());

		System.out.println(GradoAcademico.ESO.compareTo(GradoAcademico.UNIVERSITARIO));// Esto es la resta entre eso y
																						// universitario
		System.out.println(GradoAcademico.ESO.ordinal());//Esto devuelve la posicion en la que se encuentra en el enum
		System.out.println(GradoAcademico.ESO.name());//Devuelve el nombre declarado de la constante
		
	}

}
