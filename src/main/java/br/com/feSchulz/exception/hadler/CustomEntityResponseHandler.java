package br.com.feSchulz.exception.hadler;

import br.com.feSchulz.exception.ExceptionResponse;
import br.com.feSchulz.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * @ControllerAdvice indica que esta classe é um componente global
 * responsável por interceptar e tratar exceções lançadas pelos controllers.
 * É um "global exception handler".
 */
@ControllerAdvice

/**
 * @RestController indica que esta classe retorna objetos diretamente no corpo
 * da resposta (JSON), semelhante aos controllers REST.
 * Aqui é usado para garantir que o objeto ExceptionResponse será serializado em JSON.
 */
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    /**
     * @ExceptionHandler(Exception.class)
     * Este método captura TODAS as exceções genéricas que não forem tratadas
     * por handlers mais específicos.
     *
     * Ele devolve:
     * - timestamp
     * - mensagem da exceção
     * - descrição do request
     *
     * E retorna o status 500 (INTERNAL_SERVER_ERROR).
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),                    // Momento da exceção
                ex.getMessage(),               // Mensagem enviada pela exceção
                request.getDescription(false)  // Informações do request
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @ExceptionHandler(ResourceNotFoundException.class)
     * Quando uma ResourceNotFoundException é lançada em qualquer controller,
     * este método é executado e retorna um HTTP 404.
     *
     * É um tratamento personalizado apenas para "registro não encontrado".
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
