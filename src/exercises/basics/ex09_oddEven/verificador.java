package ex09_oddEven;

import java.util.Scanner;

public class verificador {
    public static void main(String[] args) {

        int n1;

        Scanner  teclado = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        n1 = teclado.nextInt();

        if(n1 % 2 == 0){
            System.out.println("O numero digitado: " + n1 + " É PAR!");
        } else {
            System.out.println("O numero digitado: " + n1 + " É IMPAR!");
        }

    }
}

