public class Rucsac {

    private Obiect[] obiecte;
    private int capacitate;

    public Rucsac(Obiect[] obiecte, int capacitate) {
        this.obiecte = obiecte;
        this.capacitate = capacitate;
    }

    public void display() {
        if (obiecte != null && obiecte.length > 0) {
            System.out.println("Problema rucsacului");
            System.out.println("Capacitate: " + capacitate);
            System.out.println("Obiecte: ");
            for (Obiect obiect : obiecte) {
                System.out.println(obiect.str());
            }

        }
    }

    public int returnsize(){
        return obiecte.length;
    }

    public int returnWeight(int n){
        return obiecte[n].weight;
    }

    public int returnValue(int n){
        return obiecte[n].value;
    }


    public int getCapacitate() {
        return capacitate;
    }

    public Obiect getObiect(int n) {
        return obiecte[n];
    }


}
