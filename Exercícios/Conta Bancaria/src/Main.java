import Models.Cliente;
import Models.Conta;

public class Main {
    public static void main(String[] args) {
        // Criando uma conta com saldo inicial de 1000 e limite de 500
        Conta conta1 = new Conta(1000, 500);

        // Criando um cliente com nome, CPF e associando a conta criada acima
        Cliente cliente1 = new Cliente("João", "123.456.789-00", conta1);

        // Imprimindo informações do cliente
        System.out.println("Informações do cliente:");
        System.out.println(cliente1);

        // Depositando 500 na conta do cliente
        cliente1.depositarDinheiro(500);
        System.out.println("Após depositar 500:");
        System.out.println(cliente1);

        // Tentando sacar 1500 da conta do cliente
        System.out.println("Tentando sacar 1500:");
        if (cliente1.sacarDinheiro(1500)) {
            System.out.println("Saque de 1500 realizado com sucesso.");
        } else {
            System.out.println("Não foi possível sacar 1500.");
        }
        System.out.println(cliente1);

        // Tentando comprar com crédito de 2000
        System.out.println("Tentando comprar com crédito de 2000:");
        if (cliente1.comprarComCredito(2000)) {
            System.out.println("Compra de 2000 realizada com sucesso.");
        } else {
            System.out.println("Não foi possível realizar a compra de 2000.");
        }
        System.out.println(cliente1);

        // Criando outra conta com saldo inicial de 200 e limite de 300
        Conta conta2 = new Conta(200, 300);

        // Transferindo 300 da conta1 para conta2
        System.out.println("Transferindo 300 da conta1 para conta2:");
        if (cliente1.transferir(conta2, 300)) {
            System.out.println("Transferência de 300 realizada com sucesso.");
        } else {
            System.out.println("Não foi possível transferir 300.");
        }
        System.out.println("\nInformações da conta1:");
        System.out.println(cliente1);
        System.out.println("Informações da conta2:");
        System.out.println(conta2);
    }
}
