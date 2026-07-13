package ex25_vectorExercises;


import java.util.Arrays;

public class Vetor01 {
    public static void main(String[] args) {
int v[] = new int[20];
Arrays.fill(v, 0);

for(int valor: v){
    System.out.print(valor + " ");
}
    }
    }


        /*
        int vet[] = {3, 7, 6, 1, 9, 4, 2};
        for(int v:vet) {
            System.out.print(v + "  ");
        }
        System.out.println(" ");
            int p = Arrays.binarySearch(vet, 1);
            System.out.println("Encontrei o valor na posição " + p);

        }
}



/*
import java.util.Arrays;

public class Vetor01 {
    public static void main(String[] args) {
        int num[] = {3,5,8,4};
        Arrays.sort(num);
        for(int valor: num){
            System.out.print(valor + "  ");
        }
    }
}
  /*
        /*
        double v[] = {3.5, 2.75, 9, -4,5};
for(double valor: v){
    System.out.print(valor + " ");
}
    }
}
/*
        /*    int n[] = {3, 2, 8, 7, 5, 4};
        for (int i = 0; i < n.length; i++) {
            System.out.println("Na posição " + i + " temos o valor " + n[i]);
        }
/*

/*
        int n[] = {3,2,8,7,5,4};
        System.out.println("Total de casas de N: " + n.length);
        for(int i = 0; i<=5; i++){
            System.out.println("Na posição " + i + " temos o valor " + n[i]);
        }
*/