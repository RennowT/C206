package com.corretora.model.inputValidator;

import java.math.BigDecimal;
import java.util.Scanner;

public class BigDecimalInput extends InputValidator<BigDecimal> {

    public BigDecimalInput(String request) {
        super(request);
    }

    @Override
    public BigDecimal validateInput(Scanner scanner) {
        while (true) {
            System.out.print("║ ║ ║   " + request );
            String input = scanner.nextLine().trim();
            try {
                BigDecimal value = new BigDecimal(input);
                if (value.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("║ ║ ║   >Por favor, insira um número positivo ou zero.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("║ ║ ║   >Por favor, insira um número válido.");
            }
        }
    }
}
