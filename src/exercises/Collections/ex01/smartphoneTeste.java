package exercises.Collections.ex01;

import java.util.ArrayList;
import java.util.List;

public class smartphoneTeste {
    public static void main(String[] args) {

        Smartphone s0 = new Smartphone("Iphone", "A001245");
        Smartphone s1 = new Smartphone("Samsung", "K2C2B3");
        Smartphone s2 = new Smartphone("LG", "BBBBB72");

        List<Smartphone> telefones = new ArrayList<>();

        telefones.add(s0);
        telefones.add(s1);

        for (Smartphone telefone : telefones){
            System.out.println(telefone);

        }

    }
}
