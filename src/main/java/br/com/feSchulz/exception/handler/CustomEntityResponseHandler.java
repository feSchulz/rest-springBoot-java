package br.com.feSchulz.exception.handler;

import br.com.feSchulz.exception.ExceptionResponse;
import br.com.feSchulz.exception.UnsupportedMathOperationException;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController

public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handeleAllExceptions(Exception ex, WebRequest re){
        ExceptionResponse response = new ExceptionResponse(new Date(),ex.getMessage(), re.getDescription(false));

        return  new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handeleBadRequestExceptions(Exception ex, WebRequest re){
        ExceptionResponse response = new ExceptionResponse(new Date(),ex.getMessage(), re.getDescription(false));

        return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
