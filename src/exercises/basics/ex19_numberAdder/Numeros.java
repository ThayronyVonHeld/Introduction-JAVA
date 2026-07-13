package ex19_numberAdder;

import java.util.Scanner;


public class Numeros {


    public static void main(String[] args) {

        int i;
        int soma = 0;
        String responda;
        Scanner teclado = new Scanner(System.in);

        do{
            System.out.print("Digite um numero: ");
            i = teclado.nextInt();

            soma += i; //s = s+n;

            System.out.print("Deseja continuar [S/N]? ");
            responda = teclado.next();

        }
        while(responda.equals("S"));
        System.out.println("A Soma de todos os valores e: " + soma);
    }

}
