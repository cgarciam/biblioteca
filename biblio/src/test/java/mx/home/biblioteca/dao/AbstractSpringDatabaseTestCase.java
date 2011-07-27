package mx.home.biblioteca.dao;

import java.io.FileNotFoundException;

import javax.sql.DataSource;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath:/META-INF/spring/dao-context-test.xml" })
public abstract class AbstractSpringDatabaseTestCase extends
		AbstractJUnit4SpringContextTests {

	private DataSource dataSource;
	private IDatabaseTester tester; // NOPMD by Cesar on 25/07/11 05:30 AM

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(final DataSource dataSource) {
		this.dataSource = dataSource;
	}

	protected void setUp() throws Exception { // NOPMD
		tester = new DataSourceDatabaseTester(getDataSource());
		tester.setDataSet(getDataSet());
		tester.onSetup();
	}

	protected abstract IDataSet getDataSet() throws DataSetException,
			FileNotFoundException;

	protected IDatabaseConnection getConnection() throws Exception { // NOPMD
		return tester.getConnection();
	}

	// @SuppressWarnings("deprecation")
	protected void closeConnection(final IDatabaseConnection connection)
			throws Exception { // NOPMD
		tester.closeConnection(connection);
	}

}
