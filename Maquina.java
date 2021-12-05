import java.util.ArrayList; 

public class Maquina {
    private Fita fita = new Fita();
    private String estadoInicial;
    private String estadoAtual;
    public ArrayList<String> estados = new ArrayList<String>();
    private ArrayList<String> historico = new ArrayList<String>();

    public void AdicionaEstado(String p_estado, boolean inicial ){
        estados.add(p_estado);
        if(inicial){
            estadoAtual = p_estado;
        }
    }

    public void SetEntrada(String entrada){
        fita.Mover(Direcao.DIREITA);
        for (int i =0 ; i<entrada.length(); i++){
            if (entrada.charAt(i) == 'a') fita.Escrever(Simbolo.a.getSimbolo());
            else if (entrada.charAt(i) == 'b') fita.Escrever(Simbolo.b.getSimbolo());
            else{ 
                fita.Escrever("B");
            }
            
            fita.Mover(Direcao.DIREITA);
        }

        while(fita.posicao != 0) fita.Mover(Direcao.ESQUERDA);
    }

    public void printConteudoMaquina(){
        fita.printConteudo();
    }

    public boolean Atuar(){
        return false;
    }

}
