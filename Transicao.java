public class Transicao {
    private String origem;
    private String leitura;
    private String destino;
    private String escrita;
    private String direcao;

    public Transicao(String p_origem, String p_leitura, String p_destino, String p_escrita, String p_direcao){
        origem = p_origem;
        leitura = p_leitura;
        destino = p_destino;
        escrita = p_escrita;
        direcao = p_direcao;
    }

    public String getLeitura(){
        return leitura;
    }

    public String getOrigem(){
        return origem;
    }
}

