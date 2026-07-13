package ex04_simple_calculator;

import java.util.Scanner;

public class superSomador {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite quantos numeros deseja somar: ");
        int n1 = teclado.nextInt();

        int resultado = 0;

        for(int i = 0; i < n1; i++){
            System.out.println("Digite o numero a ser somado: ");
            int s = teclado.nextInt();
            resultado = resultado + s;
        }

        System.out.println("a soma total foi igual a: " + resultado);

    }
}
