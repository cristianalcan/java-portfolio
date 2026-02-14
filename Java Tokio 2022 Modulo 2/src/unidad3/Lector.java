package unidad3;

public class Lector extends Thread {
	private Fichero f;

	public Lector(Fichero f) {
		super();
		this.f = f;
	}

	@Override
	public void run() {
		synchronized (f) {
			f.aumentarLector();
			if (f.getLectores() >= 5) {// Lo metemos en sincronizado para que varios lectores no traten de esperar al
										// mismo tiempo
				try {
					f.wait();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		f.Lectura();// Tiene que estar fuera del metodo sincronizado ya que ahora habra mas de un
					// lector
		synchronized (f) {
			f.disminuirLector();
			f.notify();// Usamos notify solo para que solo se notifique a un lector, que se hace de
						// forma aleatoria, no suamos notifyall debido a que si notificamos a varios
						// lectores, podria haber un colapso en cuanto a lectores.
		}
	}
}
