package ex37_methods;

import java.util.Scanner;

public class Metodos {
    public static void main(String[] args) {

        int n1,n2;
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
                System.out.println("O resultado da soma é: " + soma(n1,n2));
            } else if (operador.equals("-")){
                System.out.println("O resultado da subtração é: " + subtracao(n1,n2));
            } else if(operador.equals("*")){
                System.out.println("O resultado da multiplicação é: " + multiplicacao(n1,n2));
            } else if (operador.equals("/")){
                System.out.println("O resultado da divisão é: " + divisao(n1,n2));
            }
        }

    }

    static int soma(int a, int b) {
        int A = a + b;
        return A;
    }

    static int subtracao(int a, int b) {
        int S = a - b;
        return S;
    }

    static int multiplicacao(int a, int b){
        int M = a *  b;
        return M;
    }

    static float divisao(float a, float b){
        float D = a/b;
        return D;
    }
}
