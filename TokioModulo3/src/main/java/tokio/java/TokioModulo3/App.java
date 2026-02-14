package tokio.java.TokioModulo3;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tokio.java.TokioModulo3.DAOImpl.TrabajadorFichBin;
import tokio.java.TokioModulo3.DAOImpl.TrabajadorSQL;
import tokio.java.TokioModulo3.DAOInterfaces.TrabajadorDAO;
import tokio.java.TokioModulo3.models.Trabajador;
import tokio.java.TokioModulo3.utils.Trabajador_utils;
import hibernate.mapping.*;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		/*
		 * Trabajador t = new Trabajador("pedro", 24, 1800); System.out.println(t);
		 * System.out.println(t.getNombre());
		 * System.out.println(Trabajador_utils.importarDatos().size());
		 */
		TrabajadorDAO acceso1 = new TrabajadorSQL("localhost", "trabajadores", "root", "");
		TrabajadorDAO acceso2 = new TrabajadorFichBin();

		Trabajador_utils.accesoTrabajadores(acceso1);
		/**
		 * Esto inicia la sesion para que podamos trabajar con nuestra base de datos,
		 * por eso, enlazamos o creamos la sesion con el fichero de configuracion que
		 * habiamos creado que es el hibernate.cfg.xml
		 */
		SessionFactory session = new Configuration()
				.configure(new File("src/main/java/hibernate/mapping/hibernate.cfg.xml")).buildSessionFactory();
		/**
		 * Esta es la conexion que generamos para asi poder operar en nuestra tabla de
		 * la base de datos
		 */
		Session conexion = session.getCurrentSession();
		/**
		 * Con este metodo lo que hacemos es especificar que los datos que creemos o con
		 * los que trabajemos se van a modificar tambien en nuestra base de datos
		 */
		conexion.beginTransaction();
		Personal p = new Personal("53762468R", "Oscar", "alguna direccion", 29);
		/**
		 * Con esto guardamos a nuestro nuevo personal
		 */
		conexion.save(p);
		/**
		 * Para poder obtener datos de nuestra base de datos haremos lo siguiente:
		 */
		List<Personal> lista = (List<Personal>) conexion.createQuery("from trabajadores").list();
		/**
		 * De esta manera podemos actualizar datos en nuestra base de datos
		 */
		lista.get(2).setNombre("Juan Ignacio");
		/**
		 * Con este metodo enviamos a nuestra base de datos el nuevo personal que
		 * habiamos guardado y todas las consultas que hemos realizado, IMPORTANTE!,
		 * esto solo se hace una vez en cada instancia.
		 */
		conexion.getTransaction().commit();
	}
}
