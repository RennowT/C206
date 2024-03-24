import models.cliente.Cliente;
import models.computador.Computador;
import models.computador.MemoriaUSB;
import models.computador.SistemaOperacional;
import models.computador.hardwareBasico.HD;
import models.computador.hardwareBasico.HardwareBasico;
import models.computador.hardwareBasico.MemoriaRAM;
import models.computador.hardwareBasico.Processador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("CPF: ");
        long cpfCliente = scanner.nextLong();

        Cliente cliente = new Cliente(nomeCliente, cpfCliente);
        Computador[] computador = new Computador[100];

        int selecao;

        do {
            System.out.println("\n1 - Promoção 1!");
            System.out.println("2 - Promoção 2!");
            System.out.println("3 - Promoção 3!");
            System.out.println("0 - Finalizar e pagar!");
            System.out.print(">>> ");
            selecao = scanner.nextInt();

            switch (selecao) {
                case 1:
                    for (int i = 0; i < computador.length; i++) {
                        if (computador[i] == null) {
                            HardwareBasico[] hardwareBasicos = new HardwareBasico[3];
                            hardwareBasicos[0] = new Processador("Pentium Core i3", 2200);
                            hardwareBasicos[1] = new MemoriaRAM("Memória RAM", 8);
                            hardwareBasicos[2] = new HD("HD", 500);

                            SistemaOperacional sistemaOperacional = new SistemaOperacional("Linux Ubuntu", 32);

                            MemoriaUSB memoriaUSB = new MemoriaUSB("Pen-drive", 32);

                            computador[i] = new Computador("Positivo", 3300.00f, hardwareBasicos, sistemaOperacional, memoriaUSB);
                            System.out.println("Promoção 1 adicionado no carrinho!");
                            break;
                        }
                    }
                    break;

                case 2:
                    for (int i = 0; i < computador.length; i++) {
                        if (computador[i] == null) {
                            HardwareBasico[] hardwareBasicos = new HardwareBasico[3];
                            hardwareBasicos[0] = new Processador("Pentium Core i5", 3370);
                            hardwareBasicos[1] = new MemoriaRAM("Memória RAM", 16);
                            hardwareBasicos[2] = new HD("HD", 1000);

                            SistemaOperacional sistemaOperacional = new SistemaOperacional("Windows 8", 64);

                            MemoriaUSB memoriaUSB = new MemoriaUSB("Pen-drive", 32);

                            computador[i] = new Computador("Acer", 8800.00f, hardwareBasicos, sistemaOperacional, memoriaUSB);
                            System.out.println("Promoção 2 adicionado no carrinho!");
                            break;
                        }
                    }
                    break;

                case 3:
                    for (int i = 0; i < computador.length; i++) {
                        if (computador[i] == null) {
                            HardwareBasico[] hardwareBasicos = new HardwareBasico[3];
                            hardwareBasicos[0] = new Processador("Pentium Core i7", 4500);
                            hardwareBasicos[1] = new MemoriaRAM("Memória RAM", 32);
                            hardwareBasicos[2] = new HD("HD", 2000);

                            SistemaOperacional sistemaOperacional = new SistemaOperacional("Windows 10", 64);

                            MemoriaUSB memoriaUSB = new MemoriaUSB("HD Externo", 1000);

                            computador[i] = new Computador("Vaio", 4800.00f, hardwareBasicos, sistemaOperacional, memoriaUSB);
                            System.out.println("Promoção 3 adicionado no carrinho!");
                            break;
                        }
                    }
                    break;

                default:
                    break;
            }

        } while (selecao != 0);

        System.out.println("\n\nCompra realizada por " + cliente.getNome() + " proprietário do CPF " + cliente.getCpf());
        System.out.println("Itens: ");

        for (int i = 0; i < computador.length; i++) {
            if (computador[i] != null) {
                System.out.println(computador[i].mostraPCConfigs());
            }
        }

        System.out.println("O valor total a se pagar é de: R$" + formatarValor(cliente.calculaTotalCompra(computador)));

    }

    private static String formatarValor(double valor) {
        return String.format("%.2f", valor);
    }

}