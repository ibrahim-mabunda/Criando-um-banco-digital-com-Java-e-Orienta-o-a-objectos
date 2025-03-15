package Banca;


public class Main {

	public static void main(String[] args) {
		
		Cliente ibrahim = new Cliente();
		ibrahim.setNome("Ibrahim");
		
		IConta cc = new ContaCorrente(ibrahim);
		IConta poupanca = new ContaPoupanca(ibrahim);
		
		cc.depositar(100);
		
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

	}	
}
