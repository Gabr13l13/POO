package POOFS;

import java.io.BufferedWriter;
import java.io.IOException;

public class NormalTax extends FoodProduct{
    /**
     * Construtor para Produtos de Taxa Normal
     * @param code Código do Produto
     * @param name Nome do Produto
     * @param description Descrição do Produto
     * @param amount Quantidade do Produto
     * @param unitValue Preço da Unidade do Produto
     * @param isBiologic Booleano a indicar se é biológico
     */
    public NormalTax(int code, String name, String description, int amount, double unitValue, boolean isBiologic){
        super(code, name, description, amount, unitValue, isBiologic);
    }

    @Override
    /**
     * Método para calcular e retornar a taxa (IVA)
     * @return taxRate Taxa sujeita ao produto
     */
    public double calculateTax(Location location) {
        double taxRate = 0.0;
        switch (location) {
            case PortugalContinental:
                taxRate = 23;
                break;
            case Madeira:
                taxRate = 22;
                break;
            case Açores:
                taxRate = 16;
                break;
        }
        if(this.isBiologic()){
            taxRate = taxRate * 0.9;
        }
        taxRate = Math.round(taxRate*100) / 100.0;
        this.setTaxRate(taxRate);
        return taxRate;
    }

    /**
     * Método para escrever no ficheiro os produtos de NormalTax
     * @param bw BufferedWriter
     * @throws IOException Exceção de erro
     */
    public void writeFile(BufferedWriter bw) throws IOException {
        bw.write("NT" + ";");
        bw.write(getCode() + ";");
        bw.write(getName() + ";");
        bw.write(getDescription() + ";");
        bw.write(getAmount() + ";");
        bw.write(getUnitValue() + ";");
        bw.write(isBiologic() + ",");
    }

    /**
     * Método para retornar a descrição do produto alimentar
     * @return String Descrição do produto alimentar
     */
    public String toString() {
        if(this.isBiologic()) {
            return "Produto alimentar biológico de taxa normal.";
        }
        else{
            return "Produto alimentar não biológico de taxa normal.";
        }
    }
}
