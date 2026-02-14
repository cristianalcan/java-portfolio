package resources;

import javafx.scene.image.ImageView;
import models.Pokemon;

/**
 * Esta clase la creamos para poder guardar o asignarle un pokemon especifico a
 * un objeto de esta clase, y por tanto poder ejecutar metodos con un
 * determinado pokemon
 * 
 * @author crist
 *
 */
public class PokemonView extends ImageView {
	// En esta clase obtendremos un pokemon, y segun que posicion pues ejecutara una
	// sentencia u otra
	private Pokemon pokemon;
	private String posicion;
	private ImageView imagen;

	public PokemonView(Pokemon pokemon, String posicion, ImageView imagen) {
		super();
		this.pokemon = pokemon;
		this.posicion = posicion;
		this.imagen = imagen;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public String getPosicion() {
		return posicion;
	}

	public ImageView getImagen() {
		return imagen;
	}

}
