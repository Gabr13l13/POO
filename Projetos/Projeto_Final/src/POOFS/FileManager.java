package POOFS;

import java.io.*;
import java.util.ArrayList;
/**
 * Classe FileManager
 * Esta classe é a classe responsável pela gestão dos ficheiros.
 * (Exportar e Importar)
 * @author Bernardo Mendes
 * @author Gabriel Almeida
 * @version 1.0
 */
public class FileManager{

    /**
     * Construtor da Classe FileManager
     */
    public FileManager(){
    }

    /**
     * Método para exportar as faturas para o ficheiro invoices.txt
     * Recebe como parâmetro o objeto poofs que contém todas as informações
     */

    public void exportInvoices(POOFS poofs) {
        File fileobj = new File("src/POOFS/invoices.obj");
        try{
            FileOutputStream fos = new FileOutputStream(fileobj);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(poofs);
            oos.close();
        }   catch(FileNotFoundException ex){
            System.out.println("Erro a criar ficheiro.");
        }   catch (IOException ex){
            System.out.println("Erro a escrever para o ficheiro.");
        }
        System.out.println("Obrigado pela utilização!");
    }

    /**
     * Método para Importar as faturas do ficheiro invoices.txt
     * Recebe como parâmetros a ArrayList Invoices e Clients, para lhes adicionar a informação lida
     */

    public POOFS importInvoices(POOFS poofs) {
        File fobj = new File("src/POOFS/invoices.obj");
        if (fobj.exists() && fobj.isFile()) {
            try {
                FileInputStream fis = new FileInputStream(fobj);
                ObjectInputStream ois = new ObjectInputStream(fis);
                poofs = (POOFS) ois.readObject();
                ois.close();
                fis.close();
            } catch (IOException ex) {
                System.out.println("Erro a ler o ficheiro.");
            } catch (ClassNotFoundException e) {
                System.out.println("Erro a converter o objeto.");
            }
        } else {
            File f = new File("src/POOFS/invoices.txt");
            if (f.exists() && f.isFile()) {
                try {
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] splittedLine = line.split(",");
                        int invoiceNum = Integer.parseInt(splittedLine[0]);
                        String[] clientInfo = splittedLine[1].split(";");
                        Client client = new Client(clientInfo[0], clientInfo[1], Location.valueOf(clientInfo[2]));
                        poofs.getClients().add(client);
                        String date = splittedLine[2];

                        ArrayList<Product> products = new ArrayList<>();
                        for (int i = 3; i < splittedLine.length; i++) {
                            String[] productInfo = splittedLine[i].split(";");
                            switch (productInfo[0]) {
                                case "RT":
                                    String[] certification = productInfo[7].split("/");
                                    ArrayList<Certification> certifications = new ArrayList<Certification>();
                                    for (String s : certification) {
                                        certifications.add(Certification.valueOf(s));
                                    }
                                    ReducedTax reducedTaxProduct = new ReducedTax(
                                            Integer.parseInt(productInfo[1]),
                                            productInfo[2],
                                            productInfo[3],
                                            Integer.parseInt(productInfo[4]),
                                            Double.parseDouble(productInfo[5]),
                                            Boolean.parseBoolean(productInfo[6]),
                                            certifications
                                    );
                                    products.add(reducedTaxProduct);
                                    break;
                                case "IT":
                                    IntermediateTax intermediateTaxProduct = new IntermediateTax(
                                            Integer.parseInt(productInfo[1]),
                                            productInfo[2],
                                            productInfo[3],
                                            Integer.parseInt(productInfo[4]),
                                            Double.parseDouble(productInfo[5]),
                                            Boolean.parseBoolean(productInfo[6]),
                                            IntermediateTaxCategory.valueOf(productInfo[7])
                                    );
                                    products.add(intermediateTaxProduct);
                                    break;
                                case "NT":
                                    NormalTax normalTaxProduct = new NormalTax(
                                            Integer.parseInt(productInfo[1]),
                                            productInfo[2],
                                            productInfo[3],
                                            Integer.parseInt(productInfo[4]),
                                            Double.parseDouble(productInfo[5]),
                                            Boolean.parseBoolean(productInfo[6])
                                    );
                                    products.add(normalTaxProduct);
                                    break;
                                case "PPWP":
                                    PharmaProductWithPrescription pharmaProductWithPrescription = new PharmaProductWithPrescription(
                                            Integer.parseInt(productInfo[1]),
                                            productInfo[2],
                                            productInfo[3],
                                            Integer.parseInt(productInfo[4]),
                                            Double.parseDouble(productInfo[5]),
                                            true,
                                            productInfo[6]
                                    );
                                    products.add(pharmaProductWithPrescription);
                                    break;
                                case "PP":
                                    PharmaProductWithoutPrescription pharmaProductWithoutPrescription = new PharmaProductWithoutPrescription(
                                            Integer.parseInt(productInfo[1]),
                                            productInfo[2],
                                            productInfo[3],
                                            Integer.parseInt(productInfo[4]),
                                            Double.parseDouble(productInfo[5]),
                                            false,
                                            PharmaProductCategory.valueOf(productInfo[6])
                                    );
                                    products.add(pharmaProductWithoutPrescription);
                                    break;
                            }
                        }

                        Invoice invoice = new Invoice(invoiceNum, client, date, products);
                        poofs.getInvoices().add(invoice);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Não existe o ficheiro.");
            }
        }
        return poofs;
    }

    /**
     * Método para exportar faturas para ficheiro de texto
     * @param poofs Objeto POOFS com a informação toda do programa
     */

    public void exportInvoicesForTXT(POOFS poofs){
        File f = new File("src/POOFS/invoices.txt");
        if (f.exists() && f.isFile()) {
            try{
                FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Invoice invoice : poofs.getInvoices()) {
                    bw.write(invoice.getInvoiceNum() + "," + invoice.getClient().getName() + ";" + invoice.getClient().getTaxNumber() + ";" + invoice.getClient().getLocation() + "," + invoice.getDate() + ",");
                    for (Product product : invoice.getProducts()) {
                         product.writeFile(bw);
                    }
                    bw.write("\n");
                }
                bw.close();
                fw.close();
                System.out.println("Exportado com sucesso.");
            }
            catch (IOException ex) {
                System.out.println("Erro a exportar para o ficheiro.");
            }
        }
        else{
            System.out.println("O ficheiro não existe.");
        }
    }

}
