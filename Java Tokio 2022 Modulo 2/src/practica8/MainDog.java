package practica8;

import java.util.function.Function;

public class MainDog {

	public static void main(String[] args) {
		System.out.println("Dogs y funciones");
		Dog boi = new Dog("boi", 30, 6);
		Dog tyri = new Dog("tyri", 40, 12);
		Dog charis = new Dog("charis", 120, 7);

		Function<Dog, String> getName = d -> d.getName();
		System.out.print("getName: ");
		System.out.println(getName.apply(charis));
		Function<String, Character> getInitial = i -> i.charAt(0);
		System.out.print("getInitial: ");
		System.out.println(getInitial.apply("Hola"));
		System.out.print("andThen: ");
		System.out.println(getName.andThen(getInitial).apply(tyri));
		System.out.print("compose: ");
		System.out.println(getInitial.compose(getName).apply(tyri));

	}

}
