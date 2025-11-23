package br.com.feSchulz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ResponseStatus(HttpStatus.NOT_FOUND)
 *
 * Esta anotação diz ao Spring que, quando esta exceção for lançada,
 * a resposta HTTP deve automaticamente ter o status 404 (NOT FOUND).
 *
 * Ou seja: mesmo que você não trate essa exceção manualmente,
 * o Spring já retorna HTTP 404 ao cliente.
 *
 * Ela transforma essa exceção em uma "exceção REST amigável".
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Construtor que recebe uma mensagem personalizada,
     * que será enviada como detalhe do erro.
     *
     * A chamada "super(message)" envia essa mensagem para a classe mãe (RuntimeException),
     * que armazena esse texto para ser usado depois na resposta de erro.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
