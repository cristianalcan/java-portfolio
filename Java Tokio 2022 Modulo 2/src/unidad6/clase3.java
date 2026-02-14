package unidad6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class clase3 {

	public static void main(String[] args) {
		Calculadora suma = (n1, n2) -> (n1 + n2);
		Calculadora resta = (n1, n2) -> (n1 - n2);
		Calculadora multiplicacion = (n1, n2) -> (n1 * n2);
		Calculadora division = (n1, n2) -> (n1 / n2);
		List<Calculadora> operaciones = new ArrayList<>();
		operaciones.add(suma);
		operaciones.add(resta);
		operaciones.add(multiplicacion);
		operaciones.add(division);
		Function<List<Calculadora>, Integer> tamaño = ops -> ops.size();
		System.out.println("Tamaño " + tamaño.apply(operaciones));// Para ejecutar el cuerpo lambda con esta interfaz
																	// usamos este metodo

		Function<Integer, Integer> calculo = n -> n * 100;
		// La interfaz Function nos ofrece un metodo llamado compose, este metodo lo que
		// hace es añadirle a la variable que almacena la expresion lambda, pues otra
		// expresion lambda, y al ejecutarlo con apply nos muestra la expresion lambda
		// multiplicada con la otra expresion lambda
		System.out.println(calculo.compose(calculo).apply(1));

		// Esta es otra interfaz predefinida aparte de Function, lo que hace es ejecutar
		// una condicion, funciona de manera similar a un IF. Tiene una entrada de
		// datos, en este caso es un tipo Integer, y solo te devuelve un true o false
		Predicate<Integer> menorDeEdad = edad -> edad < 18;
		Predicate<Integer> menor65 = edad -> edad < 65;

		Predicate<Integer> edadAdulta = menorDeEdad.negate().and(menor65);// Aqui podemos apreciar que en esta interfaz
																			// predefinida hemos creado una expresion
																			// lambda a traves de otras interfaces, en
																			// este caso dice que menordeEdad tiene que
																			// ser falso y menor de 65 verdadero

		System.out.println(menorDeEdad.test(25));// Se evalua con test
		System.out.println(edadAdulta.test(25));

		// Esta interfaz predefinida funcional es practicamente igual que Function, la
		// diferencia es que esta interfaz no nos pide que especifiquemos el tipo de
		// dato que va a retornar , solo tenemos que especificar el tipo de dato que
		// vamos a usar
		Consumer<Integer> consum = num -> System.out.println("Numero " + num);
		consum.accept(10);

		// Esta interfaz no nos deja usar parametros, lo unico que hace es devolver
		// valores, y es del tipo que nosotros especifiquemos en este caso de tipo
		// Integer
		Supplier<Integer> ran = () -> new Random().nextInt(100);
		System.out.println(ran.get());

		// Esta interfaz funcional nos permite entrar 2 parametros y devolver 1, en este
		// caso los dos parametros de la izquierda son los que vamos a usar, y el de la
		// derecha el que devuelve, es importante especificar el tipo de los parametros
		BiFunction<Integer, Integer, Integer> sumbi = (n1, n2) -> n1 + n2;
		System.out.println(sumbi.apply(5, 8));

		// Aqui hemos nosotros creado una interfaz funcional que nos permite operar con
		// la cantidad de parametros que queramos, pero bien, se trata de un "arreglo",
		// n representa un arreglo, y por tanto funciona como tal, la ventaja es que
		// podemos utilizar la cantidad de parametros que queramos
		Parametros pam = (n) -> {
			int sum = 0;
			for (int i = 0; i < n.length; i++) {
				sum += n[i];
			}
			System.out.println(sum);
		};
		pam.datos(3, 6, 7, 9);

		// Esta interfaz es igual que Consumer, la diferencia es que recibe 2 parametros
		BiConsumer<Integer, Integer> sumCon = (n1, n2) -> System.out.println("Consumer " + (n1 + n2));
		sumCon.accept(6, 9);

		Function<Integer, Integer> sum1 = n -> n + 1;
		Function<Integer, Integer> cuadrado = n -> n * n;
		// Vamos a ver dos metodos que son similares pero algo diferentes

		System.out.println("andThen " + sum1.andThen(cuadrado).apply(10));// Aqui podemos ver que lo que hace este
																			// metodo es primero ejecutar el sum1, dando
																			// 11, y luego ejecutando el cuadrado que
																			// seria 11 por 11

		System.out.println("compose " + sum1.compose(cuadrado).apply(10));// Aqui en cambio podemos ver que lo primero
																			// en ejecutarse es el cuadrado, siendo 10
																			// por 10 dando 100, y luego este 100 se
																			// suma 1, ya que el sum1 se ejecuta despues
																			// del cuadrado

	}

}
