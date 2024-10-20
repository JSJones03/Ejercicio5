package ad_tarea5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Introduce 5 alumnos");
		Alumno alum;
		Scanner sc = new Scanner(System.in);
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();

		System.out.println("Introduzca la ruta donde quiere guardar a los alumnos ");
		String ruta = sc.nextLine();
		System.out.println("Escriba el nombre del fichero:");
		String nombre = sc.nextLine();
		nombre = nombre + ".dat";
		File fichero = new File(ruta + "\\" + nombre);

		FileOutputStream os;
		ObjectOutputStream oos;
		try {
			os = new FileOutputStream(fichero, true);
			oos = new ObjectOutputStream(os);

			for (int i = 0; i < 2; i++) {
				int dia = 0, mes = 0, anhio = 0;
				String vCurso, vCiclo, grupo;
				char genero;

				System.out.println("Alumno " + (i + 1));
				alum = new Alumno();
				System.out.println("Introduce el nombre:");
				alum.setNombre(sc.next());
				System.out.println("Introduce el Apellido:");
				alum.setApellido(sc.next());

				do {
					sc.nextLine();
					try {
						System.out.println("Introduce el NIE(9 digitos):");
						alum.setNia(sc.nextInt());

					} catch (InputMismatchException e) {
						System.out.println("El NIE solo puede tener números");
						alum.setNia(0);
					}
				} while (Integer.toString(alum.getNia()).length() != 9);
				do {
					try {
						sc.nextLine();
						System.out.println("Introduce la fecha de nacimiento");
						System.out.println("Introduce dia (1-30):");
						dia = sc.nextInt();

						System.out.println("Introduce mes(1-12):");
						mes = sc.nextInt();

						System.out.println("Introduce anho(1924-2025):");
						anhio = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Solo se pueden escribir numeros enteros");

					}
				} while ((dia < 1 || dia > 31) || (mes < 1 || mes > 12) || (anhio < 1924 || anhio > 2024));

				alum.setFechaNacimiento(LocalDate.of(anhio, mes, dia));

				vCiclo = sc.nextLine();
				do {
					System.out.println("Introduce el ciclo:");
					System.out.println("DAM\tDAW\tASIR");
					vCiclo = sc.nextLine();
				} while (!(vCiclo.toUpperCase().equalsIgnoreCase("DAM") || vCiclo.toUpperCase().equalsIgnoreCase("DAW")
						|| vCiclo.toUpperCase().equalsIgnoreCase("ASIR")));

				alum.setCiclo(vCiclo);

				do {
					System.out.println("Introduce el curso:");
					System.out.println("Primero\t Segundo");
					vCurso = sc.nextLine();
				} while (!(vCurso.equalsIgnoreCase("Primero") || vCurso.equalsIgnoreCase("Segundo")));
				alum.setCurso(vCurso);

				do {
					System.out.println("Introduce el grupo");
					System.out.println("1. A\t2. B\t3. C");
					grupo = sc.nextLine();
				} while (!(grupo.equalsIgnoreCase("A") || grupo.equalsIgnoreCase("B") || grupo.equalsIgnoreCase("C")));
				alum.setGrupo(grupo);

				do {
					System.out.println("Introduce el género: ");
					System.out.println("1. H\t2. M");
					genero = sc.next().toUpperCase().charAt(0);
				} while (genero != 'H' && genero != 'M');
				alum.setGenero(genero);

				oos.writeObject(alum);
				listaAlumnos.add(alum);
			}

			/*for (Alumno alumno : listaAlumnos) {
				System.out.println(alumno);
			}*/
			
			try {
				LeeAlumnos.leerFichero(fichero);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			oos.close();
			sc.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
