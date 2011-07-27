package mx.home.biblioteca.service.impl;

import java.util.Collection;

import mx.home.biblioteca.dao.LibroDao;
import mx.home.biblioteca.model.Libro;
import mx.home.biblioteca.service.LibroService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Stub implementation of the BookSearchService using a predefined set of
 * Hotels
 * 
 * @author Cesar Garc&iacute;a Mauricio
 * @version 1.0
 */
@Service
public class LibroServiceImpl implements LibroService {
	private static final char SIMBOLO_SEPARADOR = '%';
	private static final Logger LOG;
	private LibroDao libroDao; // NOPMD

	public LibroServiceImpl() {
		LOG.info("Inicializando LibroService");
	}

	public LibroServiceImpl(final LibroDao libroDao) {
		LOG.info("Inicializando LibroService");
		this.libroDao = libroDao;
	}

	@Override
	public Collection<Libro> buscarLibrosPorPalabrasClave(
			final String palabrasClave) {
		// TODO To add all the n! - 1 missing permutations to the search...
		// Forma la cadena de búsqueda a partir de las palabras clave:
		final String palabrasClaveSep = palabrasClave.replace(' ',
				SIMBOLO_SEPARADOR);
		LOG.debug("cadenaBusqueda: " + palabrasClaveSep);
		return libroDao.buscarLibrosPorPalabraClave(palabrasClaveSep);
	}

	@Override
	public Collection<Libro> buscarLibrosPorTema() {
		// TODO Auto-generated method stub
		return null;
	}

	static {
		LOG = LoggerFactory.getLogger(LibroServiceImpl.class);
	}

}
