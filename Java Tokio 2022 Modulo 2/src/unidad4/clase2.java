package unidad4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class clase2 {
	public static void main(String[] args) {
		Prenda[] prendas = new Prenda[10];
		List<Prenda> lista = new ArrayList<>();
		for (int i = 0; i < prendas.length; i++) {
			prendas[i] = new Prenda(Tallas.values()[new Random().nextInt(6)], new Random().nextInt(40) + 10);
			lista.add(prendas[i]);
			// Con values, se refiere a que examina todos los atributos de el enum, pero
			// nosotros hemos puesto con posicion especifica random
			System.out.println(prendas[i]);
		}
		System.out.println("----------------------------");
		Collections.sort(lista);
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		
		System.out.println(Tallas.esTuTalla(41, Tallas.M));//Con esto me dice si es mi talla o no
	}

}
