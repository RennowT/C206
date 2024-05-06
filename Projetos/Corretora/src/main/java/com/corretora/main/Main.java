package com.corretora.main;

import com.corretora.dao.usuario.ClienteDAO;
import com.corretora.dao.usuario.CorretorDAO;
import com.corretora.dao.ImovelDAO;
import com.corretora.model.user.Cliente;
import com.corretora.model.user.Corretor;
import com.corretora.model.imovel.Endereco;
import com.corretora.model.Imovel;
import com.corretora.model.SHA;
import com.corretora.model.inputValidator.*;
import com.corretora.model.seletor.EstadoSeletor;
import com.corretora.model.seletor.FinalidadeSeletor;
import com.corretora.model.seletor.TipoImovelSeletor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║                          Casa Certa - Menu Principal                           ║");
            System.out.println("╠════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║   1. Todos os Imóveis");
            System.out.println("║   2. Anuncie seu Imóvel");
            System.out.println("║   3. Entrar como Corretor");
            System.out.println("║   4. Sobre nós");
            System.out.println("║   5. Contato");
            System.out.println("║   6. Sair\n║");
            System.out.print("║   Escolha uma opção: ");
            int opcao = obterOpcao(sc, "║   ");
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("║ ║ ╔════════════════════════════════════════════════════════════════════════╗");
                    System.out.println("║ ║ ║                      Casa Certa - Todos os Imáveis                     ║");
                    System.out.println("║ ║ ╠════════════════════════════════════════════════════════════════════════╣");

                    ImovelDAO imovelDAO = new ImovelDAO();
                    List<Imovel> listaImoveis = imovelDAO.selecionarTodos();
                    for (Imovel imovel : listaImoveis) {
                        System.out.println(imovel);
                    }

                    System.out.println("║ ║ ╚════════════════════════════════════════════════════════════════════════╝");
                    break;

                case 2:
                    anunciarImovel(sc);
                    break;

                case 3:
                    entrarComoCorretor(sc);
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    isRunning = false;
                    System.out.println("║\n║   Obrigado por usar a Casa Certa. Até logo!");
                    System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
                    break;

                default:
                    System.out.println("║   Opção inválida. Por favor, escolha novamente.");
                    break;
            }

        }

        sc.close();
    }

    private static void entrarComoCorretor(Scanner sc) {
        boolean voltar = false;

        System.out.println("║");
        System.out.println("║ ╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║ ║                        Casa Certa - Área do Corretor                       ║");
        System.out.println("║ ╠════════════════════════════════════════════════════════════════════════════╣");

        while (!voltar) {
            exibirSubMenuLoginCadastro();
            int opcao = obterOpcao(sc, "║ ║   ");
            System.out.println("║ ║");

            switch (opcao) {
                case 1:
                    System.out.println("║ ║ ╔════════════════════════════════════════════════════════════════════════╗");
                    System.out.println("║ ║ ║                                  Login                                 ║");
                    System.out.println("║ ║ ╠════════════════════════════════════════════════════════════════════════╣");
                    loginCorretor(sc);
                    System.out.println("║ ║ ╚════════════════════════════════════════════════════════════════════════╝");
                    break;

                case 2:
                    System.out.println("║ ║ ╔════════════════════════════════════════════════════════════════════════╗");
                    System.out.println("║ ║ ║                              Cadastrar-se                              ║");
                    System.out.println("║ ║ ╠════════════════════════════════════════════════════════════════════════╣");
                    registrarNovoCorretor(sc);
                    System.out.println("║ ║ ╚════════════════════════════════════════════════════════════════════════╝");
                    break;

                case 3:
                    voltar = true;
                    System.out.println("║ ╚════════════════════════════════════════════════════════════════════════════╝");
                    break;

                default:
                    System.out.println("║ ║   Opção inválida. Por favor, escolha novamente.");
                    break;
            }
        }
    }

    private static void registrarNovoCorretor(Scanner sc) {
        sc.nextLine();

        String request = "CRECI (máximo de 20 caracteres): ";
        String creci = maxLengthValidator(sc, request, 20);

        String nomeCorretor = obterNome(sc);
        String cpf = obterCpf(sc);
        String telefone = obterTelefone(sc);
        String email = obterEmail(sc);
        String senha = obterSenha(sc);

        String hashUsuario = gerarHashUsuario(email, senha);
        Corretor corretor = new Corretor(creci, cpf, nomeCorretor, telefone, email, hashUsuario);

        if (corretor.verificarCRECI(creci)) {
            System.out.println("║ ║ ║   >CRECI já cadastrado. Faça login ou entre em contato.");
            return;
        } else if (corretor.verificarEmailCadastrado(email)) {
            System.out.println("║ ║ ║   >Corretor já cadastrato. Faça login ou cadastre-se com um novo e-mail.");
            return;
        }

        if (corretor.inserir()) {
            System.out.println("║ ║ ║   Corretor cadastrado com sucesso.");
            return;
        }

        System.out.println("║ ║ ║   Erro ao cadastrar corretor.");
    }

    private static String obterCpf(Scanner sc) {
        RegexValidator validator = new RegexValidator(
                "Insira seu CPF (formato XXX.XXX.XXX-XX): ",
                "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}",
                "CPF inválido. Por favor, insira um CPF válido."
        );
        return validator.validateInput(sc);
    }

    private static void loginCorretor(Scanner sc) {
        sc.nextLine();
        String email = obterEmail(sc);
        String senha = obterSenha(sc);
        String hashUsuario = gerarHashUsuario(email, senha);

        CorretorDAO corretorDAO = new CorretorDAO();
        List<Corretor> corretores = corretorDAO.selecionarPor("hashUsuario", hashUsuario);
        if (corretores == null || corretores.isEmpty()) {
            System.out.println("║ ║ ║   >E-mail ou Senha inválidos.");
            return;
        }
        Corretor corretor = corretores.get(0);

        System.out.println("║ ║ ║\n║ ║ ║   Login realizado com sucesso.\n║ ║ ║");

        imoveisSendoExibidos(sc);
        imoveisNaoSendoExibidos(sc);
        modificarEstadoDeExibicao(sc);
    }

    private static void modificarEstadoDeExibicao(Scanner sc) {
        System.out.println("║ ║ ║   Deseja modificar o estado de exibição de algum imóvel?");
        System.out.println("║ ║ ║   1. Sim");
        System.out.println("║ ║ ║   2. Não");
        int opcao = obterOpcao(sc, "║ ║   ");

        if (opcao == 2) {
            return;
        }

        int codigoImovel = obterCodigoImovel(sc);

        ImovelDAO imovelDAO = new ImovelDAO();
        if (imovelDAO.verificarImovel(codigoImovel)) {

        }

    }

    private static int obterCodigoImovel(Scanner sc) {
        IntegerInput integerInput = new IntegerInput("Insira o código do imóvel: ");
        return integerInput.validateInput(sc);
    }

    private static void imoveisNaoSendoExibidos(Scanner sc) {
        System.out.println("║ ║ ╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║ ║ ║                       Imóveis Não Sendo Exibidos                       ║");
        System.out.println("║ ║ ╠════════════════════════════════════════════════════════════════════════╣");

        ImovelDAO imovelDAO = new ImovelDAO();
        List<Imovel> listaImoveis = imovelDAO.selecionarPor("exibir", "FALSE");
        for (Imovel imovel : listaImoveis) {
            System.out.println(imovel);
        }
    }

    private static void imoveisSendoExibidos(Scanner sc) {
        System.out.println("║ ║ ╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║ ║ ║                         Imóveis Sendo Exibidos                         ║");
        System.out.println("║ ║ ╠════════════════════════════════════════════════════════════════════════╣");

        ImovelDAO imovelDAO = new ImovelDAO();
        List<Imovel> listaImoveis = imovelDAO.selecionarPor("exibir", "TRUE");
        for (Imovel imovel : listaImoveis) {
            System.out.println(imovel);
        }
    }

    private static void exibirSubMenuLoginCadastro() {
        System.out.println("║ ║   1. Fazer Login");
        System.out.println("║ ║   2. Cadastrar-se");
        System.out.println("║ ║   3. Voltar\n║ ║");
        System.out.print("║ ║   Escolha uma opção: ");
    }

    private static void anunciarImovel(Scanner sc) {
        boolean voltar = false;

        System.out.println("║");
        System.out.println("║ ╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║ ║                        Casa Certa - Anunciar Imóvel                        ║");
        System.out.println("║ ╠════════════════════════════════════════════════════════════════════════════╣");

        while (!voltar) {
            exibirSubMenuLoginCadastro();
            int opcao = obterOpcao(sc, "║ ║   ");
            System.out.println("║ ║");

            switch (opcao) {
                case 1:
                    System.out.println("║ ║ ╔════════════════════════════════════════════════════════════════════════╗");
                    System.out.println("║ ║ ║                                  Login                                 ║");
                    System.out.println("║ ║ ╠════════════════════════════════════════════════════════════════════════╣");
                    loginCliente(sc);
                    System.out.println("║ ║ ╚════════════════════════════════════════════════════════════════════════╝");
                    break;

                case 2:
                    System.out.println("║ ║ ╔════════════════════════════════════════════════════════════════════════╗");
                    System.out.println("║ ║ ║                              Cadastrar-se                              ║");
                    System.out.println("║ ║ ╠════════════════════════════════════════════════════════════════════════╣");
                    registrarNovoCliente(sc);
                    System.out.println("║ ║ ╚════════════════════════════════════════════════════════════════════════╝");
                    break;

                case 3:
                    voltar = true;
                    System.out.println("║ ╚════════════════════════════════════════════════════════════════════════════╝");
                    break;

                default:
                    System.out.println("║ ║   Opção inválida. Por favor, escolha novamente.");
                    break;
            }
        }
    }

    private static void registrarNovoCliente(Scanner sc) {
        String nome = obterNome(sc);
        String email = obterEmail(sc);
        String senha = obterSenha(sc);
        String hashUsuario = gerarHashUsuario(email, senha);
        String telefone = obterTelefone(sc);

        Cliente cliente = new Cliente(nome, email, hashUsuario, telefone);
        if (cliente.verificarEmailCadastrado(email)) {
            System.out.println("║ ║ ║   >Usuário já cadastrato. Faça login ou cadastre-se com um novo e-mail.");
            return;
        }

        System.out.println("║ ║ ║   Usuário cadastrado com sucesso.");
    }

    private static String obterTelefone(Scanner sc) {
        String request = "Insira seu Telefone (formato +XX (XX) 9XXXX-XXXX): ";
        String regex = "^\\+\\d{2}\\s\\(\\d{2}\\)\\s9\\d{4}-\\d{4}$";
        String errorMessage = "Telefone inválido. Por favor, insira um telefone válido.";
        return regexValidator(sc, request, regex, errorMessage);
    }

    private static String obterSenha(Scanner sc) {
        System.out.print("║ ║ ║   Insira a Senha: ");
        return sc.nextLine().trim();
    }

    private static String obterEmail(Scanner sc) {
        String request = "Insira seu E-mail: ";
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String errorMessage = "E-mail inválido. Por favor, insira um e-mail válido.";
        return regexValidator(sc, request, regex, errorMessage);
    }

    private static String obterNome(Scanner sc) {
        String request = "Insira seu Nome e Sobrenome: ";
        return maxLengthValidator(sc, request, 100);
    }

    private static String gerarHashUsuario(String emailCliente, String senhaCliente) {
        String hashSenha = SHA.SHA1(senhaCliente);
        return SHA.SHA256(emailCliente + hashSenha);
    }

    private static void loginCliente(Scanner sc) {
        sc.nextLine();
        String emailCliente = obterEmail(sc);
        String senhaCliente = obterSenha(sc);
        String hashUsuario = gerarHashUsuario(emailCliente, senhaCliente);

        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> clientes = clienteDAO.selecionarPor("hashUsuario", hashUsuario);
        if (clientes == null || clientes.isEmpty()) {
            System.out.println("║ ║ ║   >E-mail ou Senha inválidos.");
            return;
        }
        Cliente cliente = clientes.get(0);

        System.out.println("║ ║ ║\n║ ║ ║   Login realizado com sucesso.\n║ ║ ║");

        cadastrarImovel(sc, cliente);
    }

    private static void cadastrarImovel(Scanner sc, Cliente cliente) {
        String requestTitulo = "Titulo a ser exibido (máximo de 100 caracteres): ";
        String tituloImovel = maxLengthValidator(sc, requestTitulo, 100);

        String descricaoImovel = obterDescricaoImovel(sc);
        int numeroDeQuartosImovel = obterNumeroDeQuartos(sc);
        int numeroDeBanheirosImovel = obterNumeroDeBanheiros(sc);
        int numeroDeSuitesImoveis = obterNumeroDeSuites(sc);
        int numeroDeVagasNaGaragemImovel = obterNumeroDeVagasNaGaragem(sc);
        double areaImovel = obterAreaImovel(sc);
        BigDecimal valorImovel = obterValorImovel(sc);
        String tipoImovel = TipoImovelSeletor.seletorTipoImovel(sc);
        String finalidadeImovel = FinalidadeSeletor.seletorFinalidade(sc);
        sc.nextLine();
        Endereco enderecoImovel = obterEnderecoImovel(sc);

        Imovel imovel = new Imovel(
                tituloImovel,
                descricaoImovel,
                numeroDeQuartosImovel,
                numeroDeBanheirosImovel,
                numeroDeSuitesImoveis,
                numeroDeVagasNaGaragemImovel,
                areaImovel,
                valorImovel,
                tipoImovel,
                finalidadeImovel,
                enderecoImovel,
                cliente.getId()
        );

        ImovelDAO imovelDAO = new ImovelDAO();
        if (imovelDAO.inserir(imovel)) {
            System.out.println("║ ║ ║   Imóvel cadastrado com sucesso.\n║ ║ ║");
            return;
        }

        System.out.println("║ ║ ║   Não foi possível cadastrar o imóvel. Tente novamente.\n║ ║ ║");
    }

    private static Endereco obterEnderecoImovel(Scanner sc) {
        String requestLogradouro = "Logradouro (máximo de 100 caracteres): ";
        String logradouro = maxLengthValidator(sc, requestLogradouro, 100);

        String requestNumero = "Número do imóvel (máximo de 4 caracteres): ";
        String numeroImovel = maxLengthValidator(sc, requestNumero, 4);

        String requestBairro = "Bairro (máximo de 50 caracteres): ";
        String bairro = maxLengthValidator(sc, requestBairro, 50);

        String requestComplemento = "Complemento (máximo de 100 caracteres): ";
        String complemento = maxLengthValidator(sc, requestComplemento, 100);

        String requestCidade = "Cidade (máximo de 50 caracteres): ";
        String cidade = maxLengthValidator(sc, requestCidade, 50);

        String estado = EstadoSeletor.selecionarEstado(sc);

        String requestCep = "CEP (formato XXXXX-XX): ";
        String regexCep = "\\d{5}-\\d{3}";
        String errorMessageCep = "CEP inválido. Por favor, insira um CEP válido.";
        String cep = regexValidator(sc, requestCep, regexCep, errorMessageCep);

        return new Endereco(logradouro, numeroImovel, complemento, bairro, cidade, estado, cep);
    }

    private static String maxLengthValidator(Scanner sc, String request, int maxLength) {
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

    private static String regexValidator(Scanner sc, String request, String regex, String errorMessage) {
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

    private static BigDecimal obterValorImovel(Scanner sc) {
        BigDecimalInput bigDecimalInput = new BigDecimalInput("Valor do imóvel: ");
        return bigDecimalInput.validateInput(sc);
    }

    private static double obterAreaImovel(Scanner sc) {
        DoubleInput doubleInput = new DoubleInput("Area do imóvel: ");
        return doubleInput.validateInput(sc);
    }

    private static int obterNumeroDeVagasNaGaragem(Scanner sc) {
        IntegerInput integerInput = new IntegerInput("Número de vagas na garagem: ");
        return integerInput.validateInput(sc);
    }

    private static int obterNumeroDeSuites(Scanner sc) {
        IntegerInput integerInput = new IntegerInput("Número de suítes no imóvel: ");
        return integerInput.validateInput(sc);
    }

    private static int obterNumeroDeBanheiros(Scanner sc) {
        IntegerInput integerInput = new IntegerInput("Número de banheiros no imóvel: ");
        return integerInput.validateInput(sc);
    }

    private static int obterNumeroDeQuartos(Scanner sc) {
        IntegerInput inputValidator = new IntegerInput("Número de quartos no imóvel: ");
        return inputValidator.validateInput(sc);
    }

    private static String obterDescricaoImovel(Scanner sc) {
        String descricaoImovel;
        do {
            System.out.print("║ ║ ║   Descrição do imóvel (máximo de 5000 caracteres): ");
            descricaoImovel = sc.nextLine().trim();
            if (descricaoImovel.length() > 5000) {
                System.out.println("║ ║ ║   >Número de caracteres excedido.");
            }
        } while (descricaoImovel.length() > 5000);

        return descricaoImovel;
    }

    private static int obterOpcao(Scanner sc, String nivel) {
        while (!sc.hasNextInt()) {
            System.out.println(nivel + ">Por favor, insira um numero.");
            System.out.print(nivel + "Escolha uma opção: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
