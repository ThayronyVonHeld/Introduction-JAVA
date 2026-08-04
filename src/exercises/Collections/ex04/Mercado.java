package exercises.Collections.ex04;

import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mercado {
    public static void main() {

        List<Produtos> mercadorias = new ArrayList<>();
        mercadorias.add(new Produtos(1, "Arroz", 14.95));
        mercadorias.add(new Produtos(5, "Carne", 36.12));
        mercadorias.add(new Produtos(3, "Acucar", 3.55));
        mercadorias.add(new Produtos(2, "Feijão", 5.4));
        mercadorias.add(new Produtos(4, "Ovos", 9.99));

        Collections.sort(mercadorias);

        for (Produtos mercado : mercadorias){
            System.out.println(mercado);
        }






    }
}
