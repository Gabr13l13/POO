 public class Exercicio1 {
    /**
     * Método que calcula o salário do médico tendo em conta os anos de serviço, horas extras e salário base da especialidade.
     * @param especialidades Array de especialidades no formato "nome/salário base/custo da hora extra".
     * @param especialidade Especialidade do médico.
     * @param anosServico Anos de serviço do médico.
     * @param horasExtra Horas extras trabalhadas pelo médico.
     * @return Salário calculado do médico.
     */
    private static double salario(String[] especialidades, String especialidade, int anosServico, int horasExtra ) {
        double salario = 0;
        for(int i = 0; i < especialidades.length; i++) {
            String[] arrayE = especialidades[i].split("/");
            String espec = arrayE[0].toLowerCase();
            if(espec.equals(especialidade.toLowerCase())) {
                //Salário Base
                salario = Integer.parseInt(arrayE[1]);
                // Calculo do Juro Composto com Base nos Anos de Serviço (4% por cada 5 anos)
                salario *= Math.pow(1.04, (float)anosServico/5);
                //Horas Extra
                salario += horasExtra*Integer.parseInt(arrayE[2]);
            }
        }
        //Arredondar o salário para uma casa decimal
        salario = Math.round(salario*10.0)/10.0;
        return salario;
    }

    /**
     *  Método que cria um array com as especialidades dos médicos.
     * @param especialidades
     * @return arrayEspecialidades Array com as especialidades dos médicos por 
     */
    private static String[] arrayEspecialidades(String[] especialidades){

        String[] arrayEspecialidades = new String[especialidades.length];
        //Guardar o nome da especialidade no mesmo índice do array de especialidades
        for(int i = 0; i < especialidades.length; i++) {
            String[] arrayE = especialidades[i].split("/");
            arrayEspecialidades[i] = arrayE[0];

        }
        return arrayEspecialidades;
    }

    /**
     * Método que calcula o salário total de cada especialidade.
     * @param medicos
     * @param especialidades
     * @return sal_array Array com o salário total de cada especialidade.
     */
    private static double[] salarioEspecialidades(String [] medicos, String [] especialidades){
        double[] sal_array = new double[especialidades.length];

        for(int i = 0; i < medicos.length; i++) {

            String[] arrayM = medicos[i].split("/");
            //Verificar a especialidade do médico através da método verificarEspecialidade
            String especialidade = arrayM[1].toLowerCase();
            //Calcular o salário do médico através da método salario
            double salario_medico = salario(especialidades, especialidade, Integer.parseInt(arrayM[2]), Integer.parseInt(arrayM[3]));
            //Imprimir o nome do médico e o seu salário caso a especialidade seja válida
            if (!especialidade.isEmpty()) {
                System.out.println(arrayM[0] + ": "+ salario_medico + "€");   
            }
            //Guardar o salário total de cada especialidade
            for (int j = 0; j < especialidades.length; j++) {
                String[] arrayE = especialidades[j].split("/");
                //Comparar a especialidade do médico com as especialidades dadas no array de especialidades
                if (especialidade.equalsIgnoreCase(arrayE[0])) {
                    sal_array[j] += salario_medico;
                    break;
                }
            }
        }
        return sal_array;
    }

    public static void main(String[] args) {

        String[] especialidades = {
            //nome/salário base/custo da hora extra
            "Radiologia/2030/50",
            "Oftalmologia/2500/70",
            "Pediatria/2700/75"
            };
            String[] medicos = {
            //nome/especialidade/anos de serviço/horas extra
            "Vasco Santana/radiologia/15/10",
            "Laura Alves/oftalmologia/5/7",
            "António Silva/oftalmologia/12/5"
            };
        //Tabela com o salário total de cada especialidade
        double[] salarios = salarioEspecialidades(medicos, especialidades);
        //Tabela com as especialidades dos médicos
        String[] arrayE = arrayEspecialidades(especialidades);
        //Separação entre as tabelas
        System.out.println();
        //Imprimir o sal&aacute;rio total de cada especialidade
        for(int i = 0; i < salarios.length; i++) {
            if(salarios[i] != 0){
                System.out.printf("%s: %.1f€\n",arrayE[i], salarios[i]);
            }
        }
    }
}