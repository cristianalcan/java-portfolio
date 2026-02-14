package unidad4;

import java.util.ArrayList;
import java.util.List;

public class repaso {
	public static void main(String[] args) {
		List<Vehiculo> vehiculos = new ArrayList<>();

		try {
			vehiculos.add(new Vehiculo("Honda", "a1", "", ""));
		} catch (Exception e) {
			System.out.println("Fecha incorrecta");
		}

		// Para ordenar la lista de vehiculos en base a su fecha de produccion lo
		// haremos asi
		vehiculos.sort((v1, v2) -> v1.getFechaPro().compareTo(v2.getFechaPro()));

		// Si por ejemplo queremos un vehiculo que sea nuevo y que no lleve mas de 3
		// años producido haremos lo siguiente. En este caso con el foreach se
		// mostrarian todos los que cumplan la condicion
		vehiculos.stream().filter(v -> v.esNuevo() && v.añosProducido() < 3).forEach(v -> System.out.println(v));
	}

}
