package com.egg.libreria.controladores;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErroresControlador implements ErrorController {

	@RequestMapping(value = "/error", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView errores(HttpServletResponse response) {

		ModelAndView mav = new ModelAndView("error");
		String mensaje = "";
		int codigo = response.getStatus();

		switch (codigo) {
		case 400: {
			mensaje = "El recurso solicitado no existe.";
			break;
		}
		case 403: {
			mensaje = "No tiene permisos para acceder al recurso.";
			break;
		}
		case 401: {
			mensaje = "No se encuentra autorizado.";
			break;
		}
		case 404: {
			mensaje = "El recurso solicitado no fue encontrado.";
			break;
		}
		case 500: {
			mensaje = "Ocurrió un error interno.";
			break;
		}
		}

		mav.addObject("codigo", codigo);
		mav.addObject("mensaje", mensaje);

		return mav;
	}
}