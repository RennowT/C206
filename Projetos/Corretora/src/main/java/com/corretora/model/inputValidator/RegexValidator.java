package com.corretora.model.inputValidator;

import java.util.Scanner;

public class RegexValidator extends InputValidator<String> {
    private final String regex;
    private final String errorMessage;

    public RegexValidator(String request, String regex, String errorMessage) {
        super(request);
        this.regex = regex;
        this.errorMessage = errorMessage;
    }

    @Override
    public String validateInput(Scanner sc) {
        String input;
        do {
            System.out.print("║ ║ ║   " + request);
            input = sc.nextLine().trim();
            if (!input.matches(regex)) {
                System.out.println("║ ║ ║   >" + errorMessage);
            }
        } while (!input.matches(regex));

        return input;
    }
}
