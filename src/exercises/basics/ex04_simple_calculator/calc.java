package ex04_simple_calculator;

import java.util.Scanner;

public class calc {
    public static void main(String[] args) {

        int n1,n2;

        float resultado;

        String operador;

        System.out.println("Digite um numero: ");
        Scanner teclado = new Scanner(System.in);
        n1 = teclado.nextInt();

        System.out.println("Digite:\n" + " [+] para adição\n" + "[-] para subtração\n" + "[*] para multiplicação\n" + "[/] para divisão\n");
        System.out.println("Digite: ");
        operador = teclado.next();

        System.out.println("Digite o segundo numero: ");
        n2 = teclado.nextInt();

        if(operador.equals("/") && (n1 == 0 || n2 ==0)){
            System.out.println("Não é possivel a divisão por zero, tente novamente");
        } else {

            if(operador.equals("+")){
                resultado = n1 + n2;
                System.out.println("O resultado da soma é: " + resultado);
            } else if (operador.equals("-")){
                resultado = n1 - n2;
                System.out.println("O resultado da subtração é: " + resultado);
            } else if(operador.equals("*")){
                resultado = n1 * n2;
                System.out.println("O resultado da multiplicação é: " + resultado);
            } else if (operador.equals("/")){
                resultado = n1/n2;
                System.out.println("O resultado da divisão é: " + resultado);
            }
        }
    }
}
