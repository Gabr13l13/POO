package POOFS;
/**
 * Classe MenuManager
 * Esta classe é responsável por gerir o menu da aplicação.
 *
 * @author Bernardo Mendes
 * @author Gabriel Almeida
 * @version 1.0
 */
public class MenuManager {
    /**
     * Construtor da classe MenuManager
     */
    public MenuManager(){

    }
    /**
     * Método para mostrar a ASCII Art no menu
     */
    public void showASCII() {
        String asciiArt =
                """
                                 _______   ______   ______  ________  ______
                                |       \\ /      \\ /      \\|        \\/      \\
                                | ▓▓▓▓▓▓▓\\  ▓▓▓▓▓▓\\  ▓▓▓▓▓▓\\ ▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓\\
                                | ▓▓__/ ▓▓ ▓▓  | ▓▓ ▓▓  | ▓▓ ▓▓__   | ▓▓___\\▓▓
                                | ▓▓    ▓▓ ▓▓  | ▓▓ ▓▓  | ▓▓ ▓▓  \\   \\▓▓    \\
                                | ▓▓▓▓▓▓▓| ▓▓  | ▓▓ ▓▓  | ▓▓ ▓▓▓▓▓   _\\▓▓▓▓▓▓\\
                                | ▓▓     | ▓▓__/ ▓▓ ▓▓__/ ▓▓ ▓▓     |  \\__| ▓▓
                                | ▓▓      \\▓▓    ▓▓\\▓▓    ▓▓ ▓▓      \\▓▓    ▓▓
                                 \\▓▓       \\▓▓▓▓▓▓  \\▓▓▓▓▓  \\▓▓       \\▓▓▓▓▓▓
                        \s
                                           ,..........   ..........,
                                       ,..,'          '.'          ',..,
                                      ,' ,' Financial  :   Services ', ',
                                     ,' ,'             :             ', ',
                                    ,' ,'              :              ', ',
                                   ,' ,'............., : ,.............', ',
                                  ,'  '............   '.'   ............'  ',
                                   '''''''''''''''''';''';''''''''''''''''''
                                                      '''
                        \s
                        Desenvolvido por: Bernardo Mendes e Gabriel Almeida
                        """;
        System.out.println(asciiArt);
    }

    /**
     * Método para mostrar o menu da aplicação
     */
    public void showMenu() {
        System.out.println("Escolha um opção:");
        System.out.println("[1] Criar e editar cliente");
        System.out.println("[2] Lista de clientes");
        System.out.println("[3] Criar e editar faturas");
        System.out.println("[4] Listar faturas");
        System.out.println("[5] Visualizar fatura");
        System.out.println("[6] Estatísticas");
        System.out.println("[7] Exportar para ficheiro de texto");
        System.out.println("[8] Sair");
        System.out.print("Opção: ");
    }
}
