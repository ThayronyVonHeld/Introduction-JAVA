package ex24_simpleMultiplicationTable;

import java.util.Scanner;

public class tab {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite a tabuada que deseja consultar: ");
        int n1 = teclado.nextInt();

        for (int i = 0; i <= 10; i++){
            int contador = i * n1;
            System.out.println(n1 + " x " + i + " = " + contador);
        }


    }
}
