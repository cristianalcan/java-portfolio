package unidad2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class practica2 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("M2_T02_Origen.txt"));
			PrintWriter bw = new PrintWriter(new FileWriter("M2_02_Destino.txt"));
			String texto;
			while ((texto = br.readLine()) != null) {
				bw.println(texto.replace(" ", "-"));
			}
			bw.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
