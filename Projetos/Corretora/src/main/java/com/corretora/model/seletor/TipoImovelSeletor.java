package com.corretora.model.seletor;

import com.corretora.model.inputValidator.OptionValidator;

import java.util.Scanner;

public class TipoImovelSeletor {
    public static String seletorTipoImovel(Scanner sc) {
        System.out.println("║ ║ ║   Selecione o tipo do imóvel: ");
        System.out.println("║ ║ ║      1. Casa");
        System.out.println("║ ║ ║      2. Apartamento");
        System.out.println("║ ║ ║      3. Kitnet");
        System.out.println("║ ║ ║      4. Sítio");
        System.out.println("║ ║ ║      5. Chácara");
        System.out.println("║ ║ ║      6. Terreno");
        System.out.println("║ ║ ║      7. Lote");
        System.out.println("║ ║ ║   ");

        OptionValidator validator = new OptionValidator("",1, 7);
        int option = validator.validateInput(sc);

        return switch (option) {
            case 1 -> "Casa";
            case 2 -> "Apartamento";
            case 3 -> "Kitnet";
            case 4 -> "Sítio";
            case 5 -> "Chácara";
            case 6 -> "Terreno";
            default -> "Lote";
        };
    }
}
