package unidad2;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.SerializationUtils;

public class clase2 {

	public static void main(String[] args) {
		Properties p = new Properties();
		p.put("Autor", "Tinho");
		p.put("BBDD", "MySQL");
		p.put("url", "miurl.com");
		p.put("user", "admin");
		p.put("password", "3327437");
		try {
			p.store(new FileOutputStream("miproyecto.conf"), "Esto es una configuracion basica de mi proyecto");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Properties p2 = new Properties();
		try {
			p2.load(new FileInputStream("miproyecto.conf"));
			System.out.println(p2.getProperty("Autor"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("datos.lmm"));// Es la forma mas basica de
																							// manejar archivos binarios
			dos.writeDouble(67.7);
			dos.writeBoolean(true);
			dos.writeUTF("hola que tal");
			Persona per = new Persona("Luis", 30);
			byte[] data = SerializationUtils.serialize(per);
			dos.write(data);
			dos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
