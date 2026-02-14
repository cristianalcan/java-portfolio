package tokio.java.TokioModulo3.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import tokio.java.TokioModulo3.DAOInterfaces.TrabajadorDAO;
import tokio.java.TokioModulo3.models.Trabajador;

public class TrabajadorSQL implements TrabajadorDAO {
	private Connection connect;
	private Statement st;

	public TrabajadorSQL(String servidor, String bbdd, String usuario, String contrasenya) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://" + servidor + ":3306/" + bbdd, usuario, contrasenya);
			/*
			 * Como tal tendria que quedar asi jdbc:mysql://localhost:3306/trabajadores
			 */
			System.out.println("Conexion a MySQL listo.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertarTrabajador(Trabajador p) {
		try {
			st = connect.createStatement();
			int cant = st.executeUpdate("INSERT INTO personal VALUES ('" + p.getDNI() + "', '" + p.getNombre() + "','"
					+ p.getDireccion() + "'," + p.getEdad() + ");");
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizarTrabajador(Trabajador p) {
		try {
			st = connect.createStatement();
			int cant = st.executeUpdate("UPDATE personal SET Nombre='" + p.getNombre() + "', Direccion='"
					+ p.getDireccion() + "', Edad=" + p.getEdad() + " WHERE DNI='" + p.getDNI() + "';");
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminarTrabajador(String id) {

	}

	@Override
	public Trabajador obtenerTrabajador(String id) {
		return null;
	}

}
