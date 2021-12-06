// classe para o objeto de transicao
// representa a transiacao entre dois estados e o que deve ser lido/escrito na fita

public class Transicao {
    private String origem; // origem da transicao {q0, q1, q2, etc}
    private String leitura; // leitura da transicao {a || b || B}
    private String destino; // destino da transicao {q0, q1, q2, etc}
    private String escrita; // escrita da transicao {a || b || B}
    private String direcao; // direcao da transicao {L || R}

    /*Construtor inicializador de variaveis*/
    public Transicao(String p_origem, String p_leitura, String p_destino, String p_escrita, String p_direcao){
        origem = p_origem;
        leitura = p_leitura;
        destino = p_destino;
        escrita = p_escrita;
        direcao = p_direcao;
    }

    public String getLeitura(){ //retorna atributo privado leitura
        return leitura;
    }

    public String getOrigem(){ //retorna atributo privado origem
        return origem;
    }

    public String getDestino(){ //retorna atributo privado detino
        return destino;
    }

    public String getEscrita(){ //retorna atributo privado escrita
        return escrita;
    }
    
    public String getDirecao(){ //retorna atributo privado direcao
        return direcao;
    }
}

