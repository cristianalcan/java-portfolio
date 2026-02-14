package unidad4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Vehiculo {
	private String marca;
	private String modelo;
	private LocalDate fechaPro;
	private LocalDateTime fechaCom;

	public Vehiculo(String marca, String modelo, String fechaPro, String fechaCom) throws Exception {
		// Ponemos que puede lanzar una excepcion porque hay la posibilidad de que haya
		// una por la conversion
		super();
		this.marca = marca;
		this.modelo = modelo;
		// Aqui lo que vamos a hacer es que como nosotros vamos a recibir las fechas de
		// produccion como un string, entonces aqui lo convertimos a localdate siguiendo
		// el patron de datetimeformatter
		this.fechaPro = LocalDate.parse(fechaPro, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		if (!fechaCom.equals("")) {
			this.fechaCom = LocalDateTime.parse(fechaCom, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		}
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDate getFechaPro() {
		return fechaPro;
	}

	public void setFechaPro(LocalDate fechaPro) {
		this.fechaPro = fechaPro;
	}

	// Aqui creamos un metodo para saber cuantos años tiene de uso el coche
	public long añosUso() {
		return ChronoUnit.YEARS.between(fechaCom, LocalDate.now());
	}

	// Aqui creamos un metodo para saber cuantos años lleva producido el coche
	public long añosProducido() {
		return ChronoUnit.YEARS.between(fechaPro, LocalDate.now());
	}

	public boolean esNuevo() {
		return fechaCom == null;
	}

}
