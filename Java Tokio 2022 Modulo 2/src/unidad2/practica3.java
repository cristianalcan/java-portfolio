package unidad2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class practica3 {

	public static void main(String[] args) {
		File p3 = new File("practica3.txt");
		try {
			PrintWriter bw3 = new PrintWriter(new FileWriter(p3, true));
			for (int i = 0; i < 3; i++) {
				bw3.println("1");
			}
			for (int i = 0; i < 6; i++) {
				bw3.println("2");
			}
			bw3.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			BufferedReader br3 = new BufferedReader(new FileReader(p3));
			String leer;
			System.out.println("Resultado antes de modificar:");
			while ((leer = br3.readLine()) != null) {
				System.out.println(leer);
			}
			br3.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> cambio;
		try {
			System.out.println("Resultado despues de modificar:");
			cambio = Files.readAllLines(Paths.get("practica3.txt"));
			Collections.replaceAll(cambio, "2", "3");
			Files.write(Paths.get("practica3.txt"), cambio);
			System.out.println(cambio);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}
