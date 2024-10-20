package ad_tarea5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class LeeAlumnos {

	public static void main(String[] args) {
		
	}

	public static void leerFichero(File fichero) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fichero);
		ObjectInputStream ois = new ObjectInputStream(fis);

		while (fis.available() > 0) {
			Alumno alumno = (Alumno) ois.readObject();
			System.out.println(alumno.toString());
		}
		ois.close();
	}

}
