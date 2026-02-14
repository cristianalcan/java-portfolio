package practica5;

public enum Palo {
	ESPADAS, BASTOS, COPAS, OROS;

	public char getAbreviatura() {
		switch (this) {
		case ESPADAS:
			return 'E';
		case BASTOS:
			return 'B';
		case COPAS:
			return 'C';
		case OROS:
			return 'O';
		}
		return ' ';
	}
}
