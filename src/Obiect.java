public class Obiect {

    public int value;
    public int weight;

    public Obiect(int value, int weight){
        this.value=value;
        this.weight=weight;
    }

    public String str(){
        return "[value= " + value + ", weight= " + weight + "];";
    }


}
