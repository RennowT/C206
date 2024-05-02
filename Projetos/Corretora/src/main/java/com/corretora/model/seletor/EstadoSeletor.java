package com.corretora.model.seletor;

import com.corretora.model.inputValidator.OptionValidator;

import java.util.Scanner;

public class EstadoSeletor {
    public static String selecionarEstado(Scanner sc) {
        System.out.println("║ ║ ║   Selecione o estado do imóvel: ");
        System.out.println("║ ║ ║      1. Acre");
        System.out.println("║ ║ ║      2. Alagoas");
        System.out.println("║ ║ ║      3. Amapá");
        System.out.println("║ ║ ║      4. Amazonas");
        System.out.println("║ ║ ║      5. Bahia");
        System.out.println("║ ║ ║      6. Ceará");
        System.out.println("║ ║ ║      7. Distrito Federal");
        System.out.println("║ ║ ║      8. Espírito Santo");
        System.out.println("║ ║ ║      9. Goias");
        System.out.println("║ ║ ║      10. Maranhão");
        System.out.println("║ ║ ║      11. Mato Grosso");
        System.out.println("║ ║ ║      12. Mato Grosso do Sul");
        System.out.println("║ ║ ║      13. Minas Gerais");
        System.out.println("║ ║ ║      14. Pará");
        System.out.println("║ ║ ║      15. Paraíba");
        System.out.println("║ ║ ║      16. Paraná");
        System.out.println("║ ║ ║      17. Pernambuco");
        System.out.println("║ ║ ║      18. Piauí");
        System.out.println("║ ║ ║      19. Rio de Janeiro");
        System.out.println("║ ║ ║      20. Rio Grande do Norte");
        System.out.println("║ ║ ║      21. Rio Grande do Sul");
        System.out.println("║ ║ ║      22. Rondônia");
        System.out.println("║ ║ ║      23. Roraima");
        System.out.println("║ ║ ║      24. Santa Catarina");
        System.out.println("║ ║ ║      25. São Paulo");
        System.out.println("║ ║ ║      26. Sergipe");
        System.out.println("║ ║ ║      27. Tocantins");
        System.out.println("║ ║ ║   ");

        OptionValidator validator = new OptionValidator("", 1, 27);
        int option = validator.validateInput(sc);

        return switch (option) {
            case 1 -> "AC";
            case 2 -> "AL";
            case 3 -> "AP";
            case 4 -> "AM";
            case 5 -> "BA";
            case 6 -> "CE";
            case 7 -> "DF";
            case 8 -> "ES";
            case 9 -> "GO";
            case 10 -> "MA";
            case 11 -> "MT";
            case 12 -> "MS";
            case 13 -> "MG";
            case 14 -> "PA";
            case 15 -> "PB";
            case 16 -> "PR";
            case 17 -> "PE";
            case 18 -> "PI";
            case 19 -> "RJ";
            case 20 -> "RN";
            case 21 -> "RS";
            case 22 -> "RO";
            case 23 -> "RR";
            case 24 -> "SC";
            case 25 -> "SP";
            case 26 -> "SE";
            default -> "TO";
        };
    }
}
