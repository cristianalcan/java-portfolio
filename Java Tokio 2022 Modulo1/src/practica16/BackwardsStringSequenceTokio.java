package practica16;

public class BackwardsStringSequenceTokio implements CharSequenceTokio {

	private String back;

	public BackwardsStringSequenceTokio(String back) {
		super();
		this.back = new StringBuilder(back).reverse().toString();
	}

	@Override
	public int length() {
		return back.length();
	}

	@Override
	public char charAt(int index) {
		if (index < 0 || index >= back.length()) {
			return 0;
		}
		return back.charAt(index);
	}

	@Override
	public CharSequenceTokio subSequence(int start, int end) {
		String c = "";
		if (start < 0 || end >= back.length() || start > end) {
			return null;
		}
		if (start == end) {
			return new BackwardsStringSequenceTokio(c);
		}
		String nuevo = back.substring(start, end);
		return new BackwardsStringSequenceTokio(new StringBuilder(nuevo).reverse().toString());
	}

	@Override
	public String toString() {
		return back.toString();
	}

	public static void main(String[] args) {
		String prueba = "hola";
		BackwardsStringSequenceTokio p = new BackwardsStringSequenceTokio(prueba);
		System.out.println(p.subSequence(1, 3));
	}

}
