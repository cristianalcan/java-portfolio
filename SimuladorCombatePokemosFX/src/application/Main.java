package application;

import controllers.MainSceneController;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/MainScene.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();

			// Aqui lo que hacemos es añadirle a nuestro escenario pues un evento, en el
			// lado izquierdo de nuestro parentesis ponemos que recogeremos todos los
			// eventos(cuando presionamos cualquier tecla o incluso si el mouse se mueve) y
			// en el lado derecho es donde implementamos la funcion para ejecutar una
			// sentencia una vez se haya producido un evento
//			primaryStage.getScene().addEventFilter(Event.ANY, new EventHandler<Event>() {
//				@Override
//				public void handle(Event e) {
					// Aqui lo que estamos haciendo es que a nuestro objeto MainSceneController pues
					// le asignamos el controler de nuestro objeto XML, o sea de nuestro
					// MainSceneFMXL controller
//					MainSceneController controller = loader.getController();
//					System.out.println(e.getEventType());
					// Esto significa que cuando el evento sea un KEY RELEASED(que se ha dejado de
					// pulsar un boton), pues se producira un evento
/*					if (e.getEventType().toString().equals("KEY_RELEASED")) {
						KeyEvent ke = (KeyEvent) e;
						controller.CapturaTeclado(ke);
					}
				}
			});*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
