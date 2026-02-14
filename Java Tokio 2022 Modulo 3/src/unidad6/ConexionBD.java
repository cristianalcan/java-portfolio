package unidad6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConexionBD {
	/**
	 * Lo primero que vamos a hacer cuando trabajemos con bases de datos, será
	 * establecer la conexion, que será privada
	 */
	private Connection connect;
	/**
	 * Este atributo nos servira para SQLite, ya que esta interfaz nos permite
	 * ejecutar sentencias SQL estaticas y devolver los resultados que produce
	 */
	private Statement st;

	/**
	 * En esta clase crearemos dos constructores, en este caso se trata del
	 * constructor que recibira al MySQL.
	 * 
	 * @param servidor    significa al servidor de la Base de datos, puede ser un ip
	 *                    o un url, algo que identifique la base de datos
	 * @param bbdd        significa el nombre de la base de datos
	 * @param usuario     será el usuario
	 * @param contrasenya sera la contraseña
	 * @throws SQLException
	 */
	public ConexionBD(String servidor, String bbdd, String usuario, String contrasenya) {
		try {
			/**
			 * Aqui lo que estamos haciendo es que se asocien todas las consultas que
			 * hagamos a la base de datos, mediante el paquete com.mysql.cj.jdbc.Driver Este
			 * paquete lo sacamos de Referenced Libraries el ultimo paquete, y Driver es la
			 * clase que nosotros usaremos
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");
			/**
			 * Aqui lo que haremos sera crear la sentencia del servidor, es decir, que
			 * gestor de base de datos se trata, y tambien vamos a establecer la conexion
			 * entre la base de datos y el servidor. Lo primero que pondremos sera el
			 * servidor, luego el nombre, luego el puerto del servidor MysQL que es 3306 y
			 * luego el usuario y contraseña
			 */
			connect = DriverManager.getConnection("jdbc:mysql://" + servidor + ":3306/" + bbdd, usuario, contrasenya);
			/*
			 * Como tal tendria que quedar asi jdbc:mysql://localhost:3306/trabajadores
			 */
			System.out.println("Conexion a MySQL listo.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ahora crearemos el constructor para SQLite
	 * 
	 * @param ruta es la ruta donde se va a guardar la base de datos
	 */
	public ConexionBD(String ruta) {
		try {
			/**
			 * Aqui lo que estamos haciendo es que se asocien todas las consultas que
			 * hagamos a la base de datos, mediante el paquete org.sqlite.JDBC Este paquete
			 * lo sacamos de Referenced Libraries el ultimo paquete, y JDBC es la clase que
			 * nosotros usaremos
			 */
			Class.forName("org.sqlite.JDBC");
			/**
			 * El parametro que se pone en getConnection es de donde viene el fichero
			 */
			connect = DriverManager.getConnection("jdbc:sqlite:" + ruta);
			/**
			 * Ejecutamos el initBD para que se ejecuten las consultas cuando creemos una
			 * conexion con SQLite
			 */
			initBD();
			System.out.println("Conexion a SQLite listo.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * La diferencia entre MySQL y SQLite es que, en SQLite no podemos ir a XAMPP y
	 * hacer una representacion visual, por tanto lo que haremos sera crear un
	 * metodo para realizar las consultas de nuestra base de datos
	 */
	public void initBD() {
		try {
			/**
			 * Lo que haremos sera en cada metodo crear un Statement, debido a que esta
			 * interfaz solo permite realizar una operacion concurrente, es decir si usan al
			 * mismo tiempo con metodos distintos un mismo statement, hay muchas
			 * probabilidades de que salten errores
			 */
			st = connect.createStatement();
			/**
			 * Este metodo es para realizar una consulta generica y nos devuelve true si se
			 * ejecuto correctamente, o false si no se ejecuto correctamente. Creamos la
			 * tabla IF NOT EXISTS, lo que quiere decir que se creara si la tabla no existe
			 */
			st.execute("CREATE TABLE IF NOT EXISTS trabajadores(" + "DNI varchar(9) PRIMARY KEY,"
					+ "Nombre varchar(50)," + "Direccion text," + "Edad int" + ");");
			/**
			 * Este metodo devuelve resultados, por tanto solo la utilizaremos para
			 * consultas SELECT, que son las que devuelven datos: st.executeQuery(null);
			 */

			/**
			 * Este metodo nos va a devolver el numero de actualizaciones en la base de
			 * datos, lo usaremos para los INSERT, UPDATE Y DELETE: st.executeUpdate("");
			 */

			/**
			 * Al final cerramos el Statement
			 */
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Este metodo es para cerrar la conexion
	 */
	public void closeConecction() {
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creamos este metodo para insertar trabajadores a nuestra tabla de MySQL
	 * 
	 * @param p es el trabajador que se inserta
	 * @return true si se pudo insertar, y false si no se pudo
	 */
	public boolean insertarTrabajador(Personal p) {
		try {
			/**
			 * Creamos una nueva conexion
			 */
			st = connect.createStatement();
			/**
			 * Este metodo nos devolvera un int, que es el numero de actualizaciones que se
			 * han producido con nuestra sentencia. Bien aqui lo que hacemos es Insertar
			 * valores en nuestra tabla trabajadores, lo que vamos a hacer SIEMPRE cuando
			 * vayamos a insertar valores a una tabla sera: ('"++"') Esto para que podamos
			 * ingresar los valores. Con la comilla simple es que aun pertenece al texto,
			 * con las comillas dobles salimos del texto(Pero se hace esto para que lo que
			 * vamos a concatenar sea un String, en este caso el DNI), y con el + es que
			 * concatenamos valores. Nos damos cuenta que cuando ponemos getEdad solo hay
			 * comillas dobles, ya que si pusiesemos comillas simples nos estariamos
			 * refiriendo a un texto, ponemos las comillas dobles para poder salir del
			 * String y poder concatenar la Edad. SIEMPRE PONDREMOS EL PUNTO Y COMA AL FINAL
			 */
			int cant = st.executeUpdate("INSERT INTO personal VALUES ('" + p.getDNI() + "', '" + p.getNombre() + "','"
					+ p.getDireccion() + "'," + p.getEdad() + ");");
			/**
			 * Cerramos la conexion
			 */
			st.close();
			/**
			 * Aqui lo que estamos diciendo es que si la cantidad que nos devuelve nuestra
			 * sentencia es mayor que 0, es porque se ha producido al menos una
			 * actualizacion y por tanto se ha ejecutado correctamente nuestra sentencia
			 */
			if (cant > 0) {
				return true;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return false;
	}

	/**
	 * Creamos este metodo para actualizar los datos de un trabajador
	 * 
	 * @param p Es el trabajador que vamos a actualizar
	 * @return true si se puedo actualizar, y false si no se pudo
	 */
	public boolean actualizarTrabajador(Personal p) {
		try {
			st = connect.createStatement();
			/**
			 * Este metodo nos devolvera un int, que es el numero de actualizaciones que se
			 * han producido con nuestra sentencia. Aqui lo que vamos a hacer sera
			 * actualizar datos de nuestro trabajador. ALGO IMPORTANTE, la llave PRIMARIA NO
			 * LA VAMOS A ACTUALIZAR, debido a que podria provocar errores en nuestra base
			 * de datos. Nos damos cuenta de que es muy similar a lo de arriba, el SET es
			 * para otorgar los nuevos valores a las columnas, y recordemos que tiene que
			 * estar escrito esxactamante igual a nuestra base de datos. Luego nos damos
			 * cuenta de que sigue el mismo modelo para los String '"++"' y para los Int
			 * solo "++" y recordemos el punto y coma al final. Recordemos algo MUY
			 * IMPORTANTE, y es que vemos que el WHERE es una condicion, que significa que
			 * vamos a actualizar estos datos nuevos del SET SOLO a el personal que tenga el
			 * DNI igual a p.getDNI, por eso es tan importante no modificar la llave
			 * primaria, ya que es un dato inamobible y unico con el que podemos localizar
			 * una persona
			 */
			int cant = st.executeUpdate("UPDATE personal SET Nombre='" + p.getNombre() + "', Direccion='"
					+ p.getDireccion() + "', Edad=" + p.getEdad() + " WHERE DNI='" + p.getDNI() + "';");
			st.close();
			/**
			 * Aqui lo que estamos diciendo es que si la cantidad que nos devuelve nuestra
			 * sentencia es mayor que 0, es porque se ha producido al menos una
			 * actualizacion y por tanto se ha ejecutado correctamente nuestra sentencia
			 */
			if (cant > 0) {
				return true;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return false;
	}

	/**
	 * Con este metodo vamos a eliminar los trabajadores
	 * 
	 * @param p es el trabajador que vamos a eliminar
	 * @return true si se pudo eliminar, y false si no se pudo
	 */
	public boolean eliminarTrabajador(Personal p) {
		try {
			st = connect.createStatement();
			/**
			 * Este metodo nos devolvera un int, que es el numero de actualizaciones que se
			 * han producido con nuestra sentencia. Aqui lo que se hace es eliminar de la
			 * tabla personal al trabajador que tenga el DNI de p.getDNI, o sea el
			 * trabajador que se pasa por parametro.
			 */
			int cant = st.executeUpdate("DELETE FROM personal WHERE DNI='" + p.getDNI() + "';");
			st.close();
			/**
			 * Aqui lo que estamos diciendo es que si la cantidad que nos devuelve nuestra
			 * sentencia es mayor que 0, es porque se ha producido al menos una
			 * actualizacion y por tanto se ha ejecutado correctamente nuestra sentencia
			 */
			if (cant > 0) {
				return true;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return false;
	}

	/**
	 * Creamos esta funcion para obtener la nomina de cada trabajador
	 * 
	 * @param DNI es el DNI del trabajador
	 * @return la nomina del trabajador
	 */
	public void obtenerNomina(Personal per) {
		try {
			st = connect.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM nomina WHERE id_personal='" + per.getDNI() + "';");
			while (rs.next()) {
				int mes = rs.getInt("mes");
				double salario = rs.getDouble("salario");
				double irpf = rs.getDouble("irpf");
				/**
				 * Asi añadimos la nomina a cada persona
				 */
				per.addNomina(new Nomina(mes, salario, irpf));
				// return new Nomina(mes, salario, irpf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// return null;
	}

	/**
	 * Con este metodo vamos a obtener una lista de trabajadores. Como nosotros
	 * queramos, usando el SELECT
	 * 
	 * @return lista de trabajadores
	 */
	public List<Personal> obtenerPersonal() {
		List<Personal> lista = new ArrayList<>();
		try {
			st = connect.createStatement();
			/**
			 * Esto devuelve un ResultSet, que esto es como un puntero, o sea, indicador de
			 * donde estan estos datos guardados, hay que tener mucho cuidado con esto,
			 * porque no podemos convertilo a la clase Personal por ejemplo. En este caso
			 * vamos obtener a todos los trabajadores y lo vamos a almacenar en nuestro
			 * objeto rs de la interfaz ResultSet
			 */
			ResultSet rs = st.executeQuery("SELECT * FROM personal ;");
			/**
			 * Aqui lo que hacemos es que basicamente, nostros arriba hemos seleccionado
			 * todos los trabajadores de la tabla. Bien lo que pasa es que cuando lo
			 * almacenamos en rs pues, funciona como un array, comienza en la posicion 0, es
			 * decir, donde no hay trabajadores, por eso usamos el next, para que adelante
			 * posicion por posicion, y entonces lo que hacemos aqui es cambia de posicion
			 * hasta que ya no haya una siguiente. El next es true si hay una posicion
			 * siguiente y false si no la hay. Por eso usamos un while
			 */
			while (rs.next()) {
				/**
				 * Aqui creamos la variable dni y le asignaremos el valor del rs.getString, y el
				 * parametro que se pone es el nombre de la columna de nuestra tabla que
				 * queremos almacenar,este nombre tiene que ser exactamente igual al de la
				 * tabla, ponemos DNI y entonces seleccionara el dni de nuestra tabla de esa
				 * persona. Recordemos que cojera uno por uno.
				 */
				String dni = rs.getString("DNI");
				String nombre = rs.getString("Nombre");
				/**
				 * Las bases de datos comienzan con el numero 1, no como los arrays que
				 * comienzan con el orden contando el 0, por tanto como se trata de la tercera
				 * columna, se pone el indice 3 y no el 2
				 */
				String direccion = rs.getString(3);
				int edad = rs.getInt(4);
				Personal p = new Personal(dni, nombre, direccion, edad);
				/**
				 * Con esto obtenemos la nomina de la persona
				 */
				obtenerNomina(p);
				lista.add(p);
				/**
				 * Recordemos que nosotros en la vida real trabajaremos con millones de datos en
				 * nuestra base de datos, por eso no haremos jamas o casi nunca, un select *
				 * from, debido a que si obtener estos millones de datos, colapsaremos nuestro
				 * programa y hasta puede que nuestro ordenador. Por eso lo normal es siempre
				 * usar filtros(WHERE)
				 */
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	/**
	 * Con este metodo vamos a obtener una lista de personas, pero que cumplan
	 * determinadas condiciones
	 * 
	 * @param filtros es la lista de filtros que vamos a aplicar a las personas de
	 *                la tabla personal de nuestra base de datos
	 * @return una lista personas que cumplen una serie de condiciones
	 */
	public List<Personal> obtenerPersonalFiltro(List<String> filtros) {
		List<Personal> lista = new ArrayList<>();
		try {
			/**
			 * Aqui lo que estamos haciendo es guardar en esta variable nuestra consulta
			 */
			String sql = "SELECT * FROM personal";
			/**
			 * Si la lista de filtros no esta vacia, aplicaremos lo siguiente
			 */
			if (!filtros.isEmpty()) {
				/**
				 * Recordemos los espacios ya que si estan juntas estaria mal
				 */
				sql += " WHERE ";
				/**
				 * El ultimo filtro lo vamos a omitir por eso el -1
				 */
				for (int i = 0; i < filtros.size() - 1; i++) {
					/**
					 * A nuestra consulta le concatenamos nuestro filtro en posicion i, por ejemplo,
					 * DNI = '1234567K' ,y despues el AND, que significa que hay otro filtro que
					 * puede ser por ejemplo la Direccion
					 */
					sql += filtros.get(i) + " AND ";
				}
				/**
				 * Esto es que si o si se va a concatenar un filtro, y es que en el for como
				 * hemos visto si por ejemplo hay solo un filtro, pues no entraria en el bucle,
				 * y por tanto con esta sentencia nos aseguramos de que al menos pues haya un
				 * filtro, y ademas en caso de que si que haya filtros, pues este sera el ultimo
				 * y como vemos no tiene el AND, por tanto no habra mas
				 */
				sql += filtros.get(filtros.size() - 1);
			}

			st = connect.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String dni = rs.getString("DNI");
				String nombre = rs.getString("Nombre");
				String direccion = rs.getString(3);
				int edad = rs.getInt(4);
				// Nomina nom = obtenerNomina(dni);
				Personal p = new Personal(dni, nombre, direccion, edad);
				obtenerNomina(p);
				lista.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	/**
	 * Esta funcion sirve para generar los filtros que queramos. Es estatica porque
	 * no usamos ningun parametro de antes
	 * 
	 * @return un filtro que hayamos determinado
	 * @param opcion, es el numero que nosotros indicaremos que funciona como
	 *                indice, es decir, si por ejemplo ponemos el 1, se refiere a la
	 *                primera columna de nuestra tabla
	 * @param param   es el dato que nosotros queremos buscar, es decir, si por
	 *                ejemplo nosotros ponemos en el indice el 1, se trata de la
	 *                columna DNI, y el param sera el DNI que nosotros estamos
	 *                buscando
	 */
	public static String filtro(int opcion, String param) {
		switch (opcion) {
		case 1:
			return "DNI='" + param + "'";
		case 2:
			/**
			 * Aqui lo que estamos haciendo, es que a veces no sabemos como esta escrito
			 * exactamente en la base de datos el nombre, por tanto, cuando nosotros lo
			 * escribamos por parametro, lo pondremos todo en minuscula con el tolowercase,
			 * Y, pondremos el nombre de la base de datos en minuscula tambien con el LOWER
			 * (). Recordemos que si alguna vez tenemos alguna duda con SQL, lo buscamos en
			 * google y ya esta
			 */
			return "LOWER (Nombre)='" + param.toLowerCase() + "'";
		case 3:
			/**
			 * Aqui lo que haremos sera buscar la direccion que cuente con al menos una
			 * coincidencia dentro de la columna, es decir, si por ejemplo una persona tiene
			 * una direccion llamada, Badalona 93, Madrid; y otra persona tiene la direccion
			 * en Calle Sandalio Lopez, Madrid; lo que pasaria aqui es que si por ejemplo
			 * nosotros en el parametro hemos puesto Madrid, pues se seleccionarian ambas
			 * direcciones, y esto porque los simbolos % % que se ponen adelante y atras
			 * significa que ignora el resto que no coincida con el parametro. El LIKE es lo
			 * equivalente a =
			 */
			return "Direccion LIKE'%" + param + "%'";
		case 4:
			/**
			 * Con este filtro lo que haremos sera buscar a personas con la edad igual a la
			 * de el parametro, pero como vemos abajo tambien podemos buscar a gente con
			 * edad menor que a la del parametro o mayor, como vemos no hace falta que este
			 * entre comillas dobles, ya que se trata de un numero, y recordemos que con
			 * comillas simple especificabamos que era un texto, y en este caso no
			 */
			return "Edad=" + param;
		case 5:
			return "Edad<" + param;
		case 6:
			return "Edad>" + param;
		}
		return null;
	}

	/**
	 * Esta funcion servira para obtener el Departamento del personal
	 * 
	 * @return la lista de departamentos o departamento a la que pertenece el
	 *         personal
	 */
	public List<Departamento> obtenerDepartamento() {
		List<Departamento> lista = new ArrayList<>();
		try {
			st = connect.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM departamento ;");
			while (rs.next()) {
				String nombre = rs.getString("Nombre");
				int plantilla = rs.getInt("plantilla");
				Departamento p = new Departamento(nombre, plantilla);
				// obtenerNomina(p);
				lista.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	/**
	 * Este metodo lo usaremos junto con la clase de localizacion que vimos en la
	 * unidad4 clase3
	 */
	public boolean insertarPublicacion(String titulo, String contenido) {
		try {
			st = connect.createStatement();
			int cant = st.executeUpdate("INSERT INTO publicaciones VALUES ('" + titulo + "','" + contenido
					+ "', NOW(), '" + Locale.getDefault().getLanguage() + "' );");
			st.close();
			if (cant > 0) {
				return true;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return false;
	}

	/**
	 * Con este metodo podremos obtener las publicaciones de nuestra tabla de
	 * publicaciones de nuestra base de datos, este metodo tambien esta relacionado
	 * con la clase3 de la unidad4
	 */
	public String obtenerPublicaciones(ResourceBundle idioma) {
		String text = "";
		try {
			st = connect.createStatement();
			/**
			 * Aqui si que filtramos para solo obtener las publicaciones que tengan el
			 * idioma español
			 */
			ResultSet rs = st.executeQuery(
					"SELECT * FROM publicaciones WHERE idioma='" + Locale.getDefault().getLanguage() + "' ;");
			while (rs.next()) {
				String titulo = rs.getString("titulo");
				String contenido = rs.getString("contenido");
				text += idioma.getString("titulo") + ": " + titulo + "\n" + idioma.getString("contenido") + ": "
						+ contenido + "\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return text;
	}
}
