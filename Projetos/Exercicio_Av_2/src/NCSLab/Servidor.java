package NCSLab;

/**
 * Classe para gerir os servidores
 * @author Bernardo Mendes 2023195718
 * @author Gabriel Almeida 2023226622
 * @version 1.0
 */
public class Servidor extends Computadores {
    /**
     * Construtor para o Servidor
     */
    public Servidor() {
        super();
        double memoryRAM = super.generateRAM(3, 7);
        double disk = super.generateDisk(5, 10);
        float cpu = super.generateCPU(3);
        boolean architecture = super.generateArchitecture();
        super.setRamMemory(memoryRAM);
        super.setDiskSpace(disk);
        super.setCpu(cpu);
        super.setArchitecture(architecture);
        super.setLevel("Cloud");
        super.setEnergyConsumption(generateEnergyConsumption());
    }

    /**
     * Método para gerar o consumo de energia do Servidor
     *
     * @return double com o consumo de energia do Servidor tendo em conta a frequência da CPU
     */

    @Override
    public double generateEnergyConsumption() {
        return Math.round((getCpu() * 80) * 10) / 10.0;
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
        return "Servidor (Level " + getLevel() + "):\nID: " + getId() + " | RAM: " + getRamMemory() + "GB | Disk: " + getDiskSpace() + "GB | CPU: " + getCpu() + " | Architecture: " + architecture;
    }
}


