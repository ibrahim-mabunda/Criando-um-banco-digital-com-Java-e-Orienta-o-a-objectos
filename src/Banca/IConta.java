package Banca;

public interface IConta {
    
    /**
     * Realiza um saque na conta.
     * 
     * @param valor o valor a ser sacado
     */
    void sacar(double valor);
    
    /**
     * Realiza um depósito na conta.
     * 
     * @param valor o valor a ser depositado
     */
    void depositar(double valor);
    
    /**
     * Realiza uma transferência para outra conta.
     * 
     * @param valor o valor a ser transferido
     * @param contaDestino a conta de destino
     */
    void transferir(double valor, IConta contaDestino);
    
    /**
     * Imprime o extrato da conta.
     */
    void imprimirExtrato();
}
