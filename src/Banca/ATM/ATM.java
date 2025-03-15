package Banca.ATM;

import java.util.Scanner;

public class ATM {

    private Conta conta;
    private boolean pinAuthenticated = false;
    private boolean cardInserted = false;
    private Scanner scanner;

    public ATM(Conta conta, Scanner scanner) {
        this.conta = conta;
        this.scanner = scanner;
    }

    public void insertCard() {
        cardInserted = true;
        System.out.println("Cartão inserido. Por favor, insira o PIN.");
    }

    public void authenticatePin(String pin) {
        if (pin.equals("1234")) {
            pinAuthenticated = true;
            System.out.println("PIN autenticado com sucesso.");
        } else {
            System.out.println("PIN incorreto. Tente novamente.");
        }
    }

    public void displayMenu() {
        if (pinAuthenticated) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Levantamento");
            System.out.println("2. Pagamento de Serviços");
            System.out.println("3. Consulta de Saldo");
            System.out.println("4. Transferências");
            System.out.println("5. Sair");
        } else {
            System.out.println("Você deve autenticar o PIN primeiro.");
        }
    }

    public void handleUserInput() {
        if (!pinAuthenticated) {
            System.out.println("Você deve autenticar o PIN primeiro.");
            return;
        }

        int option;
        do {
            displayMenu();
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handlePayment();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    handleTransfer();
                    break;
                case 5:
                    System.out.println("Saindo... Obrigado por usar o ATM.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 5);
    }

    private void handleWithdraw() {
        System.out.print("Insira o valor para levantamento: ");
        double withdrawalAmount = scanner.nextDouble();
        withdraw(withdrawalAmount);
    }

    private void handlePayment() {
        System.out.println("Opção de pagamento de serviços selecionada.");
        // Lógica para pagamento de serviços aqui
    }

    private void handleTransfer() {
        System.out.print("Insira o valor para transferir: ");
        double transferAmount = scanner.nextDouble();
        transfer(transferAmount);
    }

    public void withdraw(double amount) {
        if (amount <= conta.getBalance()) {
            conta.withdraw(amount);
            System.out.println("Levantamento de " + amount + " realizado. Saldo atual: " + conta.getBalance());
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void checkBalance() {
        System.out.println("Seu saldo atual é: " + conta.getBalance());
    }

    public void transfer(double amount) {
        if (amount <= conta.getBalance()) {
            conta.transfer(amount);
            System.out.println("Transferência de " + amount + " realizada. Saldo atual: " + conta.getBalance());
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente(); // Supondo que Cliente tenha um construtor padrão
        Conta conta = new Conta(); // Supondo que Conta tenha um construtor padrão
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(conta, scanner);
        atm.insertCard();
        System.out.print("Insira o PIN: ");
        String pin = scanner.nextLine();
        atm.authenticatePin(pin);

        atm.handleUserInput();

        scanner.close();
    }
}