public enum Direcao{
    ESQUERDA(1), DIREITA(2);

    private int direc;

    Direcao(int direc){
        this.direc = direc;
    }

    public int getDirecao(){
        return direc;
    }
}