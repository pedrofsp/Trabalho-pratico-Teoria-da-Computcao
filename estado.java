// classe para manusear os estados

import java.util.ArrayList;

public class Estado {
    private String representacao; //represntacao em string (q + numero do estado) exemplo: q1
    public ArrayList<Transicao> transicoes; // vetor com as transicoes do estado

    Estado(String rep){ // construtor do estado
        this.representacao = rep; // recebe um representador {q0, q1, etc}
        this.transicoes = new ArrayList<Transicao>(); // cria-se o vetor com as transicoes
    }

    public void AdicionaTransicao(String origem, String leitura, String destino, String escrita, String direcao){ //adiciona nova transicao ao estado
        Transicao novaTransicao = new Transicao(origem, leitura, destino, escrita, direcao); // cria-se uma nova transicao pelo construtor de Transicao
        transicoes.add(novaTransicao); //adiciona nova transicao ao ArrayList de transicoes
    }

    public Transicao obterTransicao(String simbolo){ // retorna as transicoes do estado
        for (int i=0; i < transicoes.size(); i++){ // percorre as transicoes do objeto Estado
            if (transicoes.get(i).getLeitura() == simbolo){ // retorna transicao do simbolo desejado
                return transicoes.get(i);
            }
        }
        return null; //retorna null caso a transicao nao seja encontrada
    }

    public String getRepresentacao(){ //retorna atributo privado representacao
        return representacao;
    }

    public void printTransicoes(){ //printa todas as transicoes do estado
        for(int i = 0; i < transicoes.size(); i++){
            System.out.println(transicoes.get(i));
        }
    }

    
}

