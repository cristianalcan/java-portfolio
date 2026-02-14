package unidad5;

import java.util.Iterator;

public class ArrayCola<T> implements Cola<T>, Iterable<T> {
	private T[] arr;
	private int n;

	public ArrayCola() {
		super();
		this.arr = (T[]) new Object[100];
		n = 0;
	}

	@Override
	public void enColar(T valor) {
		this.arr[n++] = valor;// Como esto es una cola, pues se va añadiendo en orden

	}

	@Override
	public T desEnColar() {
		T aux = arr[0];// Desencolar basicamente se refiere a mostrar el primer elemento que entro a la
						// cola y el primero en salir, por eso le asignamor el arr en la primera
						// posicion.

		for (int i = 0; i < n; i++) {// Aqui lo que hacemos es pasar los elementos que estan arriba del primero una
										// posicion mas abajo
			arr[i] = arr[i + 1];
		}
		n--;// Disminuye el tamño, ya que hemos eliminado el primer elemento
		return aux;// Mostramos el primer elemento
	}

	@Override
	public T Frente() {
		return arr[0];// Aqui queremos que muestre el primer elemento de la cola
	}

	@Override
	public boolean Vacia() {
		return n == 0;// Si n que es el tamño es igual a 0 esta vacia y retorna true sino es false
	}

	@Override
	public Iterator<T> iterator() {// Es el tipico iterador que cuenta con estas 2 funciones, y lo normal es
									// utilizarlo como una especie de filtro, para ver que objetos son los
									// siguientes o no
		Iterator<T> it = new Iterator<T>() {
			int i = 0;

			@Override
			public boolean hasNext() {
				return i++ < n;// Si no esta vacia retorna true y significa que hay siguiente
			}

			@Override
			public T next() {
				T aux = desEnColar();// Al auxiliar le pasamos el primer numero en salir
				enColar(aux);// Luego lo volvemos a añadir
				return aux;// Y retornara siempre la primera posicion, lo que sera un bucle infinito, es
							// decir, que hasta que no eliminemos nostros con desencolar, cuando pasemos
							// next no se eliminaran los elementos
			}
		};
		return it;
	}

}
