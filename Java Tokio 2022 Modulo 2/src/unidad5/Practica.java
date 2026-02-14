package unidad5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Practica {

	public static void main(String[] args) {
		List<Integer> clientes = new ArrayList<>();// Son de tipo Integer porque le añadiremos un ID

		List<Stack<Integer>> contenedores = new LinkedList<>();// Esto va a contener todas las clases de contenedores,
																// por eso se pone Stack Integer como tipado

		// Stack<Integer> contenedor = new Stack<>();// Los productos se guardaran en
		// este contenedor y la idea es que
		// salgan los ultimos en entrar que seran los primeros en salir

		Map<Integer, List<Integer>> pedidos = new HashMap<>();// Los pedidos los haremos con Map ya que es mas facil de
																// utilizar porque usaremos a los clientes como claves y
																// a los contenedores como el valor, que sera
																// representado como la lista de productos que se
																// consumen

		Queue<Map.Entry<Integer, List<Integer>>> entregas = new ArrayDeque<>();// Como no vamos a trabajar con muchas
																				// entregas durante el dia, usaremos el
																				// array ya que con cantidades pequeñas
																				// funciona muy bien

		generarClientes(clientes);
		System.out.println(clientes.size() + " - " + clientes.get(0) + " - " + clientes.get(clientes.size() - 1));
		generarContenedores(contenedores);
		System.out.println(contenedores.size() + " - " + contenedores.get(0).size());// Con esto vemos la cantidad de
																						// contenedores que hay y la
																						// cantidad de productos que hay
																						// en el contenedor 0
		generarPedidos(contenedores, clientes, pedidos);
		for (int i = 0; i < 5; i++) {// Vamos a mostrar 5 pedidos de clientes

			System.out.println(pedidos.get(clientes.get(i)).size());// Con esto lo que hacemos es entrar en pedidos, y
																	// tenemos que poner la clave que en este caso son
																	// los clientes y obtenemos su pedido, y luego el
																	// tamaño de los pedidos
		}

	}

	public static void generarClientes(List<Integer> clientes) {
		for (int i = 0; i < 1000; i++) {
			rellenarCollection(clientes);// Le asignamos un ID a cada cliente
		}
	}

	public static void realizarEntregas(Queue<Map.Entry<Integer, List<Integer>>> entregas,
			Map<Integer, List<Integer>> pedidos) {// Hemos puesto Map.entry para asi poder usar el for each y
													// basicamente en lo que cambia es que el .entry retorna un
													// conjunto de parejas clave-valor, en este caso todos los de
													// pedidos.
		for (Map.Entry<Integer, List<Integer>> pedido : pedidos.entrySet()) {
			entregas.add(pedido);// Le añadimos a las entregas los pedidos
		}
	}

	public static void generarContenedores(List<Stack<Integer>> contenedores) {
		for (int i = 0; i < 10; i++) {
			contenedores.add(new Stack<Integer>());// Vamos a generar 10 nuevos contenedores vacios

			for (int j = 0; j < 1000; j++) {
				rellenarCollection(contenedores.get(i));// Esto lo hacemos para asignarle un ID a cada producto y no
														// se repita

			}
		}
	}

	public static void generarPedidos(List<Stack<Integer>> contenedores, List<Integer> clientes,
			Map<Integer, List<Integer>> pedidos) {// Necesitamos recibir por parametro los productos, los clientes, y
													// el map de pedidos que es a lo que vamos a agregar estos clientes
													// y productos

		for (int i = 0; i < 100; i++) {// Vamos a generar 100 pedidos

			List<Integer> compra = new ArrayList<>();// En esta lista vamos a añadir los productos como tal, que pueden
														// ser 1000, ya que cada contenedor contiene 1000 productos
			for (int j = 0; j < 10; j++) {
				compra.add(contenedores.get(new Random().nextInt(10)).pop()); // Aqui le añadimos a la compra un
																				// contenedor random y una vez
																				// seleccionado, lo eliminamos ya que se
																				// vende
			}
			pedidos.put(clientes.get(new Random().nextInt(1000)), compra);// Generamos un cliente random de los 1000 ya
																			// generados, y le añadimos la lista de la
																			// compra

		}
	}

	public static void rellenarCollection(Collection<Integer> coll) {// Recibimos unos datos de tipo Collection para que
																		// asi podamos recibir cualquier tipo de datos

		int id = 0;// Esta funcion la hacemos para crear un nuevo ID a cada identificador como los
					// contenedores o los clientes, si es que la lista que hemos pasado por
					// parametro contiene el numero random que se ha generado, se sigue ejecutando
					// hasta que no lo contenga, y luego este numero se le añade a la lista como ID
		do {
			id = new Random().nextInt(900000) + 100000;
		} while (coll.contains(id));
		coll.add(id);
	}

}
