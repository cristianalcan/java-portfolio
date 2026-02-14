package models;

import java.io.Serializable;

public class Poder implements Serializable {
	private String nombre;
	private TipoPokemon tipo;
	private int damage;

	public Poder(String nombre, TipoPokemon tipo, int damage) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.damage = damage;
	}

	public String getNombre() {
		return nombre;
	}

	public TipoPokemon getTipo() {
		return tipo;
	}

	public int getDamage() {
		return damage;
	}

}
