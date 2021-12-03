import java.util.ArrayList; 

public class Maquina {
    private Fita fita;
    private String estadoInicial;
    private Estado estadoAtual;
    private ArrayList<Estado> estados = new ArrayList<Estado>();
    private ArrayList<String> historico = new ArrayList<String>();

    public void AdicionaEstado(Estado p_estado, boolean inicial ){
        estados.add(p_estado);
        if(inicial) estadoAtual = p_estado;

    }

    public void Atuar(){
        Integer simboloAtual = fita.ler();
        String transicao = estadoAtual.obterTransicao();
        if(transicao != null){
            System.out.println("Transição: " + transicao);
            System.out.println("Fita: " + fita);

        }
    }

}
