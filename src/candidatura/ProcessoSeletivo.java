//Projeto feito no bootcamp Java da DIO
package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        //imprimirSelecionados();
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        for (String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentativasRealizadas++;
            }else {
                System.out.println("Contato com "+candidato+" realizado com sucesso!");
            }
        }while(continuarTentando && tentativasRealizadas<3);
        if (atendeu){
            System.out.println("Conseguimos contato com o(a) "+candidato+" Na "+tentativasRealizadas+" tentativa!");
        }else{
            System.out.println("Não conseguimos contato com "+candidato+"! Numero maximo de tentativas: "+tentativasRealizadas);
        }
    }

    //metodo auxiliar simulando uma ligação com 3 tentativas onde no (1) a pessoa atendeu e nos demais numero não atendeu
    static boolean atender (){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        for (int indice = 0; indice < candidatos.length; indice ++){
            System.out.println("O candidato de n° "+ (indice+1) + " é "+candidatos[indice]);
        }

        /* Abaixo uma forma abreviada de percorrer o indice dos candidatos usando for each:

        for (String candidato: candidatos){
            System.out.println("\nO candidato selecionado foi " + candidato);
        }
        */
    }

    static void selecaoCandidatos(){
        // array com os nomes dos candidatos
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JOAO"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato(a) "+candidato+" solicitou este valor de salario "+salarioPretendido);
            if (salarioBase>=salarioPretendido){
                System.out.println("O candidato(a) "+candidato+" foi selecionado para a vaga");
                candidatosSelecionados++; //sempre ir para o proximo candidato(numero)
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    public static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra-proposta");
        }else{
            System.out.println("Aguardando resultado dos demais candidatos");
        }
    }
}
