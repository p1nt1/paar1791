import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solutie {

    public List<Integer> solutie;
    public int value;
    public int weight;

    public Solutie(List<Integer> solutie, int value, int weight) {
        this.solutie = solutie;
        this.value = value;
        this.weight = weight;
    }

    public Solutie() {
    }


//    public void display() {
//        if (obiecte != null && !obiecte.isEmpty()) {
//            System.out.println("\nSolutia problemei:");
//            System.out.println("Valoare totala = " + valoare);
//            System.out.println("Obiectele alese :");
//
//            for (Obiect obiect : obiecte) {
//                System.out.println(obiect.str());
//            }
//        }
//    }

    public List<Integer> getSolutie() {
        return solutie;
    }

    public String str() {
        return "value=" + value + " weight=" + weight + " vector=" + solutie;
    }


    public Solutie generareRandom(Rucsac rucsac) {
        int weight = 0;
        int valoare = 0;
        List<Integer> vector = new ArrayList<>();

        for (int i = 0; i < rucsac.returnsize(); i++) {
            int random = new Random().nextInt(2);
            vector.add(i, random);
            if (random == 1) {
                weight += rucsac.returnWeight(i);
                valoare += rucsac.returnValue(i);
            }
        }
        Solutie sol = new Solutie(vector, valoare, weight);


        return sol;

    }

    public boolean verificareSolutie(Solutie sol, Rucsac rucsac) {
        if (sol.weight <= rucsac.getCapacitate())
            return true;
        return false;
    }

    public int getRandomIndex(Solutie sol) {
        int random = new Random().nextInt(sol.getSolutie().size());

        while (sol.solutie.get(random) != 1){
            random = new Random().nextInt(sol.getSolutie().size());

        }

        return random;

    }

    public Solutie determinareSol(Rucsac rucsac) {
        Solutie sol = generareRandom(rucsac);
        System.out.println(sol.str());

        if (verificareSolutie(sol, rucsac) == true)
            return sol;
            //calculam surplusul

        int surplus = sol.weight - rucsac.getCapacitate();

            // eliminam ce e in plus pentru a valida solutia
            while (surplus > 0) {
                int random = getRandomIndex(sol);
                Obiect element = rucsac.getObiect(random);
                surplus -= element.weight;

                sol.weight -= element.weight;
                sol.value -= element.value;
                sol.solutie.set(random, 0);


            }

            return sol;
        }

    }




