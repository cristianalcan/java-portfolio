package practica5;

public enum Numero {
	AS, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, SOTA, CABALLO, REY;

	public char getAbreviatura() {
		switch (this) {
		case AS:
			return 'A';
		case DOS:
			return '2';
		case TRES:
			return '3';
		case CUATRO:
			return '4';
		case CINCO:
			return '5';
		case SEIS:
			return '6';
		case SIETE:
			return '7';
		case SOTA:
			return 'S';
		case CABALLO:
			return 'C';
		case REY:
			return 'R';
		}
		return ' ';
	}
}
