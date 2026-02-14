package controllers;

import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.event.ActionEvent;

import javafx.scene.control.ProgressBar;
import utils.ProgressThread;
import utils.TaskView;
import javafx.scene.control.Label;

public class ConcurrenciaSceneController {
	@FXML
	private ProgressBar progress;
	@FXML
	private Label lProgress;
	@FXML
	private Label lProgress1;
	@FXML
	private Label lContador;
	@FXML
	private ProgressBar progress1;
	// Esta lista va a tener las cantidades de bytes o progreso de nuestro progress1
	List<Integer> archivos;

	public ConcurrenciaSceneController() {
		// Aqui lo que hacemos es inicializar nuestro archivo cuando se ejecute nuestro
		// constructor, ya que si lo inicializamos en el metodo initialize pues lo que
		// pasa es que como tal nuestro archivo no esta creado de forma visual pero en
		// verdad da igual simplemente lo creamos en el constructor para que asi una vez
		// se abra el programa pues se cree nuestra lista de archivos
		archivos = new ArrayList<>();
		for (int i = 0; i < new Random().nextInt(10) + 1; i++) {
			// Aqui lo que hacemos es añadirle a nuestro archivo un numero entre el 0 y el
			// 1000
			archivos.add(new Random().nextInt(1000) + 1);
		}
	}

	public void initialize() {
		lContador.setText("0");// Esto es para iniciar nuestra etiqueta con el valor en 0
		lProgress.setText("0");
		lProgress1.setText("0");
	}

	@FXML
	public void aumentarContador(ActionEvent event) {
		// Esto es para que cada vez que clickemos el boton Aumentar pues se sume uno al
		// valor de nuestra etiqueta
		lContador.setText(Integer.parseInt(lContador.getText()) + 1 + "");
	}

	@FXML
	void iniciarProgreso(ActionEvent event) {
		int sum = 0;
		for (Integer i : archivos) {
			sum += i;// Con esto lo que hacemos es basicamente sumarle a nuestra variable sum pues la
						// suma de todos los valores de nuestra lista de archivos
		}
		// Aqui lo que hacemos es crear un objeto de la clase hilo que hemos creado para
		// poder ejecutar nuestra barra de progreso en un hilo aparte. La sum es la
		// cantidad con la que va a cargar nuestra barra de progreso
		/*
		 * ProgressThread pt = new ProgressThread(progress, lProgress, sum); pt.start();
		 * // Asi es como hacemos que funcione nuestra segund progress bar en un hilo //
		 * independiente new Thread(new Runnable() {
		 * 
		 * @Override public void run() { for (Integer integer : archivos) {
		 * ProgressThread pt1 = new ProgressThread(progress1, lProgress1, integer);
		 * pt1.start(); try { pt1.join(); } catch (InterruptedException e) {
		 * e.printStackTrace(); } } } }).start(); ;
		 */

		TaskView t1 = new TaskView(sum);
		// Asi es como nosotros vinculamos a nuestra etiqueta con el metodo de nuestra
		// clase TaskView
		lProgress.textProperty().bind(t1.messageProperty());
		progress.progressProperty().bind(t1.progressProperty());
		// Asi ejecutamos nuestro taskview
		new Thread(t1).start();

		// Esto lo hacemos en un hilo diferente para que no haya problemas por eso
		// dentro de este runnable tambien creamos un hilo para ejecutarlo dentro de
		// este hilo
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (Integer integer : archivos) {
					TaskView t2 = new TaskView(integer);
					lProgress1.textProperty().bind(t2.messageProperty());
					progress1.progressProperty().bind(t2.progressProperty());
					Thread t = new Thread(t2);// Aqui guardamos nuestro t2
					t.start();// Le damos a start
					try {
						t.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
