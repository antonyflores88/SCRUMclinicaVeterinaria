package sv.edu.ufg.controllers;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = AccessDeniedException.class)
    public String handleAccessDeniedException(AccessDeniedException e, Model model) {
        // Personaliza el mensaje de error y agrega cualquier información adicional al modelo
        model.addAttribute("error", "Acceso denegado: No tienes permisos para acceder a esta página.");
        return "hellow-secretaria"; // Nombre de la página de error personalizada
    }
}
