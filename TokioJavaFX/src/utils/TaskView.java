package utils;

import javafx.concurrent.Task;

/**
 * La clase Task nos servira sobre todo para programas complejos en los que
 * habra mas de un hilo. Lo que hace esta clase es que los hilos que tengamos
 * "compitan" por ejecutarse ya que son asincronas pero al mismo tiempo se
 * podria decir que estan sincronizados los hilos ya que digamos esta clase se
 * encarga de ver en que momento se puede ejecutar cada hilo e incluso si el
 * sistema operativo lo permite pues se puede llegar a ejecutar 2 tareas al
 * mismo tiempo
 * 
 * @author crist
 *
 */
public class TaskView extends Task {

	private int tiempo;

	public TaskView(int tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	protected Object call() throws Exception {
		for (int i = 0; i <= tiempo; i++) {
			// Este metodo se utiliza para actualizar el mensaje de estado de la tarea en la
			// interfaz de usuario mientras se está ejecutando en segundo plano.
			updateMessage(i * 100 / tiempo + "%");
			updateProgress(i, tiempo);// La i es el inicio de nuestro progressbar y el tiempo es el final a donde
										// puede llegar nuestro progressbar
			Thread.sleep(10);
		}
		return null;
	}

}
