package unidad2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class clase3 {

	public static void main(String[] args) {
		try {
			List<Persona> personas = new ArrayList<>();
			personas.add(new Persona("Pedro", 33));
			personas.add(new Persona("Ana", 19));
			personas.add(new Persona("Emilio", 21));
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("personas.dat"));
			oos.writeObject(new Persona("Luis", 30));
			oos.writeObject(personas);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personas.dat"));
			Persona p = (Persona) ois.readObject();
			System.out.println(p);
			List<Persona> personas = (List<Persona>) ois.readObject();
			System.out.println(personas.size());
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<String> info = new ArrayList<>();
		info.add("Hola Mundo2");
		info.add("Que tal2");
		info.add("Buenos Dias2");
		try {
			Files.write(Paths.get("nio2.txt"), info, StandardOpenOption.APPEND);// Con el append lo que hace es
																				// conservar las 3 primeras y luego
																				// sumar las 3 nuevas
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			List<String> info2 = Files.readAllLines(Paths.get("nio2.txt"));
			for (String text : info2) {
				System.out.println(text);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
