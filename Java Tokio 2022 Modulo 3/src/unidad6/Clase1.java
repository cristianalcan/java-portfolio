package unidad6;

public class Clase1 {

	public static void main(String[] args) {
		/**
		 * En esta clase no veremos practica como tal, Solo Teoria
		 */
		/*
		 * Bien en primer lugar vamos a aprender a usar las principales sentencias de
		 * SQL.
		 * 
		 * 1.CREATE DATABASE trabajadores (Create Database es la sentencia para crear
		 * una base de datos, y trabajadores es el nombre de la base de datos)
		 * 
		 * 2. CREATE TABLE informacion (Create table es la sentencia para crear una
		 * tabla en nuestra base de datos, y esta tabla se llamara informacion)
		 * 
		 * 3.CREATE TABLE(- dni varchar(255)(Es el tamaño maximo de caracteres) -primary
		 * key(llave primaria para que aparezca al inicio), direccion text, edad int,
		 * estatura double) Asi es otra forma de crear las tablas, donde las variables
		 * entre parentesis son las columnas de nuestra tabla
		 * 
		 * 4.DROP TABLE informacion(Esta sentencia es para eliminar la tabla entera)
		 * 
		 * 5. INSERT INTO informacion(direccion, edad) VALUES('Calle Badalona', 23) En
		 * esta sentencia lo que hacemos es añadir una fila mas a nuestra tabla, con los
		 * datos direccion= Calle Badalona y edad=23.
		 * 
		 * 6.UPDATE informacion SET direccion='Calle Badalona 8' WHERE direccion='Calle
		 * Badalona'. Con esta sentencia lo que estamos haciendo es actualizar un dato,
		 * concretamente de la tabla Informacion, y con el SET es el nuevo dato
		 * ingresado, que cumpla con la condicion(WHERE) de que la direccion='Calle
		 * Badalona'. Muy importante el WHERE ya que si no lo usamos cambiara a todas
		 * las direcciones de la tabla por la nueva.
		 * 
		 * 7.DELETE FROM informacion WHERE direccion='Calle Badalona 8'. Aqui lo que
		 * estamos haciendo es eliminar de la tabla informacion, la direccion='Calle
		 * Badalona 8'.
		 * 
		 * Luego tambien por ejemplo si tuvieseme una tabla de precios podriamos hacer
		 * lo siguiente:
		 * 
		 * SELECT FROM precios WHERE precio>=100 and precio<=200; Lo que estamos
		 * diciendo aqui es que vamos a consultar o ver los precios que sean mayor o
		 * igual a 100 y menor o igual a 200
		 */

	}

}
