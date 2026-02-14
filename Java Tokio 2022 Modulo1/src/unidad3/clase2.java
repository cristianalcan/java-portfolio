package unidad3;

public class clase2 {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("hola "+i);
		}
		for (int i = 10; i > 0; i--) {
			System.out.println("contrario "+i);
		}
		for (int i = 3; i < 50; i+=3) {
			System.out.println("pares "+i);
		}
		
		int x =45645;
		int c=0;
		while (x%13!=0) {
			x=x*2-x/2;
			c++;
		}
		
		System.out.println("fin " + x + " cantidad " +c);
		
		x=0;
		while (x<0) {
			x++;
		}
		System.out.println(x);
		
		x=0;
		do {
			x++;
		} while (x<0);
		System.out.println(x);
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				if (j==8) {
					break;
				}
				if (j==5) {
					continue;
				}
				System.out.println(i +" - "+ j);
			}
		}

		
		
	}

}
