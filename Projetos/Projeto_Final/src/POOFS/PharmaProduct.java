package POOFS;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class PharmaProduct extends Product{
    /**
     * Booleano a indicar se tem prescrição
     */
    private Boolean hasPrescription;

    /**
     * Construtor para Produtos Farmacêuticos
     * @param code Código do Produto
     * @param name Nome do Produto
     * @param description Descrição do Produto
     * @param amount Quantidade do Produto
     * @param unitValue Valor da Unidade por Produto
     * @param hasPrescription Indicador de Prescrição
     */
    public PharmaProduct(int code, String name, String description, int amount, double unitValue, Boolean hasPrescription) {
        super(code, name, description, amount, unitValue);
        this.hasPrescription = hasPrescription;
    }

    // Getters e Setters

    public Boolean getHasPrescription() {
        return hasPrescription;
    }

    public void setHasPrescription(Boolean hasPrescription) {
        this.hasPrescription = hasPrescription;
    }
}
