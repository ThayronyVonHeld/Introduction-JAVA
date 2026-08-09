package exercises.Collections.ex09;

import exercises.Collections.ex04.Produtos;
import exercises.Collections.ex08.Consumidor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest03 {
    static void main(String[] args) {

        Consumidor consumidor1 = new Consumidor("Clara");
        Consumidor consumidor2 = new Consumidor("Thayrony");

        Produtos produto1 = new Produtos(1, "Iphone 16", 5042.95);
        Produtos produto2  = new Produtos(5, "Samsung S26", 36.12);
        Produtos produto3 = new Produtos(3, "Tablet s9", 3.55);
        Produtos produto4 = new Produtos(2, "Notebook Dell", 5.4);

        Map<Consumidor, List<Produtos>> consumidorProdutos = new HashMap<>();



    }
}
