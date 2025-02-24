package POOFS;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 * IntermediateTax é uma classe que representa um produto alimentício com imposto intermediário.
 *
 * @author Bernardo Mendes
 * @author Gabriel Almeida
 * @version 1.0
 */
public class IntermediateTax extends FoodProduct {
    /**
     * IntermediateTaxCategory é um identificador da categoria do produto, podendo variar entre congelados, vinho e enlatados
     */
    private IntermediateTaxCategory category;

    /**
     * Construtor para a classe IntermediateTax
     */
    public IntermediateTax (int code, String name, String description, int amount, double unitValue, boolean isBiologic, IntermediateTaxCategory category) {
        super(code, name, description, amount, unitValue, isBiologic);
        this.category = category;
    }

    // Getters e Setters

    /**
     * Método para obter a categoria do produto (vinho, enlatados ou congelados)
     * @return category Categoria do produto
     */
    public IntermediateTaxCategory getCategory() {
        return category;
    }

    /**
     * Método que define a categoria do produto de taxa intermédia
     * @param category categoria do produto
     */
    public void setCategory(IntermediateTaxCategory category) {
        this.category = category;
    }

    // Métodos

    @Override
    /**
     * Método para calcular e retornar a taxa (IVA) a aplicar sobre o produto
     * @return taxRate Taxa sujeita ao Produto
     */
    public double calculateTax(Location location) {
        double taxRate = 0;
        switch (location) {
            case PortugalContinental:
                taxRate = 13;
                break;
            case Madeira:
                taxRate = 12;
                break;
            case Açores:
                taxRate = 9;
                break;
        }
        if(category == IntermediateTaxCategory.wine){
            taxRate += 1;
        }
        if(this.isBiologic()){
            taxRate = taxRate * 0.9;
        }
        taxRate = Math.round(taxRate*100) / 100.0;
        this.setTaxRate(taxRate);
        return taxRate;
    }

    public String toString(){
        if(isBiologic()){
            return "Produto Biológico da categoria " + category + " de taxa intermédia.";
        }
        else {
            return "Produto não Biológico da categoria " + category + " de taxa intermédia.";
        }
    }

    public void writeFile(BufferedWriter bw) throws IOException {
        bw.write("IT" + ";");
        bw.write(getCode() + ";");
        bw.write(getName() + ";");
        bw.write(getDescription() + ";");
        bw.write(getAmount() + ";");
        bw.write(getUnitValue() + ";");
        bw.write(isBiologic() + ";");
        bw.write(category.toString() + ",");

    }

}
