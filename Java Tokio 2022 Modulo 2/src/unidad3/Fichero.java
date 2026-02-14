package unidad3;

import java.util.ArrayList;
import java.util.List;

public class Fichero {
	private List<String> lineas;
	private int lectores;

	public int getLectores() {
		return lectores;
	}

	public Fichero() {
		super();
		lineas = new ArrayList<>();
		lectores = 0;
	}
	// Este fichero va a tener 2 procesos

	public void Escribir(String texto) {
		lineas.add(texto);
		System.out.println("Se ha escrito " + texto);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void Lectura() {
		for (int i = 0; i < lineas.size(); i++) {
			System.out.println(i + "- " + lineas.get(i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void aumentarLector() {
		lectores++;
	}

	public void disminuirLector() {
		lectores--;
	}

}
