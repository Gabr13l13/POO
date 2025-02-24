package POOFS;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Invoice é uma classe que representa uma fatura.
 *
 * @author Bernardo Mendes
 * @author Gabriel Almeida
 * @version 1.0
 */
public class Invoice implements Serializable {
    /**
     * invoiceNum é o número da fatura.
     */
    private int invoiceNum;
    /**
     * client é um objeto do tipo Client que contém o cliente.
     */
    private Client client;
    /**
     * date é uma string que contém a data de emissão da fatura.
     */
    private String date;
    /**
     * products é um arrayList de objetos do tipo Product que contém os produtos da fatura.
     */
    private ArrayList<Product> products;

    /**
     * Contrutor para a Classe Invoice
     * @param client Cliente associado à fatura
     * @param date Data de emissão da Fatura
     * @param products Lista de produtos associados à fatura
     */
    public Invoice(int invoiceNum, Client client, String date, ArrayList<Product> products) {
        this.invoiceNum = invoiceNum;
        this.client = client;
        this.date = date;
        this.products = products;
        for (Product product : products) {
            product.setTaxRate(product.calculateTax(client.getLocation()));
        }
    }

    // Getters and Setters

    /**
     * Método que retorna o número da fatura
     * @return int
     */
    public int getInvoiceNum() {
        return invoiceNum;
    }

    /**
     * Método que retorna o cliente
     * @return Client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Método que retorna a data de emissão da fatura
     * @return String
     */
    public String getDate(){
        return date;

    }

    /**
     * Método que retorna a lista de produtos
     * @return ArrayList<></>
     */
    public ArrayList<Product> getProducts(){
        return products;
    }

    /**
     * Método que define o número da fatura
     * @param invoiceNum Número da Fatura
     */
    public void setInvoiceNum(int invoiceNum){
        this.invoiceNum = invoiceNum;
    }

    /**
     * Método que define o cliente associado à fatura
     * @param client Cliente associadoa à fatura
     */
    public void setClient(Client client){
        this.client = client;
    }

    /**
     * Método que define a data da fatura
     * @param date Data da Fatura
     */
    public void setDate(String date){
        this.date= date;
    }

    /**
     * Método que define a lista de produtos associados à fatura
     * @param products Lista de produtos associados à fatura
     */
    public void setProducts(ArrayList<Product> products){
        this.products = products;
    }

    public double calculateTotalValueWithoutTax(){
        double total = 0;
        for (Product product : products) {
            total += product.getTotalValueWithoutTax();
        }
        return total;
    }

    public double calculateTotalValueWithTax(){
        double total = 0;
        for (Product product : products) {
            product.calculateTax(client.getLocation());
        }
        for (Product product : products) {
            total += product.getTotalValueWithTax();
        }
        return total;
    }

    /**
     * Método que retorna a informação da fatura
     * @return String
     */
    public String toString() {
        return "Número da Fatura: " + invoiceNum + "\nCliente: " + client.getName() + "\nData da Fatura: " + date + "\nLocalização do Cliente: " + client.getLocation() + "\nNúmero de Produtos: " + products.size() + "\n" + "Valor total sem IVA: " + calculateTotalValueWithoutTax() + "€\n" + "Valor total com IVA: " + calculateTotalValueWithTax() + "€\n";
    }

}