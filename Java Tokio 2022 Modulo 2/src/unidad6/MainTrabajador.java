package unidad6;

import java.util.ArrayList;
import java.util.List;

public class MainTrabajador {

	public static void main(String[] args) {
		List<Trabajador> trabajadores = new ArrayList<>();
		trabajadores.add(new Trabajador("Luis", 1500, 140));
		trabajadores.add(new Trabajador("Carlos", 1200, 120));
		trabajadores.add(new Trabajador("Ana", 1600, 150));
		trabajadores.add(new Trabajador("Maria", 1200, 110));
		trabajadores.add(new Trabajador("Roberto", 1900, 80));

		Impuestos imp = t -> {
			return t.getSalario() * Impuestos.irpf / 100;// Con esto invocamos a la constante de la interfaz
		};
		// Con esto calculamos los IRPF de todos los trbajadores, t representa el
		// trabajador, e imprimimos la expresion lambda para el trabajador, en este caso
		// es t
		trabajadores.forEach(t -> System.out.println(imp.calcular(t)));

	}

}
