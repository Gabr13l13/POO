package POOFS;

import java.util.ArrayList;
import java.util.Scanner;

public class VerifyManager {
    /**
     * Construtor para a classe VerifyManager
     */
    public VerifyManager() {
    }

    /**
     * Método para verificar e retornar o tipo de produto
     *
     * @param scanner Objeto Scanner
     * @return typeProduct Tipo de Produto
     */
    public int verifyTypeProduct(Scanner scanner) {
        int typeProduct;
        while (true) {
            try {
                System.out.println("Qual o tipo de produto?");
                System.out.println("[1] Alimentar");
                System.out.println("[2] Farmacêutico");
                String productTypeStr = scanner.nextLine();
                if (!productTypeStr.equals("1") && !productTypeStr.equals("2")) {
                    throw new IllegalArgumentException("\u001B[31mTipo inválido, introduza uma das opções válidas.\u001B[0m");
                }
                typeProduct = Integer.parseInt(productTypeStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return typeProduct;
    }

    /**
     * Método que verifica e retorna se um produto é biológico ou não
     *
     * @param scanner Objeto Scanner
     * @return isBiologic Booleano que indica se o produto é biológico ou não
     */
    public boolean verifyAndSetIsBiologic(Scanner scanner) {
        boolean isBiologic = false;
        while (true) {
            try {
                System.out.println("O produto é biológico?");
                System.out.println("[Y] Sim");
                System.out.println("[N] Não");
                String isBiologicStr = scanner.nextLine();
                if (!isBiologicStr.equals("Y") && !isBiologicStr.equals("N")) {
                    throw new IllegalArgumentException("\u001B[31mOpção inválida, introduza uma das opções válidas.\u001B[0m");
                }
                if (isBiologicStr.equals("Y")) {
                    isBiologic = true;
                }
                if (isBiologicStr.equals("N")) {
                    isBiologic = false;
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return isBiologic;
    }

    /**
     *
     */
    public int verifyAndSetTaxType(Scanner scanner) {
        int taxType;
        while (true) {
            try {
                System.out.println("Qual o tipo de taxa aplicada?");
                System.out.println("[1] Taxa Reduzida");
                System.out.println("[2] Taxa Intermédia");
                System.out.println("[3] Taxa Normal");
                String productTypeStr = scanner.nextLine();
                if (!productTypeStr.matches("^[1-3]$")) {
                    throw new IllegalArgumentException("\u001B[31mTipo inválido, introduza uma das opções válidas.\u001B[0m");
                }
                taxType = Integer.parseInt(productTypeStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\u001B[31mOpção inválida, introduza uma das opções válidas.\u001B[0m");
            }
        }
        return taxType;
    }

    /**
     * Método para verificar e retornar o tipo de produto farmacêutico
     *
     * @param scanner Objeto Scanner
     * @return productTypePharma Tipo de Produto Farmacêutico
     */
    public String verifyAndSetTypePharma(Scanner scanner) {
        String productTypePharma;
        while (true) {
            try {
                System.out.println("O produto tem prescrição?");
                System.out.println("[Y] Sim");
                System.out.println("[N] Não");
                productTypePharma = scanner.nextLine();
                if (!productTypePharma.equals("Y") && !productTypePharma.equals("N")) {
                    throw new IllegalArgumentException("\u001B[31mOpção inválida, introduza uma das opções válidas.\u001B[0m");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return productTypePharma;
    }

    /**
     * Método para verificar e colocar certificações na lista de certificações
     *
     * @param scanner           Objeto Scanner
     * @param numCertifications Número de certificações a incluir na lista de certificações
     */
    public ArrayList<Certification> verifyAndSetCertifications(Scanner scanner, int numCertifications) {
        ArrayList<Certification> certifications = new ArrayList<Certification>();
        while (true) {
            try {
                System.out.println("Certificações válidas:\n");
                System.out.println("ISO22000");
                System.out.println("FSSC22000");
                System.out.println("HACCP");
                System.out.println("GMP");
                System.out.println("Introduza uma certificação de cada vez.");

                int insertedCertifications = 0;
                while (insertedCertifications < numCertifications) {
                    try {
                        String cStr = scanner.nextLine();
                        if (!cStr.equals("ISO22000") && !cStr.equals("FSSC22000") && !cStr.equals("HACCP") && !cStr.equals("GMP")) {
                            throw new IllegalArgumentException("\u001B[31mCertificação inválida!\u001B[0m");
                        }

                        Certification c = Certification.valueOf(cStr);
                        if (certifications.contains(c)) {
                            throw new IllegalArgumentException("\u001B[31mEssa certificação já foi inserida!\u001B[0m");
                        }

                        certifications.add(c);
                        insertedCertifications++;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("\u001B[31mOcorreu um erro inesperado: \u001B[0m" + e.getMessage());
            }
        }
        return certifications;
    }

    /**
     * Método para verificar o número de certificações
     *
     * @param scanner Objeto Scanner
     * @return numCertifications Número de Certificações
     */
    public int verifyCertificationsNum(Scanner scanner) {
        int numCertifications;
        while (true) {
            try {
                System.out.println("Introduza o número de certificações que o produto tem:");
                String numCertificationsStr = scanner.nextLine();
                if (!numCertificationsStr.matches("^[1-4]$")) {
                    throw new IllegalArgumentException("\u001B[31mOpção inválida, introduza uma das opções válidas.\u001B[0m");
                }
                numCertifications = Integer.parseInt(numCertificationsStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\u001B[31mOpção inválida, introduza uma das opções válidas.\u001B[0m");
            }
        }
        return numCertifications;
    }

    /**
     * Método para verificar e retornar a categoria de um produto de taxa intermédia
     *
     * @param scanner Objeto Scanner
     * @return intermediateTaxCategory Categoria do Produto de Taxa Intermédia
     */
    public IntermediateTaxCategory verifyAndSetITCategory(Scanner scanner) {
        IntermediateTaxCategory intermediateTaxCategory;
        while (true) {
            try {
                System.out.println("Introduza uma das categorias:");
                System.out.println("Congelado");
                System.out.println("Enlatado");
                System.out.println("Vinho");
                String categoryStr = scanner.nextLine();
                intermediateTaxCategory = switch (categoryStr) {
                    case "Congelado" -> IntermediateTaxCategory.frozen;
                    case "Enlatado" -> IntermediateTaxCategory.canned;
                    case "Vinho" -> IntermediateTaxCategory.wine;
                    default -> throw new IllegalArgumentException("\u001B[31mOpção inválida, insira novamente.\u001B[0m");
                };
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return intermediateTaxCategory;
    }

    /**
     * Método para verificar e retornar a categoria de um produto farmacêutico
     *
     * @param scanner Objeto Scanner
     * @return category Categoria do Produto Farmacêutico
     */
    public PharmaProductCategory verifyAndSetCategory(Scanner scanner) {
        PharmaProductCategory category;
        label:
        while (true) {
            try {
                System.out.println("Introduza a categoria do produto farmacêutico:");
                System.out.println("Beleza");
                System.out.println("Bem Estar");
                System.out.println("Bebé");
                System.out.println("Animal");
                System.out.println("Outros");
                String categoryStr = scanner.nextLine();
                switch (categoryStr) {
                    case "Beleza":
                        category = PharmaProductCategory.beauty;
                        break label;
                    case "Bem Estar":
                        category = PharmaProductCategory.wellBeing;
                        break label;
                    case "Bebé":
                    case "Bebe":
                        category = PharmaProductCategory.baby;
                        break label;
                    case "Animal":
                        category = PharmaProductCategory.animal;
                        break label;
                    case "Outros":
                        category = PharmaProductCategory.other;
                        break label;
                    default:
                        throw new IllegalArgumentException("\u001B[31mOpção inválida, insira novamente.\u001B[0m");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return category;
    }

    /**
     * Método para verificar a data de uma fatura
     *
     * @param scanner Objeto Scanner
     * @return date Data da Fatura
     */
    public String verifyDate(Scanner scanner) {
        // Validação da Data
        String date;
        while (true) {
            try {
                System.out.println("Introduza a data da fatura (dd/mm/aaaa):");
                date = scanner.nextLine();
                if (!date.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$")) {
                    throw new IllegalArgumentException("\u001B[31mData inválida. Use o formato dd/mm/aaaa.\u001B[0m");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return date;
    }

    /**
     * Método para verificar o número de uma fatura
     *
     * @param invoices Lista de Faturas
     * @param scanner  Objeto Scanner
     * @return invoiceNumInt Número da Fatura
     */
    public int verifyInvoiceNumCreate(ArrayList<Invoice> invoices, Scanner scanner) {
        int invoiceNumInt;
        while (true) {
            try {
                System.out.println("Introduza o número da fatura:");
                String invoiceNum = scanner.nextLine();
                if (!invoiceNum.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("\u001B[31mNúmero de fatura inválido. Deve conter apenas números.\u001B[0m");
                }
                invoiceNumInt = Integer.parseInt(invoiceNum);
                for (Invoice invoice : invoices) {
                    if (invoice.getInvoiceNum() == invoiceNumInt) {
                        throw new IllegalArgumentException("\u001B[31mNúmero de fatura já utilizado, selecione outro número.\u001B[0m");
                    }
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return invoiceNumInt;
    }
    /**
     * Método para verificar o número de uma fatura
     *
     * @param invoices Lista de Faturas
     * @param scanner  Objeto Scanner
     * @return invoice Fatura selecionada
     */
    public Invoice verifyInvoiceEdit(ArrayList<Invoice> invoices, Scanner scanner) {
        int invoiceNumInt;
        Invoice invoice = null;
        while (true) {
            try {
                System.out.println("Introduza o número da fatura:");
                String invoiceNum = scanner.nextLine();
                if (!invoiceNum.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("\u001B[31mNúmero de fatura inválido. Deve conter apenas números.\u001B[0m");
                }
                invoiceNumInt = Integer.parseInt(invoiceNum);
                for (Invoice i : invoices) {
                    if (i.getInvoiceNum() == invoiceNumInt) {
                        invoice = i;
                    }
                }
                if(invoice == null){
                    throw new IllegalArgumentException("\u001B[31mNúmero de fatura inválido, introduza uma das opções válidas.\u001B[0m");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return invoice;
    }


    /**
     * Método para verificar o número de produtos
     *
     * @param scanner Objeto Scanner
     * @return numProductsInt Número de Produtos
     */
    public int verifyProductsNum(Scanner scanner) {
        int numProductsInt;
        // Validação do Número de Produtos
        while (true) {
            try {
                System.out.println("Introduza o número de produtos:");
                String numProducts = scanner.nextLine();
                if (!numProducts.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("\u001B[31mNúmero de produtos inválido. Deve conter apenas números.\u001B[0m");
                }
                if(numProducts.length() >= 9){
                    throw new IllegalArgumentException("\u001B[31mNúmero inválido, não é impossível introduzir tantos produtos numa só fatura.\u001B[0m");
                }
                numProductsInt = Integer.parseInt(numProducts);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return numProductsInt;
    }


    /**
     * Método para verificar cliente
     *
     * @param cM      Objeto da classe ClientManager
     * @param clients Lista de Clientes
     * @param scanner Objeto Scanner
     * @return client Cliente escolhido
     */
    public Client verifyClient(ClientManager cM, ArrayList<Client> clients, Scanner scanner) {
        Client client;
        while (true) {
            try {
                cM.showClients(clients);
                System.out.println("Introduza o número do cliente:");
                String clientNumStr = scanner.nextLine();
                if (!clientNumStr.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("\u001B[31mNúmero inválido.\u001B[0m");
                }
                int clientNum = Integer.parseInt(clientNumStr);

                if (clientNum > clients.size() || clientNum < 1) {
                    throw new IllegalArgumentException("\u001B[31mNúmero inválido.\u001B[0m");
                }

                client = clients.get(clientNum - 1);

                if (client == null) {
                    throw new IllegalArgumentException("\u001B[31mCliente não encontrado.\u001B[0m");
                }

                break; // Cliente encontrado e válido
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return client;
    }

    /**
     * Método que verifica e retorna a opção
     *
     * @param scanner Objeto Scanner
     * @return changeOption Opção escolhida
     */
    public int verifyAndSelectOption(Scanner scanner) {
        int changeOption;
        while (true) {
            try {
                System.out.println("Pretende mudar:");
                System.out.println("[1] Cliente");
                System.out.println("[2] Data");
                System.out.println("[3] Produtos");
                System.out.println("[4] Sair");
                String option = scanner.nextLine();
                changeOption = Integer.parseInt(option);
                if (changeOption > 0 && changeOption <= 4) {
                    break;
                } else {
                    System.out.println("\u001B[31mValor incorreto, introduza um número de fatura válido.\u001B[0m");
                }
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mValor incorreto, introduza um número de fatura válido.\u001B[0m");
            }
        }
        return changeOption;
    }

    /**
     * Método que retona o Client verificando o número de Cliente
     *
     * @param clients Lista de Clientes
     * @param scanner Objeto Scanner
     * @return client Cliente escolhido
     */
    public Client verifyClientWithNum(ClientManager cM, ArrayList<Client> clients, Scanner scanner) {
        int clientNum;
        Client client;
        while (true) {
            try {
                cM.showClients(clients);
                System.out.println("Introduza o número do cliente:");
                String clientNumStr = scanner.nextLine();
                if (!clientNumStr.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("\u001B[31mNúmero inválido.\u001B[0m");
                }
                clientNum = Integer.parseInt(clientNumStr);

                client = clients.get(clientNum - 1);
                if (client == null) {
                    throw new IllegalArgumentException("\u001B[31mCliente não encontrado.\u001B[0m");
                }
                break; // Cliente encontrado e válido
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return client;
    }

    /**
     * Método para verificar o número do produto
     *
     * @param invoice Fatura
     * @param scanner Objeto Scanner
     * @return productNum Número do Produto
     */
    public int verifyProductNum(Invoice invoice, Scanner scanner) {
        int productNum;
        while (true) {
            try {
                System.out.println("Lista de Produtos:");
                ArrayList<Product> products = invoice.getProducts();
                for (int i = 0; i < products.size(); i++) {
                    System.out.println("----------------");
                    System.out.printf("Número de Produto %d\n", i + 1);
                    System.out.println(products.get(i));
                    System.out.println("----------------");
                }
                System.out.println("Introduza o número do produto que pretende editar:");
                String option = scanner.nextLine();
                productNum = Integer.parseInt(option);
                if (productNum > 0 && productNum <= products.size()) {
                    break;
                } else {
                    System.out.println("\u001B[31mValor incorreto, introduza um número de produto válido.\u001B[0m");
                }
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mValor incorreto, introduza um número de produto válido.\u001B[0m");
            }
        }
        return productNum;
    }

    /**
     * Método para verificar a opção do produto
     *
     * @param scanner Objeto Scanner
     */
    public int verifyProductOption(Scanner scanner) {
        int changeProductOption;
        while (true) {
            try {
                System.out.println("Pretende mudar:");
                System.out.println("[1] Código");
                System.out.println("[2] Nome");
                System.out.println("[3] Descrição");
                System.out.println("[4] Quantidade");
                System.out.println("[5] Preço");
                System.out.println("[6] Sair");
                String option = scanner.nextLine();
                changeProductOption = Integer.parseInt(option);
                if (changeProductOption > 0 && changeProductOption <= 6) {
                    break;
                } else {
                    System.out.println("\u001B[31mValor incorreto, introduza um número de produto válido.\u001B[0m");
                }
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mValor incorreto, introduza um número de produto válido.\u001B[0m");
            }
        }
        return changeProductOption;
    }

    /**
     * Método para verificar o código do produto
     *
     * @param scanner Objeto Scanner
     */
    public int verifyProductCode(Scanner scanner) {
        int productCode;
        while (true) {
            try {
                System.out.println("Introduza o código do produto:");
                String productCodeStr = scanner.nextLine();
                if (!productCodeStr.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("\u001B[31mCódigo do produto inválido. Deve conter apenas números.\u001B[0m");
                }
                productCode = Integer.parseInt(productCodeStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return productCode;
    }

    /**
     * Método que verifica e retorna uma string
     *
     * @param scanner Objeto Scanner
     * @param print   Tipo de Nome a imprimir na consola
     * @return string String com o nome
     */
    public String verifyString(Scanner scanner, String print) {
        String string;
        while (true) {
            try {
                System.out.println(print);
                string = scanner.nextLine();
                if (!string.matches("^[a-zA-ZáéíóúÁÉÍÓÚçÇãÃõÕûÛâÂêÊîÎôÔ ]+$")) {
                    throw new IllegalArgumentException("\u001B[31mO nome inserido é inválido. Apenas letras e espaços são permitidos.\u001B[0m");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return string;
    }

    /**
     * Método para verificar a descrição do produto
     *
     * @param scanner Objeto Scanner
     */
    public String verifyProductDescription(Scanner scanner) {
        String productDescription;
        while (true) {
            try {
                System.out.println("Introduza a descrição do produto:");
                productDescription = scanner.nextLine();
                if (!productDescription.matches("^[a-zA-ZáéíóúÁÉÍÓÚçÇ ]+$")) {
                    throw new IllegalArgumentException("\u001B[31mDescrição do produto inválida. Apenas letras e espaços são permitidos.\u001B[0m");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return productDescription;
    }

    /**
     * Método para verificar a quantidade do produto
     *
     * @param scanner Objeto Scanner
     */
    public int verifyProductQuantity(Scanner scanner) {
        int productQuantity;
        while (true) {
            try {
                System.out.println("Introduza a quantidade do produto:");
                String productQuantityStr = scanner.nextLine();
                if (!productQuantityStr.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("\u001B[31mQuantidade do produto inválida. Deve conter apenas números.\u001B[0m");
                }
                productQuantity = Integer.parseInt(productQuantityStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return productQuantity;
    }

    /**
     * Método para verificar o preço do produto
     *
     * @param scanner Objeto Scanner
     * @return productPrice Preço do Produto
     */
    public double verifyProductPrice(Scanner scanner) {
        double productPrice;
        while (true) {
            try {
                System.out.println("Introduza o preço do produto:");
                String productPriceStr = scanner.nextLine();
                if (!productPriceStr.matches("^[0-9]+(\\.[0-9]{1,2})?$")) {
                    throw new IllegalArgumentException("\u001B[31mPreço do produto inválido. Deve ser um número com até duas casas decimais.\u001B[0m");
                }
                productPrice = Double.parseDouble(productPriceStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return productPrice;
    }
    /**
     * Método para verificar o número de contribuinte
     * @param scanner Objeto Scanner
     * @return taxNumber Número de Contribuinte
     */
    public String verifyTaxNumber(Scanner scanner){
        String taxNumberStr;
        while (true) {
            try {
                System.out.println("Introduza o seu número de contribuinte:");
                taxNumberStr = scanner.nextLine();
                if (taxNumberStr.length() != 9 || !taxNumberStr.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("\u001B[31mNúmero de contribuinte inválido. Deve conter 9 dígitos numéricos.\u001B[0m");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return taxNumberStr;
    }

    /**
     * Método para verificar e retornar a localização
     * @param scanner Objeto Scanner
     * @return locationF Localização do Cliente
     */
    public Location verifyAndSetLocation(Scanner scanner){
        Location locationF;
        while (true) {
            try {
                System.out.println("Introduza a sua localização (PortugalContinental, Madeira ou Açores):");
                String location = scanner.nextLine();
                if (!location.equals("PortugalContinental") && !location.equals("Madeira") && !location.equals("Açores")) {
                    throw new IllegalArgumentException("\u001B[31mA localização inserida não é válida. Escolha entre: PortugalContinental, Madeira ou Açores.\u001B[0m");
                }
                locationF = Location.valueOf(location);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return locationF;
    }

    /**
     * Método para verificar a opção na edição de produtos
     * @param scanner Objeto Scanner
     * @return option Opção de Modificação
     */

    public int verifyChangeProducts(Scanner scanner){
        int option;
        while(true) {
            try {
                System.out.println("Pretende:");
                System.out.println("[1] Eliminar um Produto");
                System.out.println("[2] Adicionar um Produto");
                System.out.println("[3] Alterar um Produto");
                String optionString = scanner.nextLine();
                if(!optionString.matches("^[1-3]$")){
                    throw new IllegalArgumentException("\u001B[31mOpção inválida.\u001B[0m");
                }
                option = Integer.parseInt(optionString);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return option;

    }

    /**
     * Método para verificar a opção no Menu Principal
     * @param scanner Objeto Scanner
     * @return option Opção do Menu
     */

    public int verifyOptionMenu(Scanner scanner){
        int option;
        String optionString;
        MenuManager menuManager = new MenuManager();
        menuManager.showASCII();
        menuManager.showMenu();
        optionString = scanner.nextLine();
        while (!optionString.matches("^[1-8]$")) {
            System.out.println("\n\u001B[31mOpção inválida, insira novamente:\u001B[0m");
            optionString = scanner.nextLine();
        }
        option = Integer.parseInt(optionString);
        return option;
    }

    /**
     * Verifica a localização do cliente a editar
     * @param scanner Objeto Scanner
     * @return loc Nova Localização do Cliente a editar
     */

    public Location verifyLocationEditClient(Scanner scanner){
        String loc;
        while (true) {
            System.out.println("Introduza a nova localização:");
            System.out.println("PortugalContinental | Açores | Madeira");
            loc = scanner.nextLine();

            if(loc.equals("PortugalContinental") || loc.equals("Açores") || loc.equals("Madeira")){
                break;
            }
            else{
                System.out.println("\u001B[31mLocalização incorreta, introduza novamente.\u001B[0m");
            }
        }
        return Location.valueOf(loc);
    }

    /**
     * Método para verificar o novo TaxNumber do cliente
     * @param scanner Objeto Scanner
     * @return newTaxNumber Novo Número de Contribuinte do Cliente
     */

    public String verifyTaxNumberEditClient(Scanner scanner){
        String newTaxNumber;
        while (true) {
            System.out.println("Introduza o novo número de contribuinte:");
            newTaxNumber = scanner.nextLine();

            if (newTaxNumber.matches("^[0-9]+$") && newTaxNumber.length() == 9) {
                break;
            } else {
                System.out.println("\u001B[31mValor incorreto, introduza um número de cliente válido.\u001B[0m");
            }
        }
        return newTaxNumber;
    }

    /**
     * Verifica o nome a editar o cliente
     * @param scanner Objeto Scanner
     * @return nome Novo nome do cliente
     */

    public String verifyNameEditClient(Scanner scanner){
        String nome;
        while (true) {
            System.out.println("Introduza o seu nome:");
            nome = scanner.nextLine();
            if (nome.matches("^[a-zA-ZáãéíóúÁÉÍÓÚçÇ ]+$")) {
                break;
            } else {
                System.out.println("\u001B[31mO nome introduzido é inválido. Apenas são aceites letras e espaços.\u001B[0m");
            }
        }
        return nome;
    }

    /**
     * Método para verificar a opção para editar o cliente
     * @param scanner Objeto Scanner
     * @return changeOption Opção para editar
     */

    public int verifyOptionEditClient(Scanner scanner){
        int changeOption;
        while (true) {
            try {
                System.out.println("Pretende mudar:");
                System.out.println("[1] Nome");
                System.out.println("[2] Número de Contribuinte");
                System.out.println("[3] Localização");
                System.out.println("[4] Sair");
                String option = scanner.nextLine();

                changeOption = Integer.parseInt(option);

                if (changeOption > 0 && changeOption <= 4) {
                    return changeOption;
                } else {
                    System.out.println("\u001B[31mValor incorreto, introduza um número de cliente válido.\u001B[0m");
                }
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mValor incorreto, introduza um número de cliente válido.\u001B[0m");
            }
        }
    }

    /**
     * Método para verificar o número do cliente que se pretende editar
     * @param scanner Objeto Scanner
     * @param clients Array List de Clientes
     * @return clientNum O número do cliente a editar
     */

    public int verifyNumClientEditClient(Scanner scanner, ArrayList<Client> clients){
        ClientManager clientManager = new ClientManager();
        int clientNum;
        while (true) {
            try {
                System.out.println("Lista de Clientes:");
                clientManager.showClients(clients);
                System.out.println("Introduza o número do cliente que pretende editar:");
                String option = scanner.nextLine();
                clientNum = Integer.parseInt(option);
                if (clientNum > 0 && clientNum <= clients.size()) {
                    return clientNum;
                } else {
                    System.out.println("\u001B[31mValor incorreto, introduza um número de cliente válido.\u001B[0m");
                }
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mValor incorreto, introduza um número de cliente válido.\u001B[0m");
            }
        }
    }

    /**
     * Método para verificar que fatura é para visualizar
     * @param scanner Objeto Scanner
     * @param invoices ArrayList de Invoices
     * @return invoice Fatura a visualizar
     */

    public Invoice verifyInvoiceView(Scanner scanner, ArrayList<Invoice> invoices){
        int invoiceNum;
        Invoice invoice = null;
        InvoiceManager invoiceManager = new InvoiceManager();
        while (true) {
            try {
                System.out.println("Lista de Faturas:");
                invoiceManager.showInvoices(invoices);
                System.out.println("Introduza o número da fatura:");
                String invoiceNumStr = scanner.nextLine();
                if (!invoiceNumStr.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("\u001B[31mNúmero inválido.\u001B[0m");
                }
                invoiceNum = Integer.parseInt(invoiceNumStr);

                for(Invoice invoice1 : invoices) {
                    if (invoiceNum == invoice1.getInvoiceNum()) {
                        invoice = invoice1;
                    }
                }

                if (invoice == null) {
                    throw new IllegalArgumentException("\u001B[31mFatura não encontrada.\u001B[0m");
                }

                return invoice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
