package controllers;

import java.io.File;

import javafx.application.Platform;
import javafx.fxml.FXML;

import javafx.scene.layout.AnchorPane;
import models.Pokemon;
import models.TipoPokemon;
import resources.PokemonView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class MainSceneController {
	@FXML
	private Button buttonAtacar;

	@FXML
	private Button buttonDefender;

	@FXML
	private Button buttonRetirar;

	@FXML
	private AnchorPane escena;

	@FXML
	private Label pok1Ataque;

	@FXML
	private Label pok1Nivel;

	@FXML
	private Label pok1Nombre;

	@FXML
	private Label pok1Vida;

	@FXML
	private Label pok2Ataque;

	@FXML
	private Label pok2Nivel;

	@FXML
	private Label pok2Nombre;

	@FXML
	private Label pok2Vida;

	@FXML
	private ImageView pokemon1;

	@FXML
	private ImageView pokemon2;

	@FXML
	private Label pantalla;

	private PokemonView pok1;
	private PokemonView pok2;
	private int turno;

	public MainSceneController() {
	}

	public void initialize() {
		Pokemon p1 = new Pokemon(10, "Bulbasaur", 150, 55, null, TipoPokemon.PLANTA);
		Pokemon p2 = new Pokemon(10, "Charmander", 180, 45, null, TipoPokemon.FUEGO);
		// Aqui lo que estamos haciendo es asignarle las siguientes imagenes a cada
		// Pokemon
		pokemon1.setImage(new Image(new File("src/resources/bulbasaur.png").toURI().toString()));
		pokemon2.setImage(new Image(new File("src/resources/charmander.png").toURI().toString()));
		// Esto lo inicializamos en este metodo ya que si lo hacemos en el constructor
		// lo que pasa es que supuestamente cuandoo se ejecuta el constructor pues
		// nuestras imageview que son los pokemon1 y 2 pues no estan inicializados
		pok1 = new PokemonView(p1, "izquierda", pokemon1);
		pok2 = new PokemonView(p2, "derecha", pokemon2);
		// Con esto hacemos que nuestro programa inicie con el label del centro con el
		// siguiente texto
		pantalla.setText("Inicio de combate");
		// Esto es para asignarle el turno 1 a este pokemon que se esta mostrando
		turno = 1;
		// Esto lo hacemos para que se enseñe toda la informacion una vez inicializado
		// el programa
		showInfo();
	}

	public void showInfo() {
		pok1Nombre.setText("Nombre: " + pok1.getPokemon().getNombre());
		pok2Nombre.setText("Nombre: " + pok2.getPokemon().getNombre());
		pok1Nivel.setText("Nivel: " + pok1.getPokemon().getNivel());
		pok2Nivel.setText("Nivel: " + pok2.getPokemon().getNivel());
		pok1Vida.setText("Vida: " + pok1.getPokemon().getVida());
		pok2Vida.setText("Vida: " + pok2.getPokemon().getVida());
		pok1Ataque.setText("Ataque: " + pok1.getPokemon().getAtaque());
		pok2Ataque.setText("Ataque: " + pok2.getPokemon().getAtaque());
	}

	@FXML
	void atacar(ActionEvent event) {
		if (turno == 1) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					accionAtacar(pok1);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					accionRecibir(pok2);
				}
			}).start();
			// Aqui lo que estamos diciendo es que en caso de que sea el turno del pokemon 1
			// pues el pokemon2 va a sufrir el daño, y como vemos pues el daño que sufirara
			// sera el ataque del pokemon 1(es decir a la vida del pokemon 2 se le va a
			// reducir el daño del pokemon1)
			pok2.getPokemon().recibirDanyo(pok1.getPokemon().getAtaque());
			pantalla.setText(pantalla.getText() + "\n " + pok1.getPokemon().getNombre() + " ataca");
			turno = 2;
		} else {
			new Thread(new Runnable() {
				@Override
				public void run() {
					accionAtacar(pok2);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					accionRecibir(pok1);
				}
			}).start();
			pok1.getPokemon().recibirDanyo(pok2.getPokemon().getAtaque());
			pantalla.setText(pantalla.getText() + "\n " + pok2.getPokemon().getNombre() + " ataca");
			turno = 1;
		}
		gameOver();
		showInfo();
	}

	private void gameOver() {
		if (pok1.getPokemon().getVida() == 0) {
			pok1.getImagen().setVisible(false);
			pantalla.setText(pantalla.getText() + "\n " + pok2.getPokemon().getNombre() + " gana la partida");
		}
		if (pok2.getPokemon().getVida() == 0) {
			pok2.getImagen().setVisible(false);
			pantalla.setText(pantalla.getText() + "\n " + pok1.getPokemon().getNombre() + " gana la partida");
		}
	}

	@FXML
	void defender(ActionEvent event) {
		if (turno == 1) {
			pok1.getPokemon().aumentarVida(50);
			// Esto es para que una vez se haya defendido el pokemon 1 pues ahora cuando se
			// presione defender otra vez pues sea el pokemon 2 el que se defienda
			pantalla.setText(pantalla.getText() + "\n " + pok1.getPokemon().getNombre() + " aumento su vida en 50");
			turno = 2;
		} else {
			pok2.getPokemon().aumentarVida(50);
			pantalla.setText(pantalla.getText() + "\n " + pok2.getPokemon().getNombre() + " aumento su vida en 50");
			turno = 1;
		}
		// Esto para que se actualicen los datos
		showInfo();
	}

	@FXML
	void retirar(ActionEvent event) {
		/**
		 * Aqui lo que estamos diciendo es que si es el pokemon 1 pues se oculta y si no
		 * tambien
		 */
		if (turno == 1) {
			pok1.getImagen().setVisible(false);
			pantalla.setText(pantalla.getText() + "\n " + pok1.getPokemon().getNombre() + " se retira");
			pantalla.setText(pantalla.getText() + "\n " + pok2.getPokemon().getNombre() + " gana la partida");
		} else {
			pok2.getImagen().setVisible(false);
			pantalla.setText(pantalla.getText() + "\n " + pok2.getPokemon().getNombre() + " se retira");
			pantalla.setText(pantalla.getText() + "\n " + pok1.getPokemon().getNombre() + " gana la partida");
		}
	}

	@FXML
	public void CapturaTeclado(KeyEvent event) {
		System.out.println(event.getCode());
		// Aqui lo que decimos es que si nuestro evento ha sido provocado por pulsar el
		// teclado "a" pues entonces lo que pasara es que nuestro pokemon1(izquierda)
		// atacará
		if (event.getCode() == KeyCode.A) {
			// Aqui estamos creando nuevos hilos para asi poder usar el sleep correctamente
			// sin que haya interferencias. MUY IMPORTANTE ESTO!!
			new Thread(new Runnable() {
				@Override
				public void run() {
					accionAtacar(pok1);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					accionRecibir(pok2);
				}
			}).start();
		}
		if (event.getCode() == KeyCode.D) {
			// Aqui lo que hacemos es que basicamente cuando uno ataca pues el otro recibe.
			new Thread(new Runnable() {
				@Override
				public void run() {
					accionAtacar(pok2);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					accionRecibir(pok1);
				}
			}).start();
		}
	}

	public void accionAtacar(PokemonView pokemon) {
		// Con este metodo lo que hariamos seria basicamente mover a nuestro pokemon1 un
		// pixel cada 10 milisegundos 50 veces por tanto se moveria 50 pixeles. Ahora
		// bien, esto no podemos ejecutarlo asi sin mas porque una vez ejecutandose la
		// app se bloquearia, por tanto lo que tendriamos que hacer seria ejecutar este
		// metodo en un hilo, como ya hemos visto incluso solo podriamos usar
		// Platform.runLater para que asi pues se ejecute y no se detenga nuestra app
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							// Aqui decimos que si nuestro Pokemon que hemos pasado por parametro es el de
							// la izquierda pues se mueve para la derecha
							if (pokemon.getPosicion().equals("izquierda")) {
								pokemon.getImagen().setX(pokemon.getImagen().getX() + 1);
							} else {
								pokemon.getImagen().setX(pokemon.getImagen().getX() - 1);
							}
						}
					});
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				for (int i = 0; i < 50; i++) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							if (pokemon.getPosicion().equals("izquierda")) {
								pokemon.getImagen().setX(pokemon.getImagen().getX() - 1);
							} else {
								pokemon.getImagen().setX(pokemon.getImagen().getX() + 1);
							}
						}
					});
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public void accionRecibir(PokemonView pokemon) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				// Vamos a hacer que se repita 5 veces cada recepcion
				for (int j = 0; j < 5; j++) {
					for (int i = 0; i < 50; i++) {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								if (pokemon.getPosicion().equals("izquierda")) {
									pokemon.getImagen().setX(pokemon.getImagen().getX() + 1);
								} else {
									pokemon.getImagen().setX(pokemon.getImagen().getX() - 1);
								}
							}
						});
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					for (int i = 0; i < 50; i++) {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								if (pokemon.getPosicion().equals("izquierda")) {
									pokemon.getImagen().setX(pokemon.getImagen().getX() - 1);
								} else {
									pokemon.getImagen().setX(pokemon.getImagen().getX() + 1);
								}
							}
						});
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
	}

}
