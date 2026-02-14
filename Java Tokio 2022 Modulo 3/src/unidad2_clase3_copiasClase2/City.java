package unidad2_clase3_copiasClase2;

public class City {
	private String name;
	private int size;
	private int population;
	private String area;

	public City(String name, String area) {
		super();
		this.name = name;
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	/// Cuando tengamos un objeto, y por ejemplo queramos añadirlo como una opcion
	/// en un comboBox, las opciones que apareceran son los toString, es decir, en
	/// este caso por ejemplo apareceria una opcion Madrid(Madrid)
	@Override
	public String toString() {
		return name + "(" + area + ")";
	}

}
