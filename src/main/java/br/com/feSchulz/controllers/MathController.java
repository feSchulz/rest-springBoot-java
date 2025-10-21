package br.com.feSchulz.controllers;

import br.com.feSchulz.exception.UnsupportedMathOperationException;
import br.com.feSchulz.math.SimpleMath;
import br.com.feSchulz.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador responsável por operações matemáticas simples.
 * Compatível com Java 21 e Spring Boot 3.4.10.
 */
@RestController
@RequestMapping("/math")
public class MathController {

    SimpleMath math = new SimpleMath();

    // SOMA
    @GetMapping("/sum/{number1}/{number2}")
    public Double sum(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2
    ) {
        NumberConverter.validateNumbers(number1, number2);
        return math.sum(NumberConverter.convertToDouble(number1) , NumberConverter.convertToDouble(number2));
    }

    // SUBTRAÇÃO
    @GetMapping("/sub/{number1}/{number2}")
    public Double subtract(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2
    ) {
        NumberConverter.validateNumbers(number1, number2);
        return math.subtract(NumberConverter.convertToDouble(number1) , NumberConverter.convertToDouble(number2));
    }

    // MULTIPLICAÇÃO
    @GetMapping("/mult/{number1}/{number2}")
    public Double multiply(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2
    ) {
        NumberConverter.validateNumbers(number1, number2);
        return math.multiply(NumberConverter.convertToDouble(number1), NumberConverter.convertToDouble(number2));
    }

    // DIVISÃO
    @GetMapping("/div/{number1}/{number2}")
    public Double divide(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2
    ) {
        NumberConverter.validateNumbers(number1, number2);
        Double divisor = NumberConverter.convertToDouble(number2);
        if (divisor == 0) {
            throw new UnsupportedMathOperationException("Divisão por zero não é permitida!");
        }
        return math.divide(NumberConverter.convertToDouble(number1), divisor);
    }

    // MÉDIA
    @GetMapping("/avg/{number1}/{number2}")
    public Double average(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2
    ) {
        NumberConverter.validateNumbers(number1, number2);
        return math.average(NumberConverter.convertToDouble(number1), NumberConverter.convertToDouble(number2));
    }

    //RAIZ QUADRADA
    @GetMapping("/sqrt/{number}")
    public Double sqrt(@PathVariable("number") String number) {
        if (!NumberConverter.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Apenas valores numéricos são permitidos!");
        }
        Double value = NumberConverter.convertToDouble(number);
        if (value < 0) {
            throw new UnsupportedMathOperationException("Não é possível calcular a raiz quadrada de número negativo!");
        }
        return math.sqrt(value);
    }

}
