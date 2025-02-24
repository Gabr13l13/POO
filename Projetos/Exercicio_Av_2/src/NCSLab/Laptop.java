package NCSLab;

import java.util.Random;

/**
 * Classe para gerir os laptops
 *
 * @author Bernardo Mendes 2023195718
 * @author Gabriel Almeida 2023226622
 * @version 1.0
 */
public class Laptop extends Computadores {

    /**
     * Existência ou Inexistência de uma GPU no Laptop (Característica única dos Laptops)
     */

    public boolean gpu;

    /**
     * Construtor para o Laptop
     */

    public Laptop() {
        super();
        double memoryRAM = super.generateRAM(3, 4);
        double disk = super.generateDisk(3, 8);
        float cpu = super.generateCPU(2);
        boolean architecture = super.generateArchitecture();
        boolean gpu = this.generateGPU();
        super.setRamMemory(memoryRAM);
        super.setDiskSpace(disk);
        super.setCpu(cpu);
        super.setArchitecture(architecture);
        this.gpu = gpu;
        super.setLevel("Edge");
        super.setEnergyConsumption(generateEnergyConsumption());
    }

    /**
     * Método para gerar a existência (ou inexitência) de uma GPU, característica particular dos Laptops.
     *
     * @return boolean relacionado à existência da GPU (true se tiver GPU, false se não tiver GPU)
     */

    private boolean generateGPU() {
        Random random = new Random();
        return random.nextBoolean();
    }

    /**
     * Método para gerar o consumo de energia do Laptop
     *
     * @return double com o consumo de energia do Laptop tendo em conta a frequência da CPU e se tem GPU
     */
    @Override
    public double generateEnergyConsumption() {
        if (this.gpu) {
            return Math.round((50 * getCpu() * 1.2) * 10) / 10.0;
        } else {
            return Math.round((50 * getCpu()) * 10) / 10.0;
        }
    }

    /**
     * Método toString para dar print às informações do computador
     *
     * @return String com todas as informações do computador
     */

    @Override
    public String toString() {
        String architecture = "ARM";
        if (super.getArchitecture()) {
            architecture = "x64";
        }

        String gpu = "No";
        if (this.gpu) {
            gpu = "Yes";
        }

        return "Laptop (Level " + getLevel() + "):\nID: " + getId() + " | RAM: " + getRamMemory() + "GB | Disk: " + getDiskSpace() + "GB | CPU: " + getCpu() + " | Architecture: " + architecture + " | GPU: " + gpu;
    }
}