package unidad5;

public interface Cola<T> {
	public void enColar(T valor);

	public T desEnColar();

	public T Frente();

	public boolean Vacia();

}
