package practica6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Bag<T> implements Iterable<T> {
	T[] elementos;
	int indice;

	public Bag() {
		super();
		elementos = (T[]) new Object[10];
		indice = 0;
	}

	public void add(T elemento) {
		elementos[indice++] = elemento;
	}

	public void clear() {
		for (int i = 0; i < elementos.length; i++) {
			elementos[i] = null;
		}
		indice = 0;
	}

	public boolean contains(T objeto) {
		for (int i = 0; i < elementos.length; i++) {
			if (elementos[i] == (objeto)) {
				return true;
			}
		}
		return false;
	}

	public boolean isEmpty() {
		return indice==0;
	}

	public int size() {
		return indice;
	}

	public T extract() {
		return elementos[new Random().nextInt(indice--)];
	}
	
	public T desEnColar() {
		T aux = elementos[0];
		for (int i = 0; i < indice; i++) {
			elementos[i]=elementos[i+1];
		}
		indice--;
		return aux;
	}

	@Override
	public String toString() {
		return "Bag [elementos=" + Arrays.toString(elementos) + ", indice=" + indice + "]";
	}

	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {
			int i = 0;

			@Override
			public boolean hasNext() {
				return i++ < indice;
			}

			@Override
			public T next() {
				 T aux= desEnColar();
				 add(aux);
				return aux;
			}
		};
	}

}
