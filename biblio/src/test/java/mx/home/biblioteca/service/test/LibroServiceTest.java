package mx.home.biblioteca.service.test;

// import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class LibroServiceTest {

	@Before
	public void setUp() {
		// TODO
	}

	@Test
	public void testBuscarLibrosPorPalabrasClave() {
		final Collection<String> palabrasClaveTest = new HashSet<String>();
		palabrasClaveTest.add("use");
		palabrasClaveTest.add("case");
		palabrasClaveTest.add("modeling");
		
		// TODO - fail("Not yet implemented");
	}

}
