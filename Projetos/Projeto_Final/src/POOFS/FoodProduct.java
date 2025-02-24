package POOFS;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 * FoodProduct é uma classe que representa um produto alimentar.
 *
 * @author Bernardo Mendes
 * @author Gabriel Almeida
 * @version 1.0
 */
public abstract class FoodProduct extends Product {
    /**
     * isBiologic é um boolean que indica se o produto é biológico ou não.
     */
    private boolean isBiologic;

    /**
     * Construtor para a classe FoodProduct
     * @param code Código do Produto
     * @param name Nome do Produto
     * @param description Descrição do Produto
     * @param amount Quantidade do Produto
     * @param unitValue Valor da Unidade por Produto
     * @param isBiologic Se é biológico ou não
     */
    public FoodProduct(int code, String name, String description, int amount, double unitValue, boolean isBiologic) {
        super(code, name, description, amount, unitValue);
        this.isBiologic = isBiologic;
    }

    // Getters and Setters

    /**
     * Getter para saber se é biológico
     * @return isBiologic booleano a indicar se é biológico
     */
    public boolean isBiologic() {
        return isBiologic;
    }

    /**
     * Setter para atualizar o booleano isBiologic
     * @param isBiologic
     */
    public void setBiologic(boolean isBiologic) {
        this.isBiologic = isBiologic;
    }
}
