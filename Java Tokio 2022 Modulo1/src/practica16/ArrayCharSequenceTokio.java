package practica16;

public class ArrayCharSequenceTokio implements CharSequenceTokio {
	private char[] array;

	public ArrayCharSequenceTokio(char[] array) {
		this.array = array;
	}

	@Override
	public int length() {
		return array.length;
	}

	@Override
	public char charAt(int index) {
		if (index < 0 || index >= array.length) {
			return 0;
		}
		return array[index];
	}

	@Override
	public CharSequenceTokio subSequence(int start, int end) {
		int indice = 0;
		char[] c = new char[array.length];
		char[] c2 = new char[1];
		c2[0] = ' ';
		if (start < 0 || end >= array.length || start > end) {
			return null;
		}
		if (start == end) {
			return new ArrayCharSequenceTokio(c2);
		}
		for (int i = start; i < end; i++) {
			c[indice++] = array[i];
		}
		
		return new ArrayCharSequenceTokio(c);
	}

	@Override
	public String toString() {
		return new String(array);
	}
	
	public static void main(String[] args) {
		char[] prueba= new char[7];
		prueba[0]='r';
		prueba[1]='e';
		prueba[2]='t';
		prueba[3]='u';
		prueba[4]='r';
		prueba[5]='n';
		ArrayCharSequenceTokio p= new ArrayCharSequenceTokio(prueba);
		System.out.println(p.subSequence(3, 6).toString());  
		
	}

}
