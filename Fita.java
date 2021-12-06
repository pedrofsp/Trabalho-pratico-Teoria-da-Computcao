//Classe que representa a fita de uma máquina de turing.

import java.util.ArrayList; 

public class Fita { 
    public int posicao; //posicao do leitor na fita
    ArrayList<String> conteudo = new ArrayList<String>(); //conteudo da fita
    private String aux;

    Fita(){
        this.conteudo.add(Simbolo.B.getSimbolo()); // inicia a fita com um simbolo branco inicial 
        this.conteudo.add(Simbolo.B.getSimbolo()); //e final
        this.posicao = 0; // posicao inicia no zero
    }

    public String Ler(){
        return this.conteudo.get(this.posicao); // ler o conteudo da fita
    } 

    public void Escrever(String simbolo){ // insere palavra na fita
        this.conteudo.set(this.posicao, simbolo);
    }

    public void Mover(Direcao p_direcao){ // move o ponteiro de leitura/escrita da fita para uma determinada direção (ESQUERDA ou DIREITA)
        if(p_direcao == Direcao.DIREITA)
            this.posicao = this.posicao + 1; //caso direcao seja DIREITA o a posicao do leitor e incrementada
        else
            this.posicao = this.posicao - 1; //caso direcao seja ESQUERDA o a posicao do leitor e decrementada

        if(this.posicao == this.conteudo.size()){
            this.conteudo.add(Simbolo.B.getSimbolo());
        }
    }

    public String printConteudo(){ // imprime os conteudos da fita
        for(int i = 0; i < this.conteudo.size(); i++){
            aux += conteudo.get(i) ;
            aux += " ";
        }
        return aux;
    }
}
