package NCSLab;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe NCSLab para verificar as funcionalidades dos computadores
 * Esta classe contém o método main que cria instâncias de diferentes tipos de computadores
 * e permite ao usuário interagir com eles através de um menu.
 *
 * @author Bernardo Mendes 2023195718
 * @author Gabriel Almeida 2023226622
 * @version 1.0
 */

public class NCSLab {

    /**
     * Construtor da classe NCSLab.
     */
    public NCSLab() {
        // Construtor padrão
    }

    /**
     * Método para exibir o menu e as opções possíveis ao usuário
     */

    private void showMenu() {
        System.out.println("--------------------");
        System.out.println("Escolha uma opção:");
        System.out.println("[1] - Mostrar todos os computadores criados");
        System.out.println("[2] - Mostrar todos os computadores com arquitetura x64");
        System.out.println("[3] - Mostrar o consumo energético de todos os computadores");
        System.out.println("[4] - Sair");
        System.out.println("Opção: ");
    }

    /**
     * Método para gerar 15 computadores (tal como solicitado)
     * São gerados 5 Laptops, 5 RaspberryPIs e 5 Servidores
     *
     * @return Retorna os 15 computadores numa ArrayList da classe Computadores
     */

    private ArrayList<Computadores> generateComputers() {
        ArrayList<Computadores> computers = new ArrayList<Computadores>();
        for (int i = 0; i < 5; i++) {
            computers.add(new Laptop());
        }
        for (int i = 0; i < 5; i++) {
            computers.add(new RaspberryPi());
        }
        for (int i = 0; i < 5; i++) {
            computers.add(new Servidor());
        }
        return computers;
    }

    /**
     * Método para exibir a AsciiArt que aparece ao inicializar o programa
     */

    private void showAsciiArt() {
        String asciiArt =
                """
                                  _        _______  _______  _        _______  ______
                                 ( (    /|(  ____ \\(  ____ \\( \\      (  ___  )(  ___ \\
                                 |  \\  ( || (    \\/| (    \\/| (      | (   ) || (   ) )
                                 |   \\ | || |      | (_____ | |      | (___) || (__/ /
                                 | (\\ \\) || |      (_____  )| |      |  ___  ||  __ (
                                 | | \\   || |            ) || |      | (   ) || (  \\ \\
                                 | )  \\  || (____/\\/\\____) || (____/\\| )   ( || )___) )
                                 |/    )_)(_______/\\_______)(_______/|/     \\||/ \\___/
                        \s
                                                             .---------.\s
                                                             |  |   |  |        |‾‾‾‾‾‾‾‾‾|
                                                             |  |   |  |        |  |‾‾‾|  |
                                                             |\\_______/|        |   ‾‾‾   |
                                                             |_________|\\_      |  o   o  |
                                                           _____________  \\_    |  /‾‾‾\\  |
                                                          /.............\\   |   | | /‾\\ | |
                                                         |...............| /T\\  | | \\_/ | |
                                                         |...............|| | | |  \\___/  |
                                                          \\_____________/  \\_/  |_________|
                        \s
                                  Desenvolvido por: Bernardo Mendes e Gabriel Almeida
                        \s""";

        System.out.println(asciiArt);
    }

    /**
     * Método que exibe todas as informações dos computadores
     *
     * @param computers ArrayList de Computadores
     */

    private void showEveryComputer(ArrayList<Computadores> computers) {
        System.out.println("----------------");
        System.out.println("Todos os computadores criados:");
        for (Computadores computer : computers) {
            System.out.println(computer);
        }
    }

    /**
     * Método que exibe todos os computadores cuja arquitetura é de x64, assim como as suas informações
     *
     * @param computers ArrayList de Computadores
     */

    private void showComputersx64(ArrayList<Computadores> computers) {
        System.out.println("----------------");
        System.out.println("Todos os computadores com arquitetura x64:");
        for (Computadores computer : computers) {
            if (computer.getArchitecture()) {
                System.out.println(computer);
            }
        }
    }

    /**
     * Método que exibe o consumo energético de todos os computadores
     *
     * @param computers ArrayList de Computadores
     */

    private void showEnergeticConsume(ArrayList<Computadores> computers) {
        System.out.println("----------------");
        System.out.println("Consumo energético dos computadores:");
        for (Computadores computer : computers) {
            System.out.println(computer + " | Energy Consumption: " + computer.getEnergyConsumption());
        }
    }


    /**
     * Método main para testar as funcionalidades dos computadores.
     * Este método cria uma lista de computadores, exibe um menu para o usuário e
     * executa ações com base na escolha do usuário.
     *
     * @param args Argumentos da linha de comandos
     */
    public static void main(String[] args) {

        NCSLab ncsLab = new NCSLab();

        ArrayList<Computadores> computers = ncsLab.generateComputers();

        ncsLab.showAsciiArt();

        int menu = 0;
        Scanner scanner = new Scanner(System.in);

        while (menu != 4) {
            ncsLab.showMenu();
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    ncsLab.showEveryComputer(computers);
                    break;
                case 2:
                    ncsLab.showComputersx64(computers);
                    break;
                case 3:
                    ncsLab.showEnergeticConsume(computers);
                    break;
                default:
                    break;
            }
        }
    }
}