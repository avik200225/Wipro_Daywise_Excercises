package com.wipro.productms.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleNotFound(EntityNotFoundException ex) {
        Map<String, Object> m = new HashMap<>();
        m.put("error", "NOT_FOUND");
        m.put("message", ex.getMessage());
        return m;
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class, ConstraintViolationException.class, IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleBadRequest(Exception ex) {
        Map<String, Object> m = new HashMap<>();
        m.put("error", "BAD_REQUEST");
        m.put("message", ex.getMessage());
        return m;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleOther(Exception ex) {
        Map<String, Object> m = new HashMap<>();
        m.put("error", "INTERNAL_ERROR");
        m.put("message", ex.getMessage());
        return m;
    }
}
