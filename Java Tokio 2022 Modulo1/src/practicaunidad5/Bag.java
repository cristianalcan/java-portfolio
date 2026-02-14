package practicaunidad5;

import java.util.Random;

public class Bag {
	private Object[] elemento = new Object[4];

	public Bag() {
		super();
		this.elemento[0] = 54;
		this.elemento[1] = "Hola";
		this.elemento[2] = 'a';
		this.elemento[3] = null;

	}

	public boolean add(Object e) {
		for (int i = 0; i < elemento.length; i++) {
			if (elemento[i] == null) {
				elemento[i] = e;
				return true;
			}
		}

		return false;
	}

	public void clear() {
		for (int i = 0; i < elemento.length; i++) {
			elemento[i] = null;
		}

	}

	public boolean contains(Object o) {
		for (int i = 0; i < elemento.length; i++) {
			if (elemento[i] == o) {
				return true;
			}
		}
		return false;

	}

	public boolean isEmpty() {
		for (int i = 0; i < elemento.length; i++) {
			if (elemento[i] != null) {
				return false;
			}
		}

		return true;
	}

	public int size() {
		return elemento.length;
	}

	public Object extract() {

		return elemento[new Random().nextInt(4)];

	}

}
