import java.util.ArrayList; 

public class Fita {
    public int posicao;
    ArrayList<Integer> conteudo = new ArrayList<Integer>();

    Fita(){
        this.conteudo.add(Simbolo.B.getSimbolo(), Simbolo.B.getSimbolo());
        this.posicao = 0;
    }

    public Integer ler(){
        return this.conteudo.get(this.posicao);
    } 

    public void escrever(Simbolo simbolo){
        this.conteudo.set(this.posicao, simbolo);
    }
}
