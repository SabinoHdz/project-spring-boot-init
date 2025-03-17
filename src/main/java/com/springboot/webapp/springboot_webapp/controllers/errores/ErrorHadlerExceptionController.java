package com.springboot.webapp.springboot_webapp.controllers.errores;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.springboot.webapp.springboot_webapp.exceptions.ProjectNotFoundException;
import com.springboot.webapp.springboot_webapp.exceptions.TaskNotFoundException;
import com.springboot.webapp.springboot_webapp.exceptions.UserNotFoundException;
import com.springboot.webapp.springboot_webapp.models.dto.error.Error;

@RestControllerAdvice
public class ErrorHadlerExceptionController {
    
    @ExceptionHandler({ ArithmeticException.class})
    public ResponseEntity<Error> divisionByZero(Exception ex){

        Error error= new Error();
        error.setDate(new Date());
        error.setError("Division by zero");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
       
       //return ResponseEntity.internalServerError().body(error);

       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }
    
    //el ? es un comodin que puede ser cualquier tipo de dato
    // @ExceptionHandler({ ArithmeticException.class})
    // public ResponseEntity<?> divisionByZero(Exception ex){

    //     return ResponseEntity.internalServerError().body("error 500");
    // }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> noFound(NoHandlerFoundException ex){
        Error error = new Error();
        error.setDate(new Date());
        error.setError(" Api rest not found");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);

    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(NumberFormatException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("date", new Date().toString());
        response.put("Error:", "Number format exception");
        response.put("Message", ex.getMessage());
        response.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return response;

    }

    @ExceptionHandler({ NullPointerException.class, UserNotFoundException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundException(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("date", new Date().toString());
        response.put("Error:", "El usuario no existe");
        response.put("Message", ex.getMessage());
        response.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return response;

    }

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> taskNotFoundException(TaskNotFoundException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("date", new Date().toString());
        response.put("Error:", "La tarea no existe");
        response.put("Message", ex.getMessage());
        response.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return response;
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<Error> noFound(ProjectNotFoundException ex) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError(" Api rest not found");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);

    }

}
