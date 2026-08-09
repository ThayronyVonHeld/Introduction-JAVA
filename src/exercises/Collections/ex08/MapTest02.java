package exercises.Collections.ex08;

import exercises.Collections.ex04.Produtos;

import java.util.HashMap;
import java.util.Map;

public class MapTest02 {
    static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("Clara");
        Consumidor consumidor2 = new Consumidor("Thayrony");

        Produtos produto1 = new Produtos(1, "Iphone 16", 5042.95);
        Produtos produto2  = new Produtos(5, "Samsung S26", 36.12);
        Produtos produto3 = new Produtos(3, "Tablet s9", 3.55);
        Produtos produto4 = new Produtos(2, "Notebook Dell", 5.4);

        Map<Consumidor, Produtos> consumidorProdutos = new HashMap<>();
        consumidorProdutos.put(consumidor1, produto1);
        consumidorProdutos.put(consumidor2, produto2);

        for (Map.Entry<Consumidor, Produtos> entry : consumidorProdutos.entrySet()){
            System.out.println(entry.getKey().getNome() + " comprou " + entry.getValue().getNome());

        }





    }
}
