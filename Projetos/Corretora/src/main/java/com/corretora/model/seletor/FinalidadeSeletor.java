package com.corretora.model.seletor;

import com.corretora.model.inputValidator.OptionValidator;

import java.util.Scanner;

public class FinalidadeSeletor {
    public static String seletorFinalidade(Scanner sc) {
        System.out.println("║ ║ ║   Selecione a finalidade do imóvel: ");
        System.out.println("║ ║ ║      1. Venda");
        System.out.println("║ ║ ║      2. Aluguel");
        System.out.println("║ ║ ║   ");

        OptionValidator validator = new OptionValidator("",1, 2);
        int option = validator.validateInput(sc);

        return option == 1 ? "Venda" : "Aluguel";
    }
}
