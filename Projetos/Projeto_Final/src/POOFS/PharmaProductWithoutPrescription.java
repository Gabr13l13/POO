package POOFS;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * PharmaProductWithoutPrescription é uma classe que representa os produtos farmaceuticos sem prescrição.
 *
 * @author Bernardo Mendes
 * @author Gabriel Almeida
 * @version 1.0
 */
public class PharmaProductWithoutPrescription extends PharmaProduct{
    /**
     * category é um objeto do tipo PharmaProductCategory que contém a categoria do produto farmaceutico sem prescrição.
     */
    private PharmaProductCategory category;

    /**
     * Construtor para a classe PharmaProductWithoutPrescription
     * @param code Código do Produto
     * @param name Nome do Produto
     * @param description Descrição do Produto
     * @param amount Quantidade do Produto
     * @param unitValue Valor da Unidade por Produto
     * @param category Categoria do Produto
     */
    PharmaProductWithoutPrescription(int code, String name, String description, int amount, double unitValue, Boolean hasPrescription, PharmaProductCategory category) {
        super(code, name, description, amount, unitValue, hasPrescription);
        this.category = category;
    }

    /**
     * Método para calcular a taxa do produto
     * @param location Localização do Produto
     * @return TaxRate Taxa Sujeita ao Produto
     */
    @Override
    public double calculateTax(Location location) {
        double taxRate = 23;
        if(category == PharmaProductCategory.animal){
            taxRate -= 1;
        }
        return taxRate;
    }

    /**
     * Método que retorna uma descrição do produto
     * @return String Descrição do Produto
     */
    public String toString() {
        return "Produto farmaceutico sem prescrição da categoria: " + category;
    }

    /**
     * Método para escrever no ficheiro o produto farmaceutico sem prescrição
     * @param bw BufferedWriter
     * @throws IOException Exceção de Input/Output
     */
    public void writeFile(BufferedWriter bw) throws IOException {
        bw.write("PP" + ";");
        bw.write(getCode() + ";");
        bw.write(getName() + ";");
        bw.write(getDescription() + ";");
        bw.write(getAmount() + ";");
        bw.write(getUnitValue() + ";");
        bw.write(category.toString() + ",");
    }
}
