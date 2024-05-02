package com.corretora.model.inputValidator;

import java.util.Scanner;

public class MaxLengthValidator extends InputValidator<String> {
    private final int maxLength;

    public MaxLengthValidator(String request, int maxLength) {
        super(request);
        this.maxLength = maxLength;
    }

    @Override
    public String validateInput(Scanner sc) {
        String input;
        do{
            System.out.print("║ ║ ║   " + request);
            input = sc.nextLine().trim();
            if (input.length() > maxLength) {
                System.out.println("║ ║ ║   >Número de caracteres excedido.");
            }
        } while (input.length() > maxLength);
        return input;
    }
}
