package unidad2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class clase1 {

	public static void main(String[] args) {
		File f2 = new File("ejemplo2.text");
		try {
			File f1 = new File("ejemplo.txt");
			if (f1.canRead()) {
				System.out.println("Se puede leer");
			}
			File f3 = new File("C:\\Users\\crist\\Documents");
			System.out.println(Arrays.toString(f3.list()));
			Scanner entrada = new Scanner(f1);
			System.out.println(entrada.nextLine());
			entrada.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader("urls.txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			PrintWriter pw = new PrintWriter(new FileWriter(f2, true));//Esto es para que no sobrescriba
			pw.append("Hola");
			pw.println(" que tal?");
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader("alumnos.csv"));
			String linea = br.readLine();
			while ((linea = br.readLine()) != null) {
				String[] aux = linea.split(";");
				System.out.println(
						"Años: " + aux[0] + " Provincia: " + aux[3] + " Municipio: " + aux[5] + " Idioma: " + aux[9]);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
