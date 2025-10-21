package br.com.feSchulz.request.converters;

import br.com.feSchulz.exception.UnsupportedMathOperationException;

public class NumberConverter {


    public static Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isBlank()) {
            throw new UnsupportedMathOperationException("Valor nulo ou vazio!");
        }
        String number = strNumber.replace(",", ".");
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new UnsupportedMathOperationException("Valor inválido: " + strNumber);
        }
    }

    // Validação numérica
    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isBlank()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static void validateNumbers(String... numbers) {
        for (String num : numbers) {
            if (!isNumeric(num)) {
                throw new UnsupportedMathOperationException("Apenas valores numéricos são permitidos!");
            }
        }
    }
}
