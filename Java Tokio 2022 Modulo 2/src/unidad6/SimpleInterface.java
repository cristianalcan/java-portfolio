package unidad6;

@FunctionalInterface // Esto declara que es una interfaz funcional

public interface SimpleInterface {// Esto se considera una interfaz funcional ya que solo tiene un unico metodo
									// abstracto
	public void FuncionPrueba(String text);

	default void Mostrar() {// Si que se puede tener mas de un metodo que no sea abstracto, recordemos que
							// los default no hace falta que se sobrescriban en la clase que se esta
							// implementando, ya que ya viene implementada desde su interfaz
		System.out.println("Esto es por defecto");
	}

}
