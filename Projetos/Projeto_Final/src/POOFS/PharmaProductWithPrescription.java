package POOFS;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * PharmaProductWithPrescription é uma classe que representa os produtos pharmaceutics com prescrição.
 *
 * @author Bernardo Mendes
 * @author Gabriel Almeida
 * @version 1.0
 */
public class PharmaProductWithPrescription extends PharmaProduct {
    /**
     * doctor é uma string que contém o nome do médico que prescreveu o produto.
     */
    private String doctor;

    /**
     * Construtor para a classe PharmaProductWithPrescription
     * @param code Código do Produto
     * @param name Nome do Produto
     * @param description Descrição do Produto
     * @param amount Quantidade do Produto
     * @param unitValue Valor da Unidade por Produto
     * @param doctor Médico que prescreveu o produto
     */
    PharmaProductWithPrescription(int code, String name, String description, int amount, double unitValue, Boolean hasPrescription, String doctor) {
        super(code, name, description, amount, unitValue, hasPrescription);
        this.doctor = doctor;
    }

    /**
     * Método para calcular a taxa do produto baseado na localização
     * @param location Localização do Produto
     * @return TaxRate Taxa Sujeita ao Produto
     */
    @Override
    public double calculateTax(Location location) {
        double taxRate = 0;
        switch (location) {
            case PortugalContinental:
                taxRate = 6;
                break;
            case Madeira:
                taxRate = 5;
                break;
            case Açores:
                taxRate = 4;
                break;
        }
        return taxRate;
    }

    /**
     * Método que retorna uma descrição do produto
     * @return String Descrição do Produto
     */
    public String toString() {
        return "Produto farmacêutico com prescrição do Dr. "+ doctor;
    }

    /**
     * Método para escrever no ficheiro o produto farmacêutico com prescrição
     * @param bw BufferedWriter
     * @throws IOException Exceção de I/O
     */
    public void writeFile(BufferedWriter bw) throws IOException {
        bw.write("PPWP" + ";");
        bw.write(getCode() + ";");
        bw.write(getName() + ";");
        bw.write(getDescription() + ";");
        bw.write(getAmount() + ";");
        bw.write(getUnitValue() + ";");
        bw.write(doctor + ",");
    }
}
