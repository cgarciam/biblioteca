package mx.home.biblioteca.dao.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public final class DataSourceUtils {

	private DataSourceUtils() {
		// for PMD
	}

	private static final DataSource DATA_SOURCE = createBasicDataSource();

	private static DataSource createBasicDataSource() {
		return mySqlBasicDataSource();
	}

	@SuppressWarnings("unused")
	private static BasicDataSource oracleBasicDataSource() {
		final BasicDataSource result = new BasicDataSource();
		result.setDriverClassName("oracle.jdbc.OracleDriver");
		result.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		result.setUsername("jpt");
		result.setPassword("jpt");
		return result;
	}

	private static BasicDataSource mySqlBasicDataSource() {
		final BasicDataSource result = new BasicDataSource();
		result.setDriverClassName("com.mysql.jdbc.Driver");
		result.setUrl("jdbc:mysql://localhost/biblioteca");
		result.setUsername("root");
		result.setPassword("rootita");
		return result;
	}

	public static DataSource getDataSource() {
		return DATA_SOURCE;
	}

}
