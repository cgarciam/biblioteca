package mx.home.biblioteca.web.controller;

import mx.home.biblioteca.model.util.CriterioBusquedaLibro;
import mx.home.biblioteca.service.LibroService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// ESCA-JAVA0137:
@Controller
@RequestMapping("/libros/*")
public class BusquedaLibroController {

	private LibroService libroService; // NOPMD

	public void setLibroService(final LibroService libroService) {
		this.libroService = libroService;
	}

	// @Autowired
	// public BusquedaLibroController(/* LibroService libroService */) {
	// this.libroService = libroService;
	// }

	/**
	 * Validates the searchCriteria then executes the search with the
	 * LibroService
	 * 
	 * @param searchCriteria
	 *            The criteria to search for
	 * @param bindResult
	 *            Holds searchCriteria validation errors
	 * @param model
	 *            Holds the resulting list of books
	 * @return Success or error view
	 */
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String buscarLibrosPorPalabrasClave(
			final CriterioBusquedaLibro searchCriteria,
			final BindingResult bindResult, final Model model) {
		final String palabrasClave = searchCriteria.getQuery();
		if (palabrasClave == null || "".equals(palabrasClave)) {
			bindResult.rejectValue("query", "required",
					"Please enter valid search criteria");
		}
		String viewName = "libros/busqueda"; // NOPMD by Cesar on 19/07/11 01:05
												// PM
		if (bindResult.hasErrors()) {
			viewName = "libros/index";
		} else {
			model.addAttribute("libros",
					libroService.buscarLibrosPorPalabrasClave(palabrasClave));
		}
		return viewName;
	}

}
