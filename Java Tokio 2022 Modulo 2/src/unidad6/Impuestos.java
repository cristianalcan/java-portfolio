package unidad6;

@FunctionalInterface
public interface Impuestos {

	static int irpf = 15; // Recordemos que los atributos de una interfaz siempre son constantes

	public double calcular(Trabajador t);// Con este metodo abstracto calcularemos los impuestos de los trabajaores
}
