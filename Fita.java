import java.util.ArrayList; 

public class Fita {
    public int posicao;
    ArrayList<String> conteudo = new ArrayList<String>();
    
    public String aux;

    Fita(){
        this.conteudo.add(Simbolo.B.getSimbolo());
        this.conteudo.add(Simbolo.B.getSimbolo());
        this.posicao = 0;
    }

    public String Ler(){
        return this.conteudo.get(this.posicao);
    } 

    public void Escrever(String simbolo){
        System.out.println("posicao: " + this.posicao);
        this.conteudo.set(this.posicao, simbolo);
    }

    public void Mover(Direcao p_direcao){
        if(p_direcao == Direcao.DIREITA)
            this.posicao = this.posicao + 1;
        else
            this.posicao = this.posicao - 1;

        if(this.posicao == this.conteudo.size()){
            this.conteudo.add(Simbolo.B.getSimbolo());
        }
    }

    public void printConteudo(){
        for(int i = 0; i < this.conteudo.size(); i++){
            aux += conteudo.get(i) ;
            aux += " ";
        }
        System.out.println(aux);
    }
}
