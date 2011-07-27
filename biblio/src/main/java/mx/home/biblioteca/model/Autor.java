package mx.home.biblioteca.model;

import java.util.Collection;
import java.util.Collections;

/** Reps autores de libros.
 * @author Cesar Garc&iacute;a Mauricio.
 * @version 1.0
 */
public class Autor {
	
	public Autor(final Nombre nombre) {
		this.nombre = nombre;
	}
	
	private int idAutor;
	private Nombre nombre;
	private Collection<Libro> librosEscritos;

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(final int idAutor) {
		this.idAutor = idAutor;
	}

	public Nombre getNombre() {
		return nombre;
	}

	public void setNombre(final Nombre nombre) {
		this.nombre = nombre;
	}

	public Collection<Libro> getLibrosEscritos() {
		return Collections.unmodifiableCollection(librosEscritos);
	}

	public void setLibrosEscritos(final Collection<Libro> librosEscritos) {
		this.librosEscritos = Collections.unmodifiableCollection(librosEscritos);
	}

}
