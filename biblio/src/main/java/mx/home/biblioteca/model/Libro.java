package mx.home.biblioteca.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Libro {

	public Libro(final String titulo) {
		this.titulo = titulo;
	}

	public Libro(final String titulo, final Long libroId) {
		this.titulo = titulo;
		this.idLibro = libroId;
	}

	private Long idLibro;
	private String titulo;
	private Integer edicion;
	private Integer numPaginas;
	private Integer numCapitulos;
	private Date fechaPublicacion;
	private Collection<Autor> autores;

	public Long getIdLibro() {
		return idLibro;
	}

	@SuppressWarnings("unused")
	private void setIdLibro(final Long idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	@SuppressWarnings("unused")
	private void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	public Integer getEdicion() {
		return edicion;
	}

	public void setEdicion(final Integer edicion) {
		this.edicion = edicion;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(final Integer numPaginas) {
		this.numPaginas = numPaginas;
	}

	public Integer getNumCapitulos() {
		return numCapitulos;
	}

	public void setNumCapitulos(final Integer numCapitulos) {
		this.numCapitulos = numCapitulos;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(final Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Collection<Autor> getAutores() {
		return Collections.unmodifiableCollection(autores);
	}

	public void setAutores(final Collection<Autor> autores) {
		this.autores = Collections.unmodifiableCollection(autores);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("titulo", titulo)
				.append("edicion", edicion).toString();
	}

}
