package Models;

public class Conta {
    private double saldo;
    private double limite;

    public Conta(double saldo, double limite) {
        this.saldo = saldo;
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                ", limite=" + limite +
                '}';
    }

    public double getSaldo() {
        return saldo;
    }

    public void atualizarSaldo(double valor) {
        if (valor >= 0) {
            this.saldo += valor;
        } else if (valor < 0 && this.saldo + valor >= 0) {
            this.saldo += valor;
        } else {
            System.out.println("Valor para saque superior ao saldo!");
        }
    }

    public double getLimite() {
        return limite;
    }
}
