package ex33_Array;

import java.util.Scanner;

public class verificarNumeros {
    public static void main(String[] args) {
        int[] n1 = new int[5];

        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite um numero: ");
            n1[i] = teclado.nextInt();
        }

        int maior = n1[0];
        int menor = n1[0];

        for (int j = 1; j < 5; j++) {
            if (n1[j] > maior) {
                maior = n1[j];
            }
            if (n1[j] < menor) {
                menor = n1[j];
            }
        }

        System.out.println("O maior numero digitado foi: " + maior);
        System.out.println("O menor numero digitado foi: " + menor);
    }
}