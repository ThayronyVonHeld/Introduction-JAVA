package exercises.Collections.ex07;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("Teklado", "Teclado");
        map.put("mouze", "mouse");
        map.put("vc", "você");
        // map.put("vc", "você2"); cuidado se você repetir a chave o java sobrescreve o valor
        // para adicionar caso não exista utilize o putIfAbsent
        map.putIfAbsent("vc", "você");

        System.out.println(map);

        for (String key : map.keySet()){
            System.out.println(key);
        }
        System.out.println("-----------------------");
        for (String value : map.values()){
            System.out.println(value);
        }

        System.out.println("-------------------------");

        for (String kay : map.keySet()){
            System.out.println(kay + " : " + map.get(kay));
        }

    }
}
