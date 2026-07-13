package ex10_ageVerification;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Em que ano você nasceu? ");
        int nascimento = teclado.nextInt();
        int i = 2025 - nascimento;

        System.out.println("Sua idade é: " + i);

        if (i > 18){
            System.out.print("Você é maior de idade");
        }
        else {
            System.out.print("Você é menor de idade");
        }

    }
}
