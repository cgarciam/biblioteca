package mx.home.biblioteca.dao.test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import mx.home.biblioteca.dao.LibroDao;
import mx.home.biblioteca.model.Libro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class LibroDaoDummyImpl implements LibroDao {

	@Override
	public Collection<Libro> buscarLibrosPorPalabraClave(
			final String palabrasClave) {
		LOG.debug("palabrasClave:" + palabrasClave);
		return Collections.unmodifiableCollection(LIBROS_COLL);
	}

	private static final Collection<Libro> LIBROS_COLL;
	private static final int NUM_TOTAL_LIBROS = 3;
	private static final Logger LOG;

	static {
		LOG = LoggerFactory.getLogger(LibroDaoDummyImpl.class);
		LIBROS_COLL = new HashSet<Libro>();
		for (int i = 0; i < NUM_TOTAL_LIBROS; i++) {
			addBook(i);
		}
	}

	private static void addBook(final int index) {
		final Libro libro = new Libro("titulo" + index);
		libro.setEdicion(1);
		LIBROS_COLL.add(libro);
	}

	@Override
	public Libro buscarLibroPorId(final Long libroId) {
		// TODO Auto-generated method stub
		return null;
	}

}
