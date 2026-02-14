package unidad6;

import java.util.ArrayList;
import java.util.List;

public class clase1 {

	public static void main(String[] args) {
		/*
		 * SimpleInterface si = new SimpleInterface() {// Esta sera como una especie de
		 * clase anonima
		 * 
		 * @Override public void FuncionPrueba() {// Cuando instanciamos la interfaz es
		 * la expresion lambda la que se encarga de // especificar las instrucciones del
		 * metodo abstracto System.out.println("Hola"); } };// Aqui va el punto y como
		 * porque es como si pusieramos este punto y coma // despues de haber declarado
		 * el objeto de la interfaz funcional
		 * 
		 * si.FuncionPrueba(); si.Mostrar();
		 */
		// En este caso necesitamos poner un parametro string, ponemos t1 como el nombre
		// del parametro, luego a la derecha ponemos el cuerpo lambda

		SimpleInterface si1 = (t1) -> {
			System.out.println("Hola " + t1);
			System.out.println("Otra operacion");
			};
		// Lo primero que vamos a hacer para implementar una expresion lambda es ver
		// los parametros de la funcion abstracta de la interfaz funcional, tiene que
		// ser del mismo tipo y la misma cantidad de parametros, al lado derecho tenemos
		// que poner el cuerpo lambda, es decir, lo que queremos que haga

		// En este caso, para poder ejecutar la funcion abstracta tenemos que pasar un
		// dato de tipo String por parametro, como si fuese t1, y ya se ejecutaria la
		// expresion lambda

		si1.FuncionPrueba("Luis");
		si1.Mostrar();

		Calculadora suma = (n1, n2) -> (n1 + n2);
		Calculadora resta = (n1, n2) -> (n1 - n2);
		Calculadora multiplicacion = (n1, n2) -> (n1 * n2);
		Calculadora division = (n1, n2) -> (n1 / n2);
		// Los ponemos en un syso porque la funcion no es void, sino que retorna un
		// numero y para poder verlo hay que usar un syso

		System.out.println(suma.operacion(5, 5));
		System.out.println(resta.operacion(5, 5));
		System.out.println(multiplicacion.operacion(5, 5));
		System.out.println(division.operacion(5, 5));

		// Asi podemos tener todos las expresiones lambda, guardados en una lista
		List<Calculadora> operaciones = new ArrayList<>();
		operaciones.add(suma);
		operaciones.add(resta);
		operaciones.add(multiplicacion);
		operaciones.add(division);

		System.out.println();

		for (Calculadora cal : operaciones) {// Con esto lo que hacemos es pasarle todos los metodos a una variable para
												// que asi pueda ejecutar todos los elementos en orden
			System.out.println(cal.operacion(6, 3));
		}
	}

}
