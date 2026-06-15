package com.example.digitalLibrarySystem.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobeExceptionHandler {
    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAuthorNotFound(AuthorNotFoundException ex, HttpServletRequest req){
        ErrorResponse errorResponse=new ErrorResponse(
            LocalDateTime.now(),
            404,
            "NOT FOUND",
                ex.getMessage(),
                req.getRequestURL()
        );
        return ResponseEntity.status(404).body(errorResponse);
    }
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBookNotFound(BookNotFoundException ex,HttpServletRequest req){
        ErrorResponse errorResponse=new ErrorResponse(
                LocalDateTime.now(),
                404,
                "NOT FOUND",
                ex.getMessage(),
                req.getRequestURL()
        );
        return ResponseEntity.status(404).body(errorResponse);
    }
}
