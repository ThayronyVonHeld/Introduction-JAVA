package ex15_bankSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sair = 0;
        int Escolha;

        ContaBanco pessoa = new ContaBanco();

        do{
           System.out.println("---------------------------------");
            System.out.println("Bem Vindo ao Nosso Banco");
            System.out.println("---------------------------------");
            System.out.println("Digite [1] para Abrir conta");
            System.out.println("Digite [2] para para Fechar conta");
            System.out.println("Digite [3] para fazer um deposito");
            System.out.println("Digite [4] para fazer um saque");
            System.out.println("Digite [5] para pagar a mensalidade");
            System.out.println("Digite [6] para Visualizar suas informações");
            System.out.println("Digite [7] para sair");
            System.out.print("Digite sua escolha: ");

            Scanner teclado = new Scanner(System.in);
            Escolha = teclado.nextInt();

            if(Escolha == 1){
            pessoa.abrirConta();
            }

            else if(Escolha == 2){
            pessoa.fecharConta();
            }
            else if(Escolha == 3){

                pessoa.depositar();
            }
            else if(Escolha == 4){
                pessoa.sacar();
            }
            else if(Escolha == 5){
                pessoa.pagarMensal();
            }
            else if(Escolha == 6){
                pessoa.infoConta();
            }
            else if (Escolha == 7){
                    sair = 7;
                }

        }while(sair != 7);

    }
}