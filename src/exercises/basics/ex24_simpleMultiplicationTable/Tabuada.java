package ex24_simpleMultiplicationTable;

import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite um numero: ");
        int indice = teclado.nextInt();

        for(int contador = 0; contador <= 10; contador++){
           int resultado = indice * contador;
            System.out.printf("%d x %d = %d\n", indice, contador, resultado);
        }
    }
}
