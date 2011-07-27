package mx.home.biblioteca.model.util;

/**
 * Form backing bean to hold search details
 * @author Cesar Garcia M
 * @version 1.0
 */
public class CriterioBusquedaLibro {
	/**
	 * The free form search query
	 */
	private String query;

	/**
	 * Construct an empty criteria
	 */
	public CriterioBusquedaLibro() {
		this("");
	}

	/**
	 * Construct criteria with the provided query
	 * 
	 * @param query
	 */
	public CriterioBusquedaLibro(final String query) {
		this.query = query;
	}

	public void setQuery(final String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}

}
