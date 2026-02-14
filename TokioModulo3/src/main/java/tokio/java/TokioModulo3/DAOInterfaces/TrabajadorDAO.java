package tokio.java.TokioModulo3.DAOInterfaces;

import tokio.java.TokioModulo3.models.Trabajador;

public interface TrabajadorDAO {
	/**
	 * Estas funciones serán "genericas", es decir, que se pueden usar para
	 * distintos entornos donde se encuentre almacenados los datos, por ejemplo,
	 * bases de datos, ficheros, API's etc...
	 */
	public void insertarTrabajador(Trabajador t);

	public void actualizarTrabajador(Trabajador t);

	public void eliminarTrabajador(String id);

	public Trabajador obtenerTrabajador(String id);
}
