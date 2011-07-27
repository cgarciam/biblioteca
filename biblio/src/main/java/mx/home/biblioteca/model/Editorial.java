package mx.home.biblioteca.model;

public class Editorial {

	public Editorial(final String nombre) {
		this.nombre = nombre;
	}

	private int idEditorial;
	private String nombre;

	public int getIdEditorial() {
		return idEditorial;
	}

	@SuppressWarnings("unused")
	private void setIdEditorial(final int idEditorial) {
		this.idEditorial = idEditorial;
	}

	public String getNombre() {
		return nombre;
	}

	@SuppressWarnings("unused")
	private void setNombre(final String nombre) {
		this.nombre = nombre;
	}

}
