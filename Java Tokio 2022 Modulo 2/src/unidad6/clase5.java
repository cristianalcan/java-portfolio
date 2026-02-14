package unidad6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class clase5 {

	public static void main(String[] args) {
		// Como vimos por encima en la clase 4 los metodos referenciados, aqui veremos
		// mas ejemplos

		// Aqui lo que estamos haciendo es el uso de metodos referenciados, que es lo
		// que hacen estos 4 puntos? pues bien, lo que hace es que nosotros creamos un
		// objeto de la interfaz compare, y le asignamos que este objeto tenga como
		// metodo referenciado, o es decir, que el metodo abstracto que contiene la
		// interfaz y por tanto la tiene el objeto, pues tenga las instrucciones que el
		// metodo compararCon10 de la clase Operaciones. Recordemos que ademas esto lo
		// hacemos porque siempre que implementamos una interfaz sus metodos tambien se
		// tienen que añadir y en este caso le decimos que sea como compararCon10, ya
		// que la interfaz cuenta con un solo metodo, si la interfaz cuenta con mas
		// metodos no debemos hacer esto
		Compare com = Operaciones::compararCon10;

		// Aqui vemos que el esMenor ahora funciona como el compararCon10. Ahora es MUY
		// IMPORTANTE!! que el metodo que vayamos a referenciar, que es el metodo
		// abstracto tenga las mismas caracteristicas que el metodo que nosotros estamos
		// "sustituyendo", o sea, el valor que retorna y la cantidad de parametros
		System.out.println(com.esMenor(8));

		// Aqui que estamos haciendo, pues casi mas de lo mismo que arriba, ya que
		// usamos la interfaz funcional consumer, que nos pide un tipo String, y lo que
		// hacemos es referenciarlo al Constructor de la clase Operaciones, en este caso
		// porque las caracteristicas de ambos metodos son similares, ya que pide un
		// dato String, como vemos con el new ya damos a entender que es el constructor
		Consumer<String> con1 = Operaciones::new;

		// Asi añadimos elementos al objeto y cuando, se ejecute, mostrara ademas del
		// texto añadido, lo que se haya especificado en el constructor
		con1.accept("Hola");

		List<ObjetoSimple3> lista = new ArrayList<>();
		ObjetoSimple3 obs1 = new ObjetoSimple3(5, "hola");
		ObjetoSimple3 obs2 = new ObjetoSimple3(5, "hola");
		ObjetoSimple3 obs3 = new ObjetoSimple3(5, "hola");
		ObjetoSimple3 obs5 = new ObjetoSimple3(8, "adios");
		ObjetoSimple3 obs4 = new ObjetoSimple3(2, "hola");

		lista.add(obs1);
		lista.add(obs2);
		lista.add(obs3);
		lista.add(obs4);
		lista.add(obs5);

		// Aqui lo que hacemos es remover un elemento en caso de que el numero sea menor
		// que 5, esto con expresion lambda
		// lista.removeIf(n -> n.getNum() < 5);

		// Esto hace exactamente lo mismo que lo de arriba, lo que pasa es que aqui
		// estamos referenciando un metoodo, de la clase ObjetoSimple3, concretamente
		// esMenor, esto se puede referenciar debido a que el metodo esMenor cumple con
		// las caracteristicas, ya que recibe un parametro ObjetoSimple3, igual que el
		// removeIF porque se trata de una lista de ese tipo. Como lo que
		// pide es un Predicate, retorna un boolean el metodo esMenor, y entonces ya
		// funciona
		lista.removeIf(ObjetoSimple3::esMenor);
		System.out.println(lista.size());// Aqui sale la lista despues de remover los numeros menores que 5

		// Los streams nos permiten trabajar con expresiones lambda de una manera mas
		// sencilla, y hace que tengamos menos lineas de codigo

		System.out.println();
		Stream<ObjetoSimple3> s1 = lista.stream();// Asi yo puedo guardar mi lista en un stream

		Integer[] numeros = { 2, 3, 5, 7, 9, 2, 4, 5, 5 };// Tenemos que poner Integer para poder almacenarlo en un
															// Stream
		Stream<Integer> s2 = Stream.of(numeros);// De esta manera almacenamos un Array en un stream

		// IMPORTANTE, los objetos que creamos de Stream no se puede ejecutar varias
		// funciones que afecten el Stream, o lo modifiquen, solo puede tener una
		// funcion de estas

		System.out.println(s2.distinct().count());// Aqui lo que hace es contar solo los elementos distintos, los
													// repetidos los elimina

		// Nos pide un predicate, por tanto aqui la expresion lambda devuelve un boolean
		// como el predicate
		System.out.println(s2.dropWhile(n -> n < 5).count());// Aqui lo que hace es eliminar mientras los numeros sean
																// menores que 5, si el primer numero no es menor que 5
																// ya no se ejecuta

		// Recordemos que tambien podemos concatenar los metodos, y se ejecutan en orden
		// segun se haya instanciado
		System.out.println(s2.distinct().filter(n -> n < 5).count());// Aqui elimina los numeros menores que 5, los
																		// cuenta por el count

		// Aqui lo que hacemos es limitar la lista, y es que solo se muestran los
		// primeros 5 elementos, y los demas se eliminan, con el foreach lo mostramos
		// por consola, ya que el for each no nos pideun valor de retorno, como el void
		s2.limit(5).forEach(n -> System.out.println(n));

		System.out.println();

		// Esto nos permite ver todos los elementos de la lista, y si todos los numeros
		// de la lista son menores que el numero indicado retorna true, en caso
		// contrario retorna false, el stream lo que hace es brindarnos las funciones
		// disponibles de collection, gracias a ello podemos usar allmatch
		System.out.println(lista.stream().allMatch(n -> n.getNum() < 5));

		// En este caso es todo igual que lo de arriba lo unico que con any, mientras se
		// cumpla que un numero es menor que 5 ya es true
		System.out.println(lista.stream().anyMatch(n -> n.getNum() < 5));

		// Con este metodo lo que vemos es si hay algun texto que sea adios
		System.out.println(lista.stream().anyMatch(n -> n.getTexto().equals("adios")));

		// Aqui lo que hacemos es ver en la lista los elementos distintos, si no ponemos
		// el count nos tendria que devolver true o false, sin embargo, con el count,
		// nos va a devolver la cantidad de elementos distintos
		System.out.println(lista.stream().distinct().count());

		// En este metodo podemos buscar elementos con una condicion, si no ponemos el
		// count nos deveria devolver los elementos que cumplen la condicion, en este
		// caso son 4 los elementos que cumplen la condicion
		System.out.println(lista.stream().filter(n -> n.getNum() < 6).count());
	}

}
