package Banca;

public class Main {

    public static void main(String[] args) {
        
        // Criando um cliente
        Cliente ibrahim = new Cliente("Ibrahim");
        
        // Criando contas para o cliente
        IConta cc = new ContaCorrente(ibrahim);
        IConta poupanca = new ContaPoupanca(ibrahim);
        
        // Realizando um depósito na conta corrente
        cc.depositar(100);
        
        // Transferindo dinheiro da conta corrente para a conta poupança
        cc.transferir(100, poupanca);
        
        // Imprimindo extratos das contas
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }	
}
