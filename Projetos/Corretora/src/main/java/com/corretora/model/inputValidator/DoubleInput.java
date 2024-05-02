package com.corretora.model.inputValidator;

import java.util.Scanner;

public class DoubleInput extends InputValidator<Double> {
    public DoubleInput(String request) {
        super(request);
    }

    @Override
    public Double validateInput(Scanner sc) {
        while (true) {
            System.out.print("║ ║ ║   " + request);
            String input = sc.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
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
