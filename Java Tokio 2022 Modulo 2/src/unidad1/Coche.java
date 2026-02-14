package unidad1;

public class Coche {
	private String matricula;
	private String marca;
	private String modelo;
	private double potencia;
	private double velocidadMaxima;
	private chasis c;
	private rueda r;

	public Coche(String matricula, String marca, String modelo, double potencia, double velocidadMaxima) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.potencia = potencia;
		this.velocidadMaxima = velocidadMaxima;
		c = new chasis("aluminio", 4890);
		r = new rueda(22.5, "Neumatico Invierno", "Aurgi", "Continental");

	}

	public Coche(double velocidadMaxima, String marca, String modelo, double potencia, String matricula) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.potencia = potencia;
		this.velocidadMaxima = velocidadMaxima;
		c = new chasis("magnesio", 5000);
		r = new rueda(24, "Neumatico lluvia", "Aurgi", "Michelin Primacy 4");
	}

	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public double getPotencia() {
		return potencia;
	}

	public double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", potencia=" + potencia
				+ ", velocidadMaxima=" + velocidadMaxima + ", c=" + c + ", r=" + r + "]";
	}

	public class chasis {
		private String material;
		private double peso;

		public chasis(String material, double peso) {
			super();
			this.material = material;
			this.peso = peso;
		}

		public String getMaterial() {
			return material;
		}

		public double getPeso() {
			return peso;
		}

		@Override
		public String toString() {
			return "chasis [material=" + material + ", peso=" + peso + "]";
		}

	}

	public class rueda {
		private double medida;
		private String tipo;
		private String marca;
		private String modelo;

		public rueda(double medida, String tipo, String marca, String modelo) {
			super();
			this.medida = medida;
			this.tipo = tipo;
			this.marca = marca;
			this.modelo = modelo;
		}

		public double getMedida() {
			return medida;
		}

		public String getTipo() {
			return tipo;
		}

		public String getMarca() {
			return marca;
		}

		public String getModelo() {
			return modelo;
		}

		@Override
		public String toString() {
			return "rueda [medida=" + medida + ", tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo + "]";
		}

	}
}
