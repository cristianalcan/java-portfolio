package unidad6;

import java.util.ArrayList;
import java.util.List;

public class Clase2 {

	public static void main(String[] args) {
		/**
		 * @param localhost    es la direccion de la base de datos, si trabajamos con
		 *                     una base de datos local ponemos localhost o 127.0.0.1 y
		 *                     si es una base de datos externa ponemos la direccion de
		 *                     la base de datos
		 * @param trabajadores es el nombre de la base de datos que hemos creado en
		 *                     MySQL
		 * @param root         es el nombre del usuario normalmente viene asi por
		 *                     predeterminado pero lo podemos modificar
		 * @param ""           es la contraseña que no hay contraseña por predeterminado
		 *                     pero tambien lo podemos modificar
		 */
		ConexionBD conMySQL = new ConexionBD("localhost", "trabajadores", "root", "");
		/**
		 * @param bbdd.bd es el nombre del fichero, aqui la ruta, puede ser el nombre
		 *                del fichero o puede ser el nombre de una carpeta punto y el
		 *                nombre del fichero, y normalmente siempre es un punto bd
		 * 
		 *                Este fichero en realidad aun no ha sido creado pero cuando
		 *                ejecutemos este programa se creara el fichero en nuestra
		 *                carpeta del proyecto Java Tokio Modulo 3
		 */
		ConexionBD conSQLite = new ConexionBD("bbdd.bd");
	/*	Personal p1 = new Personal("12345678N", "Juan Antonio", "Calle de alguna parte", 24);
		Personal p2 = new Personal("12675678N", "Pedro", "Calle de alguna parte", 24);
		Personal p3 = new Personal("12342378N", "Ana", "Calle de alguna parte", 24);
		Personal p4 = new Personal("12785678N", "Ricardo", "Calle de alguna parte", 24);
		conMySQL.insertarTrabajador(p1);
		conMySQL.insertarTrabajador(p2);
		conMySQL.insertarTrabajador(p3);
		conMySQL.insertarTrabajador(p4);*/
		/**
		 * Si es true, se ha insertado correctamente, si no, es que se han indtroducido
		 * mal los datos. Recordemos algo MUY IMPORTANTE!!!. Es que si ejecutamos estas
		 * sentencias mas de una vez, se estaria creando una persona con el mismo DNI, y
		 * como tenemos el DNI como Primary Key, no se puede repetir, es unico, y
		 * generaria un error por consola. Nosotros lo que haremos ahora es eliminar el
		 * printstacktrace del try catch para que no se muestren los errores por
		 * consola, pero recordemos que si lo ejecutamos y muestra Datos incorrectos por
		 * consola, a lo mejor no es por error de codigo, simplemente porque ya se habia
		 * ejecutado anteriormente y se estaria repitiendo el DNI
		 */
	/*	if (conMySQL.insertarTrabajador(p1)) {
			System.out.println("Personal insertado.");
		} else {
			System.out.println("Error en los datos");
		}*/

		/**
		 * Aqui vamos a actualizar nuestro usuario. Antes era Juan, y ahora sera Juan
		 * Antonio
		 */
		/*
		 * if (conMySQL.actualizarTrabajador(p1)) {
		 * System.out.println("Personal actualizado."); } else {
		 * System.out.println("Error en los datos"); }
		 */
		/**
		 * Aqui vamos a eliminar a el trabajador p1
		 */
		/*
		 * if (conMySQL.eliminarTrabajador(p1)) {
		 * System.out.println("Personal eliminado."); } else {
		 * System.out.println("Error en los datos"); }
		 */

		List<Personal> personas = conMySQL.obtenerPersonal();
		for (Personal personal : personas) {
			System.out.println(personal);
		}
		System.out.println("Filtrado");
		List<String> filtros = new ArrayList<>();
		/**
		 * Con este filtro se refiere a las personas con direccion en Barcelona
		 */
	//	filtros.add(ConexionBD.filtro(3, "Barcelona"));
		/**
		 * Con este filtro se refiere a personas mayores de 17
		 */
		filtros.add(ConexionBD.filtro(6, "17"));
		List<Personal> personasf = conMySQL.obtenerPersonalFiltro(filtros);
		for (Personal personal : personasf) {
			System.out.println(personal);
		}
	}

}
