public enum Simbolo{
    a("a"), b("b"), B("B");

    private String simb;

    Simbolo(String simb){
        this.simb = simb;
    }

    public String getSimbolo(){
        return simb;
    }

}