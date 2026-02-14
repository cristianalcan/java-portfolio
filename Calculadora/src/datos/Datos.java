package datos;

import java.util.ArrayList;
import java.util.List;

public class Datos {
	public List<String> datos;
	public Datos() {
		datos = new ArrayList<>();
	}
	public static void main(String[] args) {
		Datos datos = new Datos();
		System.out.println(datos.datos.size());
	}
}
