package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/views/EscenaPrueba.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

	/*		// En esta ventana crearemos una Calculadora
			VBox root1 = new VBox();// Esto es para que tengamos una distribucion vertical en un lado de nuestra app
			TextField pantalla = new TextField("0");
			pantalla.setPrefWidth(100);// Esto es para darle un tamaño de ancho
			root1.getChildren().add(pantalla);// Asi añadimos nuestro textfield a nuestro contenedor

			HBox teclado = new HBox();
			GridPane numeros = new GridPane();
			teclado.getChildren().add(numeros);// Asi añadimos nuestro gridpane a nuestro HBOx que recordemos que es
												// como una caja que organiza sus elementos en forma horizontal

			VBox operaciones = new VBox();
			teclado.getChildren().add(operaciones);// Asi añadimos nuestro VBox que recordemos que es un contenedor que
													// organiza sus elementos de forma vertical en nuestro HBox

			// Asi le añadimos nuestros botones con los operadores a nuestro VBox
			operaciones.getChildren().add(new Button("+"));
			operaciones.getChildren().add(new Button("-"));
			operaciones.getChildren().add(new Button("*"));
			operaciones.getChildren().add(new Button("/"));

			numeros.add(new Button("7"), 0, 0);
			numeros.add(new Button("8"), 1, 0);
			numeros.add(new Button("9"), 2, 0);
			numeros.add(new Button("4"), 0, 1);
			numeros.add(new Button("5"), 1, 1);
			numeros.add(new Button("6"), 2, 1);
			numeros.add(new Button("1"), 0, 2);
			numeros.add(new Button("2"), 1, 2);
			numeros.add(new Button("3"), 2, 2);
			numeros.add(new Button("0"), 1, 3);
			root1.getChildren().add(teclado);

			Scene calculadora = new Scene(root1);// Esta es nuestra nueva escena
			primaryStage.setScene(calculadora);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
