package unidad6;

public class Operaciones {
	
	public Operaciones(String txt) {//Con el constructor no haria falta que sea static
		System.out.println("Constructor "+txt);
	}
	
	public static boolean compararCon10(int num) {//Tiene que ser estatica para poder hacer referencia de metodos
		return num < 10;
	}

}
