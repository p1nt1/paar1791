import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void generareSolutie(int k, Rucsac rucsac){
        Solutie best = new Solutie();
        String rezolvare= "\nSolutiile prelucrate sunt\n";
        for (int i = 0; i < k; i++) {
            Solutie solutie = new Solutie().determinareSol(rucsac);
            rezolvare+= solutie.str()+"\n";
            if(solutie.verificareSolutie(solutie,rucsac)== true)
                if(best != null )
                    if(best.value < solutie.value)
                        best=solutie;
        }
        if(best != null)
            rezolvare += "\nCea mai buna solutie pe care am gasit-o este:" + best.str() +"\n";
        else
            System.out.println("Din pacate nu exista! ");
        System.out.println(rezolvare);
    }



        public static void main (String[]args) throws IOException {

//            Obiect[] obiecte = {new Obiect(4, 12),
//                    new Obiect(2, 1),
//                    new Obiect(2, 2),
//                    new Obiect(1, 1),
//                    new Obiect(10, 4)};
            FileInputStream fstream = new FileInputStream(new File("C:\\Users\\alexp\\Desktop\\Laborator1\\data\\input2.txt"));
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line;
            int nr = Integer.parseInt(br.readLine());
            Obiect[] obiectList = new Obiect[nr];

            int i = 0;
            while (nr != i) {
                String[] values = br.readLine().split(",");

                Obiect obj = new Obiect(Integer.parseInt(values[2]), Integer.parseInt(values[3]));
                obiectList[i] = obj;
                i++;
            }

            int capacity = Integer.parseInt(br.readLine());
            Rucsac rucsac = new Rucsac(obiectList, capacity);

            br.close();

            rucsac.display();
            System.out.println("\nSirurile generate aleator sunt:" );
            generareSolutie(8, rucsac);


        }
    }


