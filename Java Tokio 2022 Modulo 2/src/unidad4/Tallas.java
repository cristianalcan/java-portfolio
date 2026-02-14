package unidad4;

public enum Tallas {
	XS, S, M, L, XL, XXL;

	public static boolean esTuTalla(int tam, Tallas t) {
		switch (t) {
		case XS:
			return tam < 32;
		case S:
			return tam >= 32 && tam < 38;
		case M:
			return tam >= 38 && tam < 42;
		case L:
			return tam >= 42 && tam < 44;
		case XL:
			return tam >= 44 && tam < 46;
		case XXL:
			return tam >= 46;

		}
		return true;
	}
}
