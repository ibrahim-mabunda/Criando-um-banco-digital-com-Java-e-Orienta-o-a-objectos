package Banca;

public class ContaPoupanca extends Conta {
    
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        imprimirInfosComuns();
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente.getNome() +
                '}';
    }
}
