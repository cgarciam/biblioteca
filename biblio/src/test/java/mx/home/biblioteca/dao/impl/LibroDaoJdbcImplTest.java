package mx.home.biblioteca.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.Date;

import mx.home.biblioteca.dao.LibroDao;
import mx.home.biblioteca.dao.test.LibroDaoJdbcImpl;
import mx.home.biblioteca.dao.util.DataSourceUtils;
import mx.home.biblioteca.model.Libro;

import org.dbunit.DBTestCase;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// @ContextConfiguration(locations = { "classpath:/META-INF/spring/dao-context-test.xml" })
public class LibroDaoJdbcImplTest extends DBTestCase {

	@Before
	public void setUp() throws Exception { // NOPMD
		super.setUp();
		libroDao = getLibroDao();
		assertNotNull("Failed initial configuration of Dao", libroDao);
	}

	@Test
	public void testBuscarLibrosPorPalabraClave() {
		final Collection<Libro> librosEncontrados = libroDao
				.buscarLibrosPorPalabraClave("JAVA");
		if (LOG.isTraceEnabled()) {
			for (Libro libro : librosEncontrados) {
				LOG.trace(" " + libro);
			}
		}
		// assertLibro(libro, id, titulo, edicion);
		assertEquals("", 2, librosEncontrados.size());
		LOG.trace("time (mseg) testBuscarLibrosPorPalabraClave() - "
				+ (new Date().getTime() - INIT_TIME));
	}

	@Test
	public void testBuscarLibroPorId() {
		final Long libroId = 1L; // NOPMD
		final Libro libroEncontrado = libroDao.buscarLibroPorId(libroId);
		assertLibro(libroEncontrado, libroId, "JAVA WORLD", 1);
	}

	private static IDataSet dataSet;
	
	@Override
	protected IDataSet getDataSet() throws DataSetException,
			FileNotFoundException {
		if (!initDataSet) {
			initDataSet = Boolean.TRUE;
			final File dataSrcFile = new File("src/test/data/libroDataSet.xml");
			LOG.trace("Abs Path Data File: " + dataSrcFile.getAbsolutePath());
			try {
				dataSet = new XmlDataSet(new FileReader(dataSrcFile));
			} catch (DataSetException e) {
				LOG.error("DataSetException in getDataSet().", e);
				throw e;
			} catch (FileNotFoundException e) {
				LOG.error("FileNotFoundException in getDataSet().", e);
				throw e;
			}
		}
		return dataSet;
	}

	@Override
	protected IDatabaseTester newDatabaseTester() {
		return new DataSourceDatabaseTester(DataSourceUtils.getDataSource());
	}

	private static void assertLibro(final Libro libro, final Long libroId,
			final String titulo, final Integer edicion /*
														 * XXX Faltan otros
														 * campos
														 */) {
		assertEquals("Id de Libro no esperado.", libroId.longValue(), libro
				.getIdLibro().longValue());
		assertEquals("titulo de Libro no esperado.", titulo, libro.getTitulo());
		assertEquals("edicion de Libro no esperado.", edicion.intValue(), libro
				.getEdicion().intValue());
	}

	private static LibroDao getLibroDao() {
		return new LibroDaoJdbcImpl(DataSourceUtils.getDataSource());
	}

	private static LibroDao libroDao;
	private static final Logger LOG;
	private static final Long INIT_TIME;
	private static Boolean initDataSet;

	static {
		INIT_TIME = new Date().getTime();
		LOG = LoggerFactory.getLogger(LibroDaoJdbcImplTest.class);
		initDataSet = Boolean.FALSE;
	}

}
