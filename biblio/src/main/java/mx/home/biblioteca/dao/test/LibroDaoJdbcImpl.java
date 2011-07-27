package mx.home.biblioteca.dao.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

import mx.home.biblioteca.dao.LibroDao;
import mx.home.biblioteca.model.Libro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class LibroDaoJdbcImpl extends JdbcDaoSupport implements LibroDao {

	public LibroDaoJdbcImpl(final DataSource dataSource) { // NOPMD
		// namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
		// getDataSource());
		setDataSource(dataSource);
	}

	@Override
	public Collection<Libro> buscarLibrosPorPalabraClave(
			final String palabraClave) {
		// NOPMD by Cesar on 13/07/11 01:46 PM Long variable name
		// final NamedParameterJdbcTemplate namedParameterJdbcTemplate = new
		// NamedParameterJdbcTemplate( // NOPMD
		// getDataSource());
		LOG.debug("palabraClave: " + palabraClave);
		return new NamedParameterJdbcTemplate(getDataSource()).query(
				QRY_BOOKS_BY_KWORD, new MapSqlParameterSource().addValue(
						"palabraClave", COMODIN_ALL + palabraClave
								+ COMODIN_ALL), new RowMapper<Libro>() {
					public Libro mapRow(final ResultSet rSet, final int rowNum)
							throws SQLException {
						final Libro libro = new Libro(rSet.getString("titulo"),
								rSet.getLong("libro_Id"));
						libro.setEdicion(Integer.valueOf(rSet
								.getShort("edicion")));
						return libro;
					}
				});
	}

	@Override
	public Libro buscarLibroPorId(final Long libroId) {
		LOG.debug("buscarLibroPorId() libroId: " + libroId);
		return new NamedParameterJdbcTemplate(getDataSource()).queryForObject(
				QRY_BOOK_BY_ID,
				new MapSqlParameterSource().addValue("libroId", libroId),
				new RowMapper<Libro>() {
					public Libro mapRow(final ResultSet rSet, final int rowNum)
							throws SQLException {
						final Libro libro = new Libro(rSet.getString("titulo"),
								rSet.getLong("libro_Id"));
						libro.setEdicion(Integer.valueOf(rSet
								.getShort("edicion")));
						return libro;
					}
				});
	}

	private static final Logger LOG;
	// XXX private transient NamedParameterJdbcTemplate
	// namedParameterJdbcTemplate;

	private static final String COMODIN_ALL;
	private static final String QRY_BOOKS_BY_KWORD; // NOPMD
	// private static final String QRY_ALL_BOOKS; // NOPMD
	private static final String QRY_BOOK_BY_ID; // NOPMD

	static {
		LOG = LoggerFactory.getLogger(LibroDaoJdbcImpl.class);
		COMODIN_ALL = "%";
		QRY_BOOKS_BY_KWORD = "SELECT libro_id, edicion, titulo FROM LIBRO WHERE TITULO LIKE :palabraClave";
		// QRY_ALL_BOOKS = "SELECT edicion, titulo FROM LIBRO";
		QRY_BOOK_BY_ID = "SELECT libro_id, edicion, titulo FROM LIBRO WHERE LIBRO_ID LIKE :libroId";
	}

}
