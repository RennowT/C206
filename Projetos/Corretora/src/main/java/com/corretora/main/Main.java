package com.corretora.main;

import com.corretora.dao.ClienteDAO;
import com.corretora.dao.ImovelDAO;
import com.corretora.model.Cliente;
import com.corretora.model.Endereco;
import com.corretora.model.Imovel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            exibirMenuPrincipal();
            int opcao = obterOpcao(sc);
            sc.nextLine();

            switch (opcao) {
                case 1:
                    exibirTodosOsImoveis();
                    break;

                case 2:
                    anunciarImovel(sc);
                    break;

                case 3:
                    //entrarComoCorretor();
                    break;

                case 4:
                    //exibirSobreNos();
                    break;

                case 5:
                    //exibirContato();
                    break;

                case 6:
                    isRunning = false;
                    System.out.println("Obrigado por usar a Casa Certa. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    break;
            }

        }

        sc.close();
    }

    private static void anunciarImovel(Scanner sc) {
        System.out.println("\n===== Anunciar Imovel =====");

        System.out.print("Digite o seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite seu e-mail: ");
        String email = sc.nextLine();

        System.out.print("Digite seu telefone: ");
        String telefone = sc.nextLine();

        ClienteDAO clienteDAO = new ClienteDAO();
        if (!clienteDAO.verificarCliente(email)) {
            Cliente cliente = new Cliente(nome, email, telefone);
            clienteDAO.inserir(cliente);
        }

        System.out.print("Digite o codigo do imovel: ");
        String codigoImovel = sc.nextLine();

        ImovelDAO imovelDAO = new ImovelDAO();
        if (imovelDAO.verificarImovel(codigoImovel)) {
            System.out.println("Imovel já cadastrado!");
            return;
        }

        System.out.print("Digite o titulo do imovel: ");
        String tituloImovel = sc.nextLine();

        System.out.print("Digite a descrição do imovel: ");
        String descricaoImovel = sc.nextLine();

        System.out.print("Digite o numero de quartos do imovel: ");
        int numeroImovelQuartos = sc.nextInt();

        System.out.print("Digite o numero de banheiros do imovel: ");
        int numeroImovelBanheiros = sc.nextInt();

        System.out.print("Digite o numero de suites do imovel: ");
        int numeroImovelSuites = sc.nextInt();

        System.out.print("Digite o numero de vagas na garagem do imovel: ");
        int numeroImovelVagas = sc.nextInt();

        System.out.print("Digite a area do imovel: ");
        double areaImovel = sc.nextDouble();

        System.out.print("Digite o valor do imovel: ");
        BigDecimal valorImovel = sc.nextBigDecimal();
        sc.nextLine();

        System.out.print("Digite o tipo de imovel: ");
        String tipoImovel = sc.nextLine();

        System.out.print("Digite a finalidade do imovel: ");
        String finalidadeImovel = sc.nextLine();

        System.out.print("Digite o logradouro do imovel: ");
        String logradouroImovel = sc.nextLine();

        System.out.print("Digite o numero do imovel: ");
        String numeroImovel = sc.nextLine();

        System.out.print("Digite o complemento do imovel: ");
        String complemento = sc.nextLine();

        System.out.print("Digite o bairro do imovel: ");
        String bairro = sc.nextLine();

        System.out.print("Digite o cidade do imovel: ");
        String cidade = sc.nextLine();

        System.out.print("Digite o estado do imovel: ");
        String estado = sc.nextLine();

        System.out.print("Digite o cep do imovel: ");
        String cep = sc.nextLine();

        Endereco endereco = new Endereco(
                logradouroImovel,
                numeroImovel,
                complemento,
                bairro,
                cidade,
                estado,
                cep
        );

        List<Cliente> clientes = clienteDAO.selecionarPor("email", email);
        Cliente cliente = clientes.get(0);

        Imovel imovel = new Imovel(
                codigoImovel,
                tituloImovel,
                descricaoImovel,
                numeroImovelQuartos,
                numeroImovelBanheiros,
                numeroImovelSuites,
                numeroImovelVagas,
                areaImovel,
                valorImovel,
                tipoImovel,
                finalidadeImovel,
                endereco,
                cliente.getId()
        );
        imovelDAO.inserir(imovel);
    }

    private static void exibirTodosOsImoveis() {
        System.out.println("===== Todos os Imóveis =====");

        ImovelDAO imovelDAO = new ImovelDAO();
        List<Imovel> imoveis = imovelDAO.selecionarTodos();
        for (Imovel imovel : imoveis) {
            System.out.println(imovel);
        }
    }

    public static void exibirMenuPrincipal() {
        System.out.println("=======================================");
        System.out.println("===== Casa Certa - Menu Principal =====");
        System.out.println("=======================================\n");
        System.out.println("1. Todos os Imóveis");
        System.out.println("2. Anuncie seu Imóvel");
        System.out.println("3. Entrar como Corretor");
        System.out.println("4. Sobre nós");
        System.out.println("5. Contato");
        System.out.println("6. Sair\n");
        System.out.print("Escolha uma opção: ");
    }

    private static int obterOpcao(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor, insira um numero.");
            System.out.print("Escolha uma opção: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
