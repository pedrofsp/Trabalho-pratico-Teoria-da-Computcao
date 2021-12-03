public enum Simbolo{
    a(1), b(2), B(3);

    private Integer simb;

    Simbolo(Integer simb){
        this.simb = simb;
    }

    public Integer getSimbolo(){
        return simb;
    }

}