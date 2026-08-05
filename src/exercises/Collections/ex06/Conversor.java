package exercises.Collections.ex06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conversor {
    static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);

        // numeros.toArray();
        Integer[] intergersArray = numeros.toArray(new Integer[0]);
        System.out.println(Arrays.toString(intergersArray));
    }
}
