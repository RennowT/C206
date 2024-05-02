package com.corretora.model.inputValidator;

import java.util.Scanner;

public class OptionValidator extends InputValidator<Integer> {
    private final int minOption;
    private final int maxOption;

    public OptionValidator(String request, int minOption, int maxOption) {
        super(request);
        this.minOption = minOption;
        this.maxOption = maxOption;
    }

    @Override
    public Integer validateInput(Scanner sc) {
        int option;
        do {
            System.out.print("║ ║ ║   Escolha uma opção: ");
            while (!sc.hasNextInt()) {
                System.out.println("║ ║ ║   >Por favor, insira um número.");
                System.out.print("║ ║ ║   Escolha uma opção: ");
                sc.next();
            }
            option = sc.nextInt();
            if (option < minOption || option > maxOption) {
                System.out.println("║ ║ ║   >Por favor, insira uma opção válida.");
            }
        } while (option < minOption || option > maxOption);
        return option;
    }
}
