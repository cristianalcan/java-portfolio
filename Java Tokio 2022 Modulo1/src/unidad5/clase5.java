package unidad5;

import java.util.Random;

public class clase5 {

	public static void main(String[] args) {
		Object x = new Estudiante("Pedro", 22, "353535353");
		Object y = "asd";

		Object[] arr = new Object[10];
		arr[0] = 14;
		arr[1] = "Luis";
		arr[2] = new Profesor("Luis", 1500, 10);

		System.out.println(x.getClass());
		System.out.println(((Estudiante) x).getNombre());  //Se castea x para que se pueda utilizar las funciones

		byte l1 = 109;
		int l2 = 107;
		char l3 = 106;
		// l1=l2;
		l2 = l1;
		l2 = l3;
		l3 = (char) l1;
		System.out.println(l3);
		l3 = (char) l2;
		System.out.println(l3);

		int ln2 = 110;
		char ln = (char) ln2;
		System.out.println(ln);

		Integer numi = 10;
		System.out.println(Math.PI); // Es para hallar pi
		System.out.println(Math.pow(5, 3)); // Es para hallar 5 al cubo
		System.out.println(Math.sqrt(9)); // Es para hallar la raiz de 9
		System.out.println(Math.floor(9.74)); //Devuelve el numero entero mas grande que es menor o igual que el argumento
		System.out.println(Math.abs(-67));  //Esto determina el valor absoluto, es decir si es negativo lo pasa a positivo
        Random r= new Random();    //Con esto declaramos una variable de tipo random
        System.out.println(r.nextInt(40)+10);  //Usaremos el nextint bound para que asi el 40 sea el maximo en cuanto a valor
                                               //Y le sumaremos 10 para que el numero este entre 10 y 50 por ejemplo
        System.out.println((int)(Math.random()*40+10)); //El math random solo te da un numero entre el 0 y el 1, pero con las
                                                        //condiciones que hemos especificado, dan numero entre 10 y 50 y 
                                                                                                 // de tipo int
	}

}
