package com.corretora.model.inputValidator;

import java.util.Scanner;

public class IntegerInput extends InputValidator<Integer> {
    public IntegerInput(String request) {
        super(request);
    }

    @Override
    public Integer validateInput(Scanner scanner) {
        while (true) {
            System.out.print("║ ║ ║   " + request);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value < 0) {
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
