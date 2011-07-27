package mx.home.biblioteca.model;

/**
 * Representa el nombre de una persona. Su estructura es: hasta 4 nombres, con 1
 * requerido; 1 apellido paterno requerido y 1 apellido (materno) opcional.
 * 
 * @author cesar_garciam
 * @version 1.0
 * 
 */
public class Nombre {

	public Nombre(final String nombre1, final String apellidoPaterno) {
		this.nombre1 = nombre1;
		this.apellidoPaterno = apellidoPaterno;
	}

	private String nombre1;
	private String nombre2;
	private String nombre3;
	private String nombre4;
	private String apellidoPaterno;
	private String apellidoMaterno;

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(final String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(final String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getNombre3() {
		return nombre3;
	}

	public void setNombre3(final String nombre3) {
		this.nombre3 = nombre3;
	}

	public String getNombre4() {
		return nombre4;
	}

	public void setNombre4(final String nombre4) {
		this.nombre4 = nombre4;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(final String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(final String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

}
