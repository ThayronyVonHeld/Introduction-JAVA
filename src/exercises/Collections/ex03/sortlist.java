package exercises.Collections.ex03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sortlist {
    public static void main(String[] args) {
        List<String> series = new ArrayList<>();
        series.add("The boys");
        series.add("Reacher");
        series.add("Fallout");
        series.add("Arcane");
        series.add("Dr.House");

        Collections.sort(series);

        for (String serie : series){
            System.out.println(serie);
        }

        System.out.println("---------------");

        List<Double> dinheiro = new ArrayList<>();
        dinheiro.add(23.132);
        dinheiro.add(102.32);
        dinheiro.add(3214.213);
        dinheiro.add(1.3);

        System.out.println(dinheiro);
        Collections.sort(dinheiro);
        System.out.println(dinheiro);


    }
}
