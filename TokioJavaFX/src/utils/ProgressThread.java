package utils;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

/**
 * En esta clase crearemos el primer hilo y basicamente en nuestro metodo
 * principal lo que hacemos es que nuestra barra de progreso se actualice
 * 
 * @author crist
 *
 */
public class ProgressThread extends Thread {
	private ProgressBar progress;
	private Label lProgress;
	// Creamos esta variable para poder seguir nuestro recuento de el valor i de
	// nuestro bucle for, porque recordemos que es inaccesible desde nuestra
	// interfaz Runnable ya que esta interfaz es totalmente aparte
	private int index;
	private int tiempo;

	public ProgressThread(ProgressBar progress, Label lProgress, int tiempo) {
		super();
		this.progress = progress;
		this.lProgress = lProgress;
		this.tiempo = tiempo;
	}

	@Override
	public void run() {
		for (int i = 0; i <= tiempo; i++) {
			index = i;
			// Este metodo lo que hace es que basicamente dice que cuando se pueda
			// actualizar el componente grafico pues que lo haga, ya que recordemos que no
			// pueden actualizarse al mismo tiempo nuestro label que nuestra barra de
			// progreso, por tanto en cuanto haya un nanosegundo o por ahi pues que se
			// actualice nuestro label
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					lProgress.setText(index * 100 / tiempo + "%");
					progress.setProgress(index * 100.0 / tiempo / 100);
				}
			});
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
