package exercises.Collections.ex02;

import java.util.ArrayList;
import java.util.List;

public class Contatos {
    public static void main(String[] args) {

        List<String> nome = new ArrayList<>();

        nome.add("Thayrony");
        nome.add("Kayke");
        nome.add("Von Held");
        
        for (String nomes : nome){
            System.out.println(nomes);

        }


    }
}


