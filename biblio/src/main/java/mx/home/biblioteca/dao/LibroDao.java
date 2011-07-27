package mx.home.biblioteca.dao;

import java.util.Collection;

import mx.home.biblioteca.model.Libro;

public interface LibroDao {

	Collection<Libro> buscarLibrosPorPalabraClave(String palabraClave);

	Libro buscarLibroPorId(Long libroId);

}
