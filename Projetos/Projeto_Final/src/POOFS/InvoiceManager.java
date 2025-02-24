package POOFS;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe InvoiceManager
 * Esta classe é a classe responsável pela gestão das faturas da aplicação.
 *
 * @author Bernardo Mendes
 * @author Gabriel Almeida
 * @version 1.0
 */
public class InvoiceManager {
    /**
     * Construtor da Classe InvoiceManager
     */
    public InvoiceManager() {
    }

    /**
     * Método para o Utilizador escolher a função entre criar ou editar faturas.
     * Recebe como parâmetro duas ArrayLists, uma de clients e outra de faturas
     *
     * @param clients  Lista de Clientes
     * @param invoices Lista de Faturas
     */

    public void createOrEditInvoice(ClientManager cM, ArrayList<Client> clients, ArrayList<Invoice> invoices, Scanner scanner) {
        VerifyManager verifyManager = new VerifyManager();
        String option;
        int menu;
        System.out.println("Escolha uma opção:");
        System.out.println("[1] Criar uma Fatura");
        System.out.println("[2] Editar uma Fatura");
        option = scanner.nextLine();
        while (!"12".contains(option)) {
            System.out.println("Opção inválida, insira novamente:");
            option = scanner.nextLine();
        }
        menu = Integer.parseInt(option);
        switch (menu) {
            case 1:
                // Criar uma Fatura
                System.out.println();
                createInvoice(cM, clients, invoices, scanner, verifyManager);
                System.out.println();
                break;
            case 2:
                // Editar um cliente
                System.out.println();
                editInvoice(cM, clients, invoices, scanner, verifyManager);
                System.out.println();
                break;
        }
    }

    /**
     * Método para criar ou editar uma fatura
     *
     * @param clients  Lista de Clientes
     * @param invoices Lista de Faturas
     * @param scanner  Objeto Scanner
     * @param verifyManager Objeto VerifyManager
     */
    private void createInvoice(ClientManager cM, ArrayList<Client> clients, ArrayList<Invoice> invoices, Scanner scanner, VerifyManager verifyManager) {
        System.out.println(" -- Criação de Fatura -- ");
        Client client = verifyManager.verifyClient(cM, clients, scanner);
        String date = verifyManager.verifyDate(scanner);
        int invoiceNumInt = verifyManager.verifyInvoiceNumCreate(invoices, scanner);
        // Produtos
        ArrayList<Product> products = new ArrayList<>();
        int numProductsInt = verifyManager.verifyProductsNum(scanner);
        // Loop para adicionar produtos
        for (int i = 0; i < numProductsInt; i++) {
            System.out.println("-- Produto " + (i + 1) + " --");
            int productCode;
            String productName;
            String productDescription;
            int productQuantity;
            double productPrice;
            ArrayList<Certification> certifications;
            int typeProduct;
            IntermediateTaxCategory intermediateTaxCategory;
            boolean isBiologic;

            // Tipo de Produto (Food or Pharma)

            typeProduct = verifyManager.verifyTypeProduct(scanner);

            // Código do Produto
            productCode = verifyManager.verifyProductCode(scanner);

            // Nome do Produto
            String print_product = "Introduza o nome do produto:";
            productName = verifyManager.verifyString(scanner, print_product);

            // Descrição do Produto
            productDescription = verifyManager.verifyProductDescription(scanner);

            // Quantidade do Produto
            productQuantity = verifyManager.verifyProductQuantity(scanner);

            // Preço do Produto
            productPrice = verifyManager.verifyProductPrice(scanner);

            if (typeProduct == 1) {
                // Taxa aplicável ao produto
                int taxType = verifyManager.verifyAndSetTaxType(scanner);
                isBiologic = verifyManager.verifyAndSetIsBiologic(scanner);
                if (taxType == 1) {
                    int numCertifications = verifyManager.verifyCertificationsNum(scanner);
                    certifications = verifyManager.verifyAndSetCertifications(scanner, numCertifications);
                    ReducedTax product = new ReducedTax(productCode, productName, productDescription, productQuantity, productPrice, isBiologic, certifications);
                    products.add(product);
                }

                if (taxType == 2) {
                    intermediateTaxCategory = verifyManager.verifyAndSetITCategory(scanner);
                    IntermediateTax product = new IntermediateTax(productCode, productName, productDescription, productQuantity, productPrice, isBiologic, intermediateTaxCategory);
                    products.add(product);
                }

                if (taxType == 3) {
                    NormalTax product = new NormalTax(productCode, productName, productDescription, productQuantity, productPrice, isBiologic);
                    products.add(product);
                }
            }
            String productTypePharma = "";
            if (typeProduct == 2) {
                productTypePharma = verifyManager.verifyAndSetTypePharma(scanner);
            }

            if (productTypePharma.equals("Y")) {
                String print_doctor = "Introduza o nome do doutor:";
                String doctor = verifyManager.verifyString(scanner, print_doctor);
                PharmaProductWithPrescription product = new PharmaProductWithPrescription(productCode, productName, productDescription, productQuantity, productPrice, true, doctor);
                products.add(product);
            }

            if (productTypePharma.equals("N")) {
                PharmaProductCategory category = verifyManager.verifyAndSetCategory(scanner);
                PharmaProductWithoutPrescription product = new PharmaProductWithoutPrescription(productCode, productName, productDescription, productQuantity, productPrice, false, category);
                products.add(product);
            }
        }
        Invoice invoice = new Invoice(invoiceNumInt, client, date, products);
        invoices.add(invoice);
        System.out.println("Fatura criada com sucesso!");
    }

    /**
     * Método para editar faturas
     * Recebe como parâmetro duas ArrayLists, de clientes e faturas
     *
     * @param clients  Lista de Clientes
     * @param invoices Lista de Faturas
     * @param verifyManager Objeto VerifyManager
     */

    private void editInvoice(ClientManager cM, ArrayList<Client> clients, ArrayList<Invoice> invoices, Scanner scanner, VerifyManager verifyManager) {
        System.out.println();

        // Listar faturas
        System.out.println("Lista de Faturas:");
        showInvoices(invoices);
        Invoice invoice = verifyManager.verifyInvoiceEdit(invoices, scanner);

        System.out.println("Informações atuais da fatura:");
        System.out.println(invoice);
        int changeOption = verifyManager.verifyAndSelectOption(scanner);

        if (changeOption == 1) {
            Client client = verifyManager.verifyClientWithNum(cM, clients, scanner);
            invoice.setClient(client);
        }
        if (changeOption == 2) {
            String date = verifyManager.verifyDate(scanner);
            invoice.setDate(date);
        }
        if (changeOption == 3) {
            int option = verifyManager.verifyChangeProducts(scanner);
            if(option == 1){
                int productNum = verifyManager.verifyProductNum(invoice, scanner);
                invoice.getProducts().remove(productNum-1);
                if(invoice.getProducts().isEmpty()){
                    invoices.remove(invoice);
                }
            }

            if(option == 2){
                int productCode;
                String productName;
                String productDescription;
                int productQuantity;
                double productPrice;
                ArrayList<Certification> certifications;
                int typeProduct;
                IntermediateTaxCategory intermediateTaxCategory;
                boolean isBiologic;

                // Tipo de Produto (Food or Pharma)

                typeProduct = verifyManager.verifyTypeProduct(scanner);

                // Código do Produto
                productCode = verifyManager.verifyProductCode(scanner);

                // Nome do Produto
                String print_product = "Introduza o nome do produto:";
                productName = verifyManager.verifyString(scanner, print_product);

                // Descrição do Produto
                productDescription = verifyManager.verifyProductDescription(scanner);

                // Quantidade do Produto
                productQuantity = verifyManager.verifyProductQuantity(scanner);

                // Preço do Produto
                productPrice = verifyManager.verifyProductPrice(scanner);

                if (typeProduct == 1) {
                    // Taxa aplicável ao produto
                    int taxType = verifyManager.verifyAndSetTaxType(scanner);
                    isBiologic = verifyManager.verifyAndSetIsBiologic(scanner);
                    if (taxType == 1) {
                        int numCertifications = verifyManager.verifyCertificationsNum(scanner);
                        certifications = verifyManager.verifyAndSetCertifications(scanner, numCertifications);
                        ReducedTax product = new ReducedTax(productCode, productName, productDescription, productQuantity, productPrice, isBiologic, certifications);
                        invoice.getProducts().add(product);
                    }

                    if (taxType == 2) {
                        intermediateTaxCategory = verifyManager.verifyAndSetITCategory(scanner);
                        IntermediateTax product = new IntermediateTax(productCode, productName, productDescription, productQuantity, productPrice, isBiologic, intermediateTaxCategory);
                        invoice.getProducts().add(product);
                    }

                    if (taxType == 3) {
                        NormalTax product = new NormalTax(productCode, productName, productDescription, productQuantity, productPrice, isBiologic);
                        invoice.getProducts().add(product);
                    }
                }
                String productTypePharma = "";
                if (typeProduct == 2) {
                    productTypePharma = verifyManager.verifyAndSetTypePharma(scanner);
                }

                if (productTypePharma.equals("Y")) {
                    String print_doctor = "Introduza o nome do doutor:";
                    String doctor = verifyManager.verifyString(scanner, print_doctor);
                    PharmaProductWithPrescription product = new PharmaProductWithPrescription(productCode, productName, productDescription, productQuantity, productPrice, true, doctor);
                    invoice.getProducts().add(product);
                }

                if (productTypePharma.equals("N")) {
                    PharmaProductCategory category = verifyManager.verifyAndSetCategory(scanner);
                    PharmaProductWithoutPrescription product = new PharmaProductWithoutPrescription(productCode, productName, productDescription, productQuantity, productPrice, false, category);
                    invoice.getProducts().add(product);
                }
            }

            if(option == 3) {
                int productNum = verifyManager.verifyProductNum(invoice, scanner);
                Product product = invoice.getProducts().get(productNum - 1);
                System.out.println("Informações atuais do produto:");
                System.out.println(product);
                int changeProductOption = verifyManager.verifyProductOption(scanner);

                if (changeProductOption == 1) {
                    int productCode = verifyManager.verifyProductCode(scanner);
                    product.setCode(productCode);
                }
                if (changeProductOption == 2) {
                    String print = "Introduza o nome do produto:";
                    String productName = verifyManager.verifyString(scanner, print);
                    product.setName(productName);
                }
                if (changeProductOption == 3) {
                    String productDescription = verifyManager.verifyProductDescription(scanner);
                    product.setDescription(productDescription);
                }
                if (changeProductOption == 4) {
                    int productQuantity = verifyManager.verifyProductQuantity(scanner);
                    product.setAmount(productQuantity);
                }
                if (changeProductOption == 5) {
                    double productPrice = verifyManager.verifyProductPrice(scanner);
                    product.setUnitValue(productPrice);
                }
            }
        }
        System.out.println("---------------");
        System.out.println("Fatura Editada.");
        System.out.println("---------------");
    }

    /**
     * Método para visualizar todas as faturas
     * Recebe como parâmetro a ArrayList de faturas
     *
     * @param invoices Lista de Faturas
     */

    public void showInvoices(ArrayList<Invoice> invoices) {
        System.out.println("\n\u001B[34m -- Lista de Faturas --\u001B[0m\n");
        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }
    }

    /**
     * Método para visualizar uma fatura à escolha do utilizador
     * Recebe como parâmetro a ArrayList de faturas
     *
     * @param invoices Lista de Faturas
     */

    public void viewInvoice(ArrayList<Invoice> invoices, Scanner scanner) {
        System.out.println();
        VerifyManager verifyManager = new VerifyManager();
        Invoice invoice = verifyManager.verifyInvoiceView(scanner, invoices);
        double totalValueWithoutTax = 0.0;
        double totalValueWithTax = 0.0;
        double totalValueTax = 0.0;
        System.out.println("\u001B[34m -- Dados da Fatura -- \u001B[0m\n");
        System.out.println("Número da Fatura: " + invoice.getInvoiceNum());
        System.out.println("Data da Fatura: "+invoice.getDate());
        System.out.println("\nDados do Cliente:");
        System.out.println("Nome: " + invoice.getClient().getName());
        System.out.println("Localização: " + invoice.getClient().getLocation());
        System.out.println("Número de Contribuinte: " + invoice.getClient().getTaxNumber());
        System.out.println("\nProdutos da Fatura:");
        for (Product product : invoice.getProducts()) {
            System.out.println("\nProduto: " + product.getName());
            System.out.println("Descrição: " + product.getDescription());
            System.out.println(product);
            System.out.println("Código: " + product.getCode());
            System.out.println("Valor da Unidade: " + product.getUnitValue() + "€ p/ produto");
            System.out.println("Quantidade: " + product.getAmount() + " produtos");
            System.out.println("Valor sem IVA: " + product.getTotalValueWithoutTax() + "€");
            System.out.println("Taxa do IVA: " + product.getTaxRate() + "%");
            System.out.println("Valor do IVA: " + (product.getTotalValueWithTax() - product.getTotalValueWithoutTax()) + "€");
            System.out.println("Valor com IVA: " + product.getTotalValueWithTax() + "€");
            totalValueWithoutTax += product.getTotalValueWithoutTax();
            totalValueWithTax += product.getTotalValueWithTax();
            totalValueTax += product.getTotalValueWithTax() - product.getTotalValueWithoutTax();
        }
        System.out.println("\n -- Custos Totais -- ");
        System.out.println("\nValor Total da Fatura sem IVA: " + totalValueWithoutTax + "€");
        System.out.println("Valor Total do IVA: " + totalValueTax + "€");
        System.out.println("Valor Total com IVA: " + totalValueWithTax + "€\n");
    }

    /**
     * Método para mostrar as estatísticas
     * Recebe como parâmetro a ArrayList de faturas
     *
     * @param invoices Lista de Faturas
     */
    public void statistics(ArrayList<Invoice> invoices) {
        System.out.println();
        System.out.println("\u001B[32m -- Estatísticas -- \u001B[0m\n");
        int numProducts = 0;
        double totalValueWithoutTax = 0.00;
        double totalValueWithTax = 0.00;
        double totalValueTax = 0.00;
        for (Invoice invoice : invoices) {
            for (Product product : invoice.getProducts()) {
                numProducts++;
                totalValueWithoutTax += product.getTotalValueWithoutTax();
                totalValueWithTax += product.getTotalValueWithTax();
                totalValueTax += product.getTotalValueWithTax() - product.getTotalValueWithoutTax();
            }
        }
        totalValueTax = Math.round(totalValueTax * 100.0) / 100.0;
        totalValueWithoutTax = Math.round(totalValueWithoutTax * 100.0) / 100.0;
        totalValueWithTax = Math.round(totalValueWithTax * 100.0) / 100.0;
        System.out.println("Número de Faturas: " + invoices.size());
        System.out.println("Número de Produtos: " + numProducts);
        System.out.println("Valor Total das Faturas sem IVA: " + totalValueWithoutTax + "€");
        System.out.println("Valor Total do IVA: " + totalValueTax + "€");
        System.out.println("Valor Total com IVA: " + totalValueWithTax + "€\n");
    }

}
