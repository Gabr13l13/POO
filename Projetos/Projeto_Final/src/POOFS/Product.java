package POOFS;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 * Product é uma classe que representa um produto.
 *
 * @author Bernardo Mendes
 * @author Gabriel Almeida
 * @version 1.0
 */
public abstract class Product implements Serializable {
    /**
     * code é o código do produto.
     */
    private int code;
    /**
     * name é o nome do produto.
     */
    private String name;
    /**
     * description é a descrição do produto.
     */
    private String description;
    /**
     * amount é a quantidade do produto.
     */
    private int amount;
    /**
     * unitValue é o valor unitário do produto.(Sem IVA)
     */
    private double unitValue;
    /**
     * taxRate é a taxa de imposto do produto.
     */
    private double taxRate;

    /**
     * Construtor Vazio para a Classe Produto
     */
    public Product() {

    }

    /**
     * Contrutor para a Classe Produto
     *
     * @param code        código do produto
     * @param name        nome do produto
     * @param description descrição do produto
     * @param amount      quantidade do produto
     * @param unitValue   valor unitário do produto
     */
    public Product(int code, String name, String description, int amount, double unitValue) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.unitValue = unitValue;
    }

    /**
     * Método que retorna o código do produto
     *
     * @return int
     */
    public int getCode() {
        return code;
    }

    /**
     * Método que retorna o nome do produto
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Método que retorna a descrição do produto
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Método que retorna a quantidade do produto
     *
     * @return int
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Método que retorna o valor unitário do produto
     */
    public double getUnitValue() {
        return unitValue;
    }

    /**
     * Método que retorna a taxa de imposto do produto
     *
     * @return double
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     * Método que define o código do produto
     *
     * @param code Código do Produto
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Método que define o nome do produto
     *
     * @param name Nome do Produto
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que define a descrição do produto
     *
     * @param description Descrição do Produto
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Método que define a quantidade do produto
     *
     * @param amount Quantidade do Produto
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Método que define o valor unitário do produto
     *
     * @param unitValue Valor Unitário do Produto
     */
    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    /**
     * Método que define a taxa de imposto do produto
     *
     * @param taxRate Taxa de Imposto do Produto
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * Método que retorna o valor total do produto sem IVA
     *
     * @return double Valor total do produto sem IVA
     */
    public double getTotalValueWithoutTax() {
        double totalValueWithoutTax = unitValue * amount;
        return Math.round(totalValueWithoutTax * 100.0) / 100.0;
    }

    /**
     * Método que retorna o valor total do produto com IVA
     *
     * @return double Valor total do produto com IVA
     */
    public double getTotalValueWithTax() {
        double totalValueWithTax = amount * unitValue * (1 + taxRate / 100);
        return Math.round(totalValueWithTax * 100.0) / 100.0;
    }

    public abstract double calculateTax(Location location);

    /**
     * Método abstrato para escrever no ficheiro
     *
     * @param bw BufferedWriter
     * @throws IOException Exceção de I/O
     */
    public abstract void writeFile(BufferedWriter bw) throws IOException;
}
