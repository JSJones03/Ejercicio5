package ad_tarea5;

import java.io.Serializable;
import java.time.LocalDate;

public class Alumno implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Nia;
	private String nombre, apellido, ciclo, curso, grupo;
	private LocalDate fechaNacimiento;
	private char genero;

	public Alumno() {
	}

	public void setNia(int nia) {
		this.Nia = nia;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public int getNia() {
		return Nia;
	}

	@Override
	public String toString() {
		return "Alumno [nia=" + Nia + ", nombre=" + nombre + ", apellido=" + apellido + ", ciclo=" + ciclo + ", curso="
				+ curso + ", grupo=" + grupo + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + "]";
	}

}
