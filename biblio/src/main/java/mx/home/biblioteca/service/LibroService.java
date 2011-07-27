package mx.home.biblioteca.service;

import java.util.Collection;

import mx.home.biblioteca.model.Libro;

public interface LibroService {

	Collection<Libro> buscarLibrosPorPalabrasClave(String palabrasClave);

	Collection<Libro> buscarLibrosPorTema();

}
