package unidad7;

public class clase1 {

	public static void main(String[] args) {
		SubClase1 sc1 = new SubClase1(23);
		// sc1.funcion1();
		// System.out.println("Operacion " + sc1.funcion2());
		SubClase2 sc2 = new SubClase2();
		// sc2.funcion1();
		// System.out.println("Operacion " + sc2.funcion2());
		Interface1[] datos = new Interface1[4];
		datos[0] = sc1;
		datos[1] = sc2;
		datos[2] = new SubClase2();
		Interface1 sc3 = new SubClase1(56);
		datos[3] = sc3;
		for (int i = 0; i < datos.length; i++) {
			datos[i].funcion1();
			System.out.println("Operacion " + datos[i].funcion2());
			System.out.println(datos[i].funcion5());
			if (datos[i] instanceof SubClase2) {
				((SubClase2) datos[i]).funcion3();
			}
		}
		System.out.println(Interface1.x);
		SubClase1.funcion6();
		Interface1.funcion4(); // No se puede implementar esta funcion en objetos de clases que implementen la
								// interfaz, tiene que ser desde la propia inerfaz
		System.out.println(sc1.funcion5());

	}

}
