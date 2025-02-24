package POOFS;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Client é uma classe que representa um cliente.
 *
 * @author Bernardo Mendes
 * @author Gabriel Almeida
 * @version 1.0
 */
public class Client implements Serializable{
    /**
     * name é uma string que contém o nome do cliente.
     */
    private String name;
    /**
     * taxNumber é uma string que contém o número de contribuinte do cliente.
     */
    private String taxNumber;
    /**
     * location é um objeto do tipo Location que contém a localização do cliente.
     */
    private Location location;

    /**
     * Contrutor para a Classe Cliente
     * @param name nome do cliente
     * @param taxNumber número de contribuinte do cliente
     * @param location localização do cliente
     */
    public Client(String name, String taxNumber, Location location) {
        this.name = name;
        this.taxNumber = taxNumber;
        this.location = location;
    }

    /**
     * Método que retorna o nome do cliente
     * @return String (Nome do cliente)
     */
    public String getName() {
        return name;
    }

    /**
     * Método que retorna o número de contribuinte do cliente
     * @return String (Número de contribuinte do cliente)
     */
    public String getTaxNumber() {
        return taxNumber;
    }

    /**
     * Método que retorna a localização do cliente
     * @return Location (Localização do cliente)
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Método que define o nome do cliente
     * @param name Nome do cliente
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que define o número de contribuinte do cliente
     * @param taxNumber Número de contribuinte do cliente
     */
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * Método que define a localização do cliente
     * @param location Localização do cliente
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Método que retorna a informação do cliente
     * @return String com a informação do cliente
     */
    public String toString() {
        return "Nome: " + name + "\nNúmero de Contribuinte: " + taxNumber + "\nLocalização: " + location;
    }
}