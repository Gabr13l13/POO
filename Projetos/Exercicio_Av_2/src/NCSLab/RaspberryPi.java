package NCSLab;

/**
 * Classe para gerir os raspberryPi
 * @author Bernardo Mendes 2023195718
 * @author Gabriel Almeida 2023226622
 * @version 1.0
 */
public class RaspberryPi extends Computadores {
    /**
     * Construtor para o RaspberryPi
     */
    public RaspberryPi() {
        super();
        double memoryRAM = super.generateRAM(3, 1);
        double disk = super.generateDisk(4, 4);
        float cpu = super.generateCPU(1);
        boolean architecture = super.generateArchitecture();
        super.setRamMemory(memoryRAM);
        super.setDiskSpace(disk);
        super.setCpu(cpu);
        super.setArchitecture(architecture);
        super.setLevel("IoT");
        super.setEnergyConsumption(generateEnergyConsumption());
    }

    /**
     * Método para gerar o consumo de energia do RaspberryPi
     *
     * @return double com o consumo de energia do RaspberryPi tendo em conta a frequência da CPU
     */

    @Override
    public double generateEnergyConsumption() {
        return Math.round((getCpu() * 20)*10) /10.0;
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
        return "RaspberryPi (Level " + getLevel() + "):\nID: " + getId() + " | RAM: " + getRamMemory() + "GB | Disk: " + getDiskSpace() + "GB | CPU: " + getCpu() + " | Architecture: " + architecture;
    }
}
