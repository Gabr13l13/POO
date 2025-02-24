package POOFS;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe ClientManager
 * Esta classe é a classe responsável pela gestão dos clientes.
 * (Criação, edição e visualização)
 *
 * @author Bernardo Mendes
 * @author Gabriel Almeida
 * @version 1.0
 */
public class ClientManager {
    /**
     * Construtor da Classe ClientManager
     */
    public ClientManager() {
    }

    /**
     * Método para o Utilizador escolher a função, entre Editar ou Criar clientes
     * Recebe como parâmetro a ArrayList Clientes para a poder alterar
     *
     * @param clients Lista de Clientes
     */
    public void createOrEditClients(ArrayList<Client> clients) {
        VerifyManager verifyManager = new VerifyManager();
        Scanner scanner = new Scanner(System.in);

        String option;
        int menu;
        System.out.println("Escolha uma opção:");
        System.out.println("[1] Criar um Cliente");
        System.out.println("[2] Editar um Cliente");
        option = scanner.nextLine();
        while (!"12".contains(option)) {
            System.out.println("Opção inválida, insira novamente:");
            option = scanner.nextLine();
        }
        menu = Integer.parseInt(option);
        switch (menu) {
            case 1:
                // Criar um cliente
                System.out.println();
                createClient(clients, scanner, verifyManager);
                System.out.println();
                break;
            case 2:
                // Editar um cliente
                System.out.println();
                editClient(clients);
                System.out.println();
                break;
        }
    }

    /**
     * Método para criar um cliente
     * Recebe como parametro o ArrayList de clientes
     *
     * @param clients       Lista de Clientes
     * @param scanner       Scanner
     * @param verifyManager VerifyManager
     */
    private void createClient(ArrayList<Client> clients, Scanner scanner, VerifyManager verifyManager) {
        System.out.println();
        System.out.println(" -- Criação do Perfil de Cliente -- ");
        String print_name = "Introduza o seu nome:";
        String nome = verifyManager.verifyString(scanner, print_name);

        String taxNumberStr = verifyManager.verifyTaxNumber(scanner);

        Location locationF = verifyManager.verifyAndSetLocation(scanner);

        Client client = new Client(nome, taxNumberStr, locationF);
        clients.add(client);
        System.out.println("Cliente criado com sucesso!");

    }

    /**
     * Método para Editar clientes já existentes
     * Recebe como parâmetro a ArrayList de Clients.
     *
     * @param clients Lista de Clientes
     */

    private void editClient(ArrayList<Client> clients) {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        VerifyManager verifyManager = new VerifyManager();
        int clientNum = verifyManager.verifyNumClientEditClient(scanner, clients);
        Client client = clients.get(clientNum - 1);
        System.out.println("Informações atuais do cliente:");
        System.out.println(client);
        int changeOption = verifyManager.verifyOptionEditClient(scanner);

        if (changeOption == 1) {
            client.setName(verifyManager.verifyNameEditClient(scanner));
        }
        if (changeOption == 2) {
            client.setTaxNumber(verifyManager.verifyTaxNumberEditClient(scanner));
        }
        if (changeOption == 3){
            client.setLocation(verifyManager.verifyLocationEditClient(scanner));
        }
        if (changeOption == 4) {
            System.out.println("Cliente editado com sucesso!");
        }
    }

    /**
     * Método para exibir todos os clientes
     * Recebe como parâmetro a ArrayList Clients
     *
     * @param clients Lista de Clientes
     */
    public void showClients(ArrayList<Client> clients) {
        System.out.println("\n\u001B[34m -- Lista de Clientes -- \u001B[0m\n");
        if (clients.isEmpty()) {
            System.out.println("\u001B[31mNão existem clientes registados.\u001B[0m");
        } else {
            for (int i = 0; i < clients.size(); i++) {

                System.out.printf("Número de Cliente - %d\n", i + 1);
                System.out.println(clients.get(i));
                System.out.println();
            }
        }
    }
}
