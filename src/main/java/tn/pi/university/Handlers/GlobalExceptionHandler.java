package tn.pi.university.Handlers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgument(IllegalArgumentException ex, HttpSession session) {
        session.setAttribute("error", ex.getMessage());
        return "redirect:/error";
    }

    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex, HttpSession session) {
        session.setAttribute("error", "An unexpected error occurred: " + ex.getMessage());
        return "redirect:/error";
    }
}