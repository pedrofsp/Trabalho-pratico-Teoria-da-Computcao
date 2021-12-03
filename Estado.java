import java.util.ArrayList;

public class Estado {
    private String representacao;
    private ArrayList<Transicao> transicoes = new ArrayList<Transicao>(); 

    public void AdicionaTransicao(String origem, String leitura, String destino, String escrita, String direcao){
        Transicao novaTransicao = new Transicao(origem, leitura, destino, escrita, direcao);
        transicoes.add(novaTransicao);
    }

    public String obterTransicao(String simbolo){
        for (int i=0; i < transicoes.size(); i++){
            if (transicoes.get(i).getLeitura() == simbolo){
                return transicoes.get(i).getOrigem();
            }
        }
        return null;
    }
}

