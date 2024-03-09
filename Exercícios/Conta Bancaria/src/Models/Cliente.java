package Models;

public class Cliente {
    private String nome;
    private String cpf;
    private Conta conta;

    public Cliente(String nome, String cpf, Conta conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", conta=" + conta +
                '}';
    }

    public boolean sacarDinheiro(double valor) {
        if (verificaSeEhPossivelSacar(valor)) {
            this.conta.atualizarSaldo(-valor);
            return true;
        }

        return false;
    }

    private boolean verificaSeEhPossivelSacar(double valor) {
        return this.conta.getSaldo() >= valor;
    }

    public void depositarDinheiro(double valor) {
        this.conta.atualizarSaldo(valor);
    }

    public boolean comprarComCredito(double valor) {
        return this.conta.getSaldo() + this.conta.getLimite() >= valor;
    }

    public boolean transferir(Conta contaParaReceber, double valor) {
        if (verificaSeEhPossivelSacar(valor)) {
            this.conta.atualizarSaldo(-valor);
            contaParaReceber.atualizarSaldo(valor);
            return true;
        }

        return false;
    }

}
