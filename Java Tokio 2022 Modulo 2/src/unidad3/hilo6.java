package unidad3;

import java.util.List;
import java.util.Random;

public class hilo6 extends Thread {
	List<Integer> lista;

	public hilo6(List<Integer> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public void run() {
	//	while (true) {
			lista.set(0, new Random().nextInt(1000));// Aqui estamos modificando un numero de la lista, la posicion 0
			if (lista.get(0) % 100 == 0) {
				System.out.println(lista.get(0));// Aqui estamos indicando que si el numero en la posicion 0 es
													// divisible por 100, entonces se imprime el valor, lo cual puede
													// generar un conflicto, ya que estamos accediendo al mismo elemento
													// en 2 instrucciones.
			}
		//}
	}
}
