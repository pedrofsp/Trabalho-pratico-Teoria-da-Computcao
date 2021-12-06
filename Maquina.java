// classe para lidar com MT

import java.util.ArrayList; 

public class Maquina {
    private Fita fita = new Fita(); // cria uma fita vazia
    private Estado estadoAtual; // estado atual na atuacao
    public ArrayList<Estado> estados = new ArrayList<Estado>(); // arraylist dos estados da MT
 
    String simboloAtual; // em qual "letra" da palavra esta
    Transicao transicao; // qual transicao seguir

    public void AdicionaEstado(Estado p_estado, boolean inicial ){ // adiciona estados na maquina {q0, q1, q2, etc.}
        estados.add(p_estado); // adiciona estado para MT
        if(inicial){ // se o estado for inicial, estado atual eh o estado
            estadoAtual = p_estado; 
        }
    }

    public void SetEntrada(String entrada){ // insere palavra na MT
        fita.Mover(Direcao.DIREITA); // salta o primeiro branco
        for (int i =0 ; i<entrada.length(); i++){ // escreve palavra na fita
            if (entrada.charAt(i) == 'a') fita.Escrever(Simbolo.a.getSimbolo()); // se palavra for 1, insere a na fita
            else if (entrada.charAt(i) == 'b') fita.Escrever(Simbolo.b.getSimbolo()); // se palavra for 11,insere b na fita
            else{ 
                fita.Escrever("B"); // senao, 111, B na fita
            }
            
            fita.Mover(Direcao.DIREITA); // move ponteiro da fita para direita
        }

        while(fita.posicao != 0) fita.Mover(Direcao.ESQUERDA); // move para esquerda enquanto nao for o inicio da fita
    }

    public void printConteudoMaquina(){ // imprime conteudo da MT
        fita.printConteudo();
    }

    
    // public boolean Atuar(){ // executa uma operação na MT e suas posicoes
    //     simboloAtual = this.fita.Ler();
    //     transicao = this.estadoAtual.obterTransicao(simboloAtual);
        
    //     if(transicao != null){
    //         System.out.println("Transicao: " + transicao);
    //         System.out.print("Fita: ");
    //         fita.printConteudo();
    //         System.out.println();
    //     }
        
    //     return false;
    // }

}
