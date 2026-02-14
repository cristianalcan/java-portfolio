package models;

import java.io.Serializable;

public class Pokemon implements Serializable {
	private int nivel;
	private String nombre;
	private int vida;
	private int ataque;
	private Poder[] poderes;
	private TipoPokemon tipos;

	public Pokemon(int nivel, String nombre, int vida, int ataque, Poder[] poderes, TipoPokemon tipos) {
		super();
		this.nivel = nivel;
		this.nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
		this.poderes = poderes;
		this.tipos = tipos;
	}

	public int getNivel() {
		return nivel;
	}

	public String getNombre() {
		return nombre;
	}

	public int getVida() {
		return vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public Poder[] getPoderes() {
		return poderes;
	}

	public TipoPokemon getTipos() {
		return tipos;
	}

	/**
	 * Este metodo lo creamos para poder aumentar vida de una forma mas facil
	 * 
	 * @param vida
	 */
	public void aumentarVida(int vida) {
		this.vida += vida;
	}

	/**
	 * Este metodo lo creamos para poder disminuir la vida de un pokemon cuando el
	 * otro ataca
	 * 
	 * @param danyo
	 */
	public void recibirDanyo(int danyo) {
		this.vida -= danyo;
		if (vida < 0) {
			vida = 0;
		}
	}

}
