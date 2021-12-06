// enumeracao dos simbolos para facilitar chamadas

public enum Simbolo{ 
    a("a"), b("b"), B("B");

    private String simb;

    Simbolo(String simb){ // construtor de simbolo
        this.simb = simb;
    }

    public String getSimbolo(){ // retorna o simbolo desejado
        return simb;
    }

}