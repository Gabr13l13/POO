package POOFS;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * ReducedTax é uma classe que representa um produto alimentar com imposto reduzido.
 *
 * @author Bernardo Mendes
 * @author Gabriel Almeida
 * @version 1.0
 */
public class ReducedTax extends FoodProduct {
    /**
     * certification é uma ArrayList que vai conter todos as certificações do produto de taxa reduzida
     */
    private ArrayList<Certification> certification_list;

    /**
     * Constutor para a classe ReducedTax
     * @param code Código do produto
     * @param name Nome do produto
     * @param description Descrição do produto
     * @param amount Quantidade do produto
     * @param unitValue Valor unitário
     * @param isBiologic Se produto é ou não biológico
     * @param certification_list Certificações do produto
     */
    public ReducedTax(int code, String name, String description, int amount, double unitValue, boolean isBiologic, ArrayList<Certification> certification_list) {
        super(code, name, description, amount, unitValue, isBiologic);
        this.certification_list = certification_list;
    }

    // Getters and Setters

    /**
     * Método que adiciona certificações ao ArrayList certification
     * @param certification Certificação
     */
    public void setCertification(Certification certification) {
        this.certification_list.add(certification);
    }

    /**
     * Método para obter a ArrayList de Certificações do Produto
     * @return certification ArrayList de Certificações
     */
    public ArrayList<Certification> getCertification() {
        return certification_list;
    }

    // Métodos

    /**
     * Método para calcular a taxa do produto
     * @return TaxRate Taxa Sujeita ao Produto
     */
    @Override
    public double calculateTax(Location location) {

        int numCertification = certification_list.size();
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
        if(numCertification == 4){
            taxRate -= 1;
        }
        if(this.isBiologic()){
            taxRate = taxRate * 0.9;
        }
        taxRate = Math.round(taxRate*100) / 100.0;
        this.setTaxRate(taxRate);
        return taxRate;
    }

    public String toString(){
        String certifications = "";
        for (Certification certification : certification_list) {
            certifications = certifications + certification.toString() + ", " ;
        }
        certifications = certifications.substring(0, certifications.length()-2);
        if(isBiologic()){
            return "Produto Biológico com " + certification_list.size() + " certificações de taxa reduzida.\n" + "Certificações: \n" + certifications;
        }
        else{
            return "Produto não Biológioc com " + certification_list.size() + " certificações de taxa reduzida.\n" + "Certificações: \n" + certifications;
        }
    }
    public void writeFile(BufferedWriter bw) throws IOException {
        bw.write("RT" + ";");
        bw.write(getCode() + ";");
        bw.write(getName() + ";");
        bw.write(getDescription() + ";");
        bw.write(getAmount() + ";");
        bw.write(getUnitValue() + ";");
        bw.write(isBiologic() + ";");
        for(Certification certification : certification_list){
            if(certification_list.size() > 1){
                if(certification == certification_list.getLast()){
                    bw.write(certification.toString() + ",");
                }
                else {
                    bw.write(certification.toString() + "/");
                }
            }
            else{
                bw.write(certification.toString() + ",");
            }
        }

    }
}
