package POOFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe POOFS
 * Esta classe é a classe principal da aplicação POOFS.
 *
 * @author Bernardo Mendes
 * @author Gabriel Almeida
 * @version 1.0
 */
public class POOFS implements Serializable {
    /**
     * ArrayList de faturas
     */
    private ArrayList<Invoice> invoices;
    /**
     * ArrayList de clientes
     */
    private ArrayList<Client> clients;

    /**
     * Construtor da classe POOFS
     *
     * @param invoices Lista de faturas
     * @param clients  Lista de clientes
     */
    public POOFS(ArrayList<Invoice> invoices, ArrayList<Client> clients) {
        this.invoices = invoices;
        this.clients = clients;
    }

    /**
     * Getter do ArrayList de faturas
     *
     * @return invoices Lista de faturas
     */
    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    /**
     * Getter do ArrayList de clientes
     *
     * @return clients Lista de clientes
     */
    public ArrayList<Client> getClients() {
        return clients;
    }

    /**
     * Método main para executar a aplicação POOFS
     * É aqui que é tratada a parte da interação com o utilizador
     *
     * @param args Argumentos da linha de comandos
     */
    public static void main(String[] args) {
        // Criação de um objeto POOFS
        ArrayList<Invoice> invoices = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();
        POOFS poofs = new POOFS(invoices, clients);
        // Criação de objetos FileManager, ClientManager, InvoiceManager, MenuManager e Scanner
        FileManager fileManager = new FileManager();
        ClientManager clientManager = new ClientManager();
        InvoiceManager invoiceManager = new InvoiceManager();
        VerifyManager verifyManager = new VerifyManager();
        Scanner scanner = new Scanner(System.in);
        // Importar ficheiros
        poofs = fileManager.importInvoices(poofs);
        // Menu
        int menu;
        do {
            menu = verifyManager.verifyOptionMenu(scanner);
            switch (menu) {
                case 1:
                    // Criar ou editar um cliente
                    clientManager.createOrEditClients(poofs.clients);
                    break;
                case 2:
                    //Lista de clientes
                    clientManager.showClients(poofs.clients);
                    break;
                case 3:
                    //Criar e editar faturas
                    invoiceManager.createOrEditInvoice(clientManager, poofs.clients, poofs.invoices, scanner);
                    break;
                case 4:
                    //Listar faturas
                    invoiceManager.showInvoices(poofs.invoices);
                    break;
                case 5:
                    //Visualizar fatura
                    invoiceManager.viewInvoice(poofs.invoices, scanner);
                    break;
                case 6:
                    //Estatísticas
                    invoiceManager.statistics(poofs.invoices);
                    break;
                case 7:
                    // Exportar para txt
                    fileManager.exportInvoicesForTXT(poofs);
                    break;
                case 8:
                    //Exportar ficheiros para .obj e sair
                    fileManager.exportInvoices(poofs);
                    break;
            }
        }
        while (menu != 8);
    }
}