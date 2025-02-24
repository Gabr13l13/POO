package NCSLab;

import java.util.Random;

/**
 * Classe para gerir os computadores
 *
 * @author Bernardo Mendes 2023195718
 * @author Gabriel Almeida 2023226622
 * @version 1.0
 */
public class Computadores {

    /**
     * Número de Computadores totais criados
     */
    private static int countComputers = 0;
    /**
     * Capacidade de memória RAM do computador
     */
    private double ramMemory; // RAM (GB)
    /**
     * ID gerado pelo HelpDesk
     */
    private int id;
    /**
     * Espaço em disco do computador
     */
    private double diskSpace;
    /**
     * Frequência da CPU do computador (GHz)
     */
    private float cpu;
    /**
     * Arquitetura do computador (True means x64 --- False means ARM)
     */
    private boolean architecture;
    /**
     * Nível do Computador
     */
    private String level;
    /**
     * Consumo de energia do computador
     */
    private double energyConsumption;

    /**
     * Construtor
     */
    public Computadores() {
        addCounter();
        setId(getCountComputers());
    }

    /**
     * Método de acesso externo ao número de computadores
     *
     * @return Número de computadores
     */
    public int getCountComputers() {
        return countComputers;
    }

    /**
     * Método de acesso externo à memória RAM
     *
     * @return Memória RAM
     */
    public double getRamMemory() {
        return ramMemory;
    }

    /**
     * Método de acesso externo ao ID
     *
     * @return ID do Computador
     */
    public int getId() {
        return id;
    }

    /**
     * Método de acesso externo ao espaço em disco
     *
     * @return Espaço em disco
     */
    public double getDiskSpace() {
        return diskSpace;
    }

    /**
     * Método de acesso externo à frequência da CPU
     *
     * @return Frequência da CPU
     */
    public float getCpu() {
        return cpu;
    }

    /**
     * Método de acesso externo à arquitetura
     *
     * @return Booleano Identificador da Arquitetura
     */
    public boolean getArchitecture() {
        return architecture;
    }

    /**
     * Método de acesso externo ao Nível do Computador
     *
     * @return String Nível do Computador
     */
    public String getLevel() {
        return level;
    }

    /**
     * Método de acesso externo ao Consumo de Energia
     *
     * @return Energy Consumption
     */
    public double getEnergyConsumption() {
        return energyConsumption;
    }

    /**
     * Método de incrementar o counter de computadores
     */

    private void addCounter() {
        countComputers++;
    }

    /**
     * Método para dar set ao ID do Computador
     *
     * @param id ID gerado pelo Helpdesk
     */

    private void setId(int id) {
        this.id = id;
    }

    /**
     * Método para dar set à Memória RAM do Computador
     *
     * @param ramMemory Memória RAM
     */

    public void setRamMemory(double ramMemory) {
        this.ramMemory = ramMemory;
    }

    /**
     * Método para dar set ao Espaço do Disco do Computador
     *
     * @param diskSpace Espaço do Disco
     */

    public void setDiskSpace(double diskSpace) {
        this.diskSpace = diskSpace;
    }

    /**
     * Método para dar set à CPU do Computador
     *
     * @param cpu Frequência da CPU
     */

    public void setCpu(float cpu) {
        this.cpu = cpu;
    }

    /**
     * Método para dar set à Arquitetura do Computador
     *
     * @param architecture Arquitetura do Computador (x64 ou ARM)
     */

    public void setArchitecture(boolean architecture) {
        this.architecture = architecture;
    }

    /**
     * Método para dar set ao Nível do Computador
     *
     * @param level Nível do Computador (Cloud, Edge, IoT)
     */

    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Método para dar set ao Consumo de Energia do Computador
     *
     * @param energyConsumption Consumo de Energia
     */
    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    /**
     * Método para gerar um valor de RAM
     * A função vai receber como parâmetros o valor máximo, que depende de cada tipo de computador (Laptop, RaspberryPI ou Servidor)
     * e posteriormente adiciona o compensator, para determinar o expoente dentro do intervalo correto.
     * Por exemplo,
     * para os RaspberryPIs, a RAM pode estar inserida entre 2 a 8 GB. Como tal, os expoentes da base de dois poderão estar entre
     * 1 e 3, inclusive. Para tal, vamos gerar um inteiro com o parâmetro max que deverá ser 3, através do random.nextInt(max)
     * Desta forma, os valores possíveis são 0, 1 ou 2 (já que o 3 é exclusivo). Posteriormente, adicionamos o compensator que
     * no caso dos RaspberryPIs será 1. Deste modo, o expoente será 1, 2 ou 3, que em base de dois será 2, 4 ou 8 GBs.
     *
     * @param max         Valor máximo
     * @param compensator Compensador
     * @return MemoryRAM
     */

    public double generateRAM(int max, int compensator) {
        Random random = new Random();
        int exp = random.nextInt(max);
        exp += compensator;
        return Math.pow(2, exp);
    }

    /**
     * Método para gerar o espaço do disco do computador.
     * Segue a mesma estratégia que o método generateRAM.
     *
     * @param max         Valor máximo
     * @param compensator Compensador
     * @return DiskSpace
     */

    public double generateDisk(int max, int compensator) {
        Random random = new Random();
        int exp = random.nextInt(max);
        exp += compensator;
        return Math.pow(2, exp);
    }

    /**
     * Método para gerar o valor da CPU.
     * Segue uma estratégia parecida com o método generateRAM
     * Neste caso, geramos um float (0.0 a 1.0) e adicionamos o compensator.
     * Por exemplo, no caso do compensator, adicionamos 1 de modo a ficar entre 1.0 e 2.0.
     * O valor é arredondado à primeira casa decimal.
     *
     * @param compensator Compensador
     * @return CPU
     */

    public float generateCPU(int compensator) {
        Random random = new Random();
        return Math.round((random.nextFloat() + compensator) * 10) / 10.0f;
    }

    /**
     * Método para gerar a Arquitetura do Computador.
     * Irá gerar um booleano aleatório, de modo a decidir se será x64 (True) ou ARM (False)
     *
     * @return Architecture in Boolean
     */

    public boolean generateArchitecture() {
        Random random = new Random();
        return random.nextBoolean();
    }

    /**
     * Método para gerar o Consumo de Energia do Computador.
     *
     * @return (0.0)
     */
    public double generateEnergyConsumption() {
        return 0.0;
    }

    /**
     * Método toString para definir para as subclasses Laptop/RaspberryPI/Servidor.
     *
     * @return emptyString
     */
    @Override
    public String toString() {
        return "";
    }
}