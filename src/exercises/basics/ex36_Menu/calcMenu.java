package ex36_Menu;

import java.util.Scanner;

public class calcMenu {
    public static void main(String[] args) {
        int escolha = 0;
    int n1 = 0, n2 = 0;
    int resultado = 0;

        Scanner scanf = new Scanner(System.in);

        do{

            System.out.println("Digite a operação que deseja realizar: ");
            System.out.println("[1] para soma");
            System.out.println("[2] para subtração");
            System.out.println("[3] para sair");
            System.out.print("Digite sua escolha: ");
            escolha = scanf.nextInt();

            if(escolha == 1){
                System.out.print("Digite o primeiro numero: ");
                n1 = scanf.nextInt();
                System.out.print("Digite um segundo numero: ");
                n2 = scanf.nextInt();

                resultado = n1 + n2;

                System.out.println("O resultado da sona foi: " + resultado);

            } else if(escolha == 2){
                System.out.print("Digite o primeiro numero: ");
                n1 = scanf.nextInt();
                System.out.print("Digite um segundo numero: ");
                n2 = scanf.nextInt();

                resultado = n1 - n2;

                System.out.println("O resultado da sona foi: " + resultado);
            } else if (escolha == 3) {
                System.out.println("Encerrando programa...");
            } else {
                System.out.println("Opção inválida!");
            }

        }while(!(escolha == 3));
    }
}
