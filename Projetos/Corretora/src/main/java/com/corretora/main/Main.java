package com.corretora.main;

import com.corretora.dao.ClienteDAO;
import com.corretora.dao.CorretorDAO;
import com.corretora.dao.ImovelDAO;
import com.corretora.model.Cliente;
import com.corretora.model.Corretor;
import com.corretora.model.Endereco.Endereco;
import com.corretora.model.imovel.Imovel;
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
        String creci = obterCreci(sc);
        String nomeCorretor = obterNome(sc);
        String cpf = obterCpf(sc);
        String telefone = obterTelefone(sc);
        String email = obterEmail(sc);
        String senha = obterSenha(sc);

        CorretorDAO corretorDAO = new CorretorDAO();
        if (corretorDAO.verificarCreciCadastrado(creci)) {
            System.out.println("║ ║ ║   >CRECI já cadastrado. Faça login ou entre em contato.");
            return;
        } else if (corretorDAO.verificarEmailCadastrado(email)) {
            System.out.println("║ ║ ║   >Corretor já cadastrato. Faça login ou cadastre-se com um novo e-mail.");
            return;
        }

        String hashUsuario = gerarHashUsuario(email, senha);
        Corretor corretor = new Corretor(creci, cpf, nomeCorretor, telefone, email, hashUsuario);

        if (corretorDAO.inserir(corretor)) {
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

    private static String obterCreci(Scanner sc) {
        MaxLengthValidator validator = new MaxLengthValidator("CRECI (máximo de 20 caracteres): ", 20);
        return validator.validateInput(sc);
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
        String nomeCliente = obterNome(sc);
        String emailCliente = obterEmail(sc);
        String senhaCliente = obterSenha(sc);
        String telefoneCliente = obterTelefone(sc);

        ClienteDAO clienteDAO = new ClienteDAO();
        if (clienteDAO.verificarEmailCadastrado(emailCliente)) {
            System.out.println("║ ║ ║   >Usuário já cadastrato. Faça login ou cadastre-se com um novo e-mail.");
            return;
        }

        String hashUsuario = gerarHashUsuario(emailCliente, senhaCliente);

        Cliente cliente = new Cliente(nomeCliente, emailCliente, hashUsuario, telefoneCliente);
        clienteDAO.inserir(cliente);

        System.out.println("║ ║ ║   Usuário cadastrado com sucesso.");
    }

    private static String obterTelefone(Scanner sc) {
        RegexValidator regexValidator = new RegexValidator(
                "Insira seu Telefone (formato +XX (XX) 9XXXX-XXXX): ",
                "^\\+\\d{2}\\s\\(\\d{2}\\)\\s9\\d{4}-\\d{4}$",
                "Telefone inválido. Por favor, insira um telefone válido."
        );
        return regexValidator.validateInput(sc);
    }

    private static String obterSenha(Scanner sc) {
        System.out.print("║ ║ ║   Insira a Senha: ");
        return sc.nextLine().trim();
    }

    private static String obterEmail(Scanner sc) {
        RegexValidator regexValidator = new RegexValidator(
                "Insira seu E-mail: ",
                "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
                "E-mail inválido. Por favor, insira um e-mail válido."
        );
        return regexValidator.validateInput(sc);
    }

    private static String obterNome(Scanner sc) {
        MaxLengthValidator validator = new MaxLengthValidator("Insira seu Nome e Sobrenome: ", 100);
        return validator.validateInput(sc);
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
        String tituloImovel = obterTituloImovel(sc);
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
        String logradouro = obterLogradouroImovel(sc);
        String numeroImovel = obterNumeroImovel(sc);
        String complemento = obterComplementoEndereco(sc);
        String bairro = obterBairroImovel(sc);
        String cidade = obterCidadeImovel(sc);
        String estado = EstadoSeletor.selecionarEstado(sc);
        String cep = obterCepImovel(sc);

        return new Endereco(logradouro, numeroImovel, complemento, bairro, cidade, estado, cep);
    }

    private static String obterCepImovel(Scanner sc) {
        RegexValidator regexValidator = new RegexValidator(
                "CEP (formato XXXXX-XX): ",
                "\\d{5}-\\d{3}",
                "CEP inválido. Por favor, insira um CEP válido."
        );
        return regexValidator.validateInput(sc);
    }

    private static String obterCidadeImovel(Scanner sc) {
        MaxLengthValidator validator = new MaxLengthValidator(
                "Cidade (máximo de 50 caracteres): ",
                50
        );
        return validator.validateInput(sc);
    }

    private static String obterBairroImovel(Scanner sc) {
        MaxLengthValidator validator = new MaxLengthValidator(
                "Bairro (máximo de 50 caracteres): ",
                50
        );
        return validator.validateInput(sc);
    }

    private static String obterComplementoEndereco(Scanner sc) {
        MaxLengthValidator validator = new MaxLengthValidator(
                "Complemento (máximo de 100 caracteres): ",
                100
        );
        return validator.validateInput(sc);
    }

    private static String obterNumeroImovel(Scanner sc) {
        MaxLengthValidator validator = new MaxLengthValidator(
                "Número do imóvel (máximo de 4 caracteres): ",
                4
        );
        return validator.validateInput(sc);
    }

    private static String obterLogradouroImovel(Scanner sc) {
        MaxLengthValidator validator = new MaxLengthValidator(
                "Logradouro (máximo de 100 caracteres): ",
                100
        );
        return validator.validateInput(sc);
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

    private static String obterTituloImovel(Scanner sc) {
        MaxLengthValidator maxLengthValidator = new MaxLengthValidator(
                "Titulo a ser exibido (máximo de 100 caracteres): ",
                100
        );
        return maxLengthValidator.validateInput(sc);
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
