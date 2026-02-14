package unidad3;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Escritor extends Thread {
	private Fichero f;

	public Escritor(Fichero f) {
		super();
		this.f = f;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (f) {// Este metodo es para que cuando yo escriba tu no puedas leer.Se sincronizan
								// los hilos
				if (f.getLectores() > 0) {
					try {
						f.wait();
						continue;//Se pone esto para que si se cumple, vuelva a ver si se cumple o no la condicion
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				f.Escribir(cadenaAleatoria(new Random().nextInt(50) + 10));
			}
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static String cadenaAleatoria(int longitud) {
		// El banco de caracteres
		String banco = "abcdefghijklmnopqrstuvwxyz         ";
		// La cadena en donde iremos agregando un carácter aleatorio
		String cadena = "";
		for (int x = 0; x < longitud; x++) {
			int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
			char caracterAleatorio = banco.charAt(indiceAleatorio);
			cadena += caracterAleatorio;
		}
		return cadena;
	}

	public static int numeroAleatorioEnRango(int minimo, int maximo) {
		// nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos
		// 1
		return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	}
}
