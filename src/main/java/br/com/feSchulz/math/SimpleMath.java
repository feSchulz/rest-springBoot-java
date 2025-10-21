package br.com.feSchulz.math;

import br.com.feSchulz.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class SimpleMath {


    public Double sum( Double number1,  Double number2 ) {

        return (number1) + (number2);
    }

    // SUBTRAÇÃO
    public Double subtract( Double number1, Double number2 ) {

        return (number1) - (number2);
    }

    // MULTIPLICAÇÃO
    public Double multiply( Double number1, Double number2 ) {

        return (number1) * (number2);
    }

    // DIVISÃO
    public Double divide( Double number1, Double number2 ) {

        Double divisor = number2;
        if (divisor == 0) {
            throw new UnsupportedMathOperationException("Divisão por zero não é permitida!");
        }
        return number1 / divisor;
    }

    // MÉDIA
    public Double average( Double number1, Double number2 ) {

        return ((number1) + (number2)) / 2;
    }

    //RAIZ QUADRADA
    public Double sqrt(Double value) {

        return Math.sqrt(value);
    }
}
