package unidad2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class prueba {

	public static void main(String[] args) {

		try {
			FileWriter writer = new FileWriter("file.txt");
			for (int i = 0; i < 3; i++) {
				writer.write("1\n");
			}
			for (int i = 0; i < 6; i++) {
				writer.write("2\n");
			}
			writer.close();

			System.out.println("Contenido del archivo antes de la sustitución:");
			Files.lines(Paths.get("file.txt")).forEach(System.out::println);

			String content = new String(Files.readAllBytes(Paths.get("file.txt")));
			content = content.replace("2", "3");
			Files.write(Paths.get("file.txt"), content.getBytes());

			System.out.println("Contenido del archivo después de la sustitución:");
			Files.lines(Paths.get("file.txt")).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
