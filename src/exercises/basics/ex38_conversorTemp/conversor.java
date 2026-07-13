package ex38_conversorTemp;

import java.util.Scanner;

public class conversor {
    public static void main(String[] args) {
    double cels = 0, fahre = 0;
    int escolha = 0;

        Scanner teclado = new Scanner(System.in);

    do {

        System.out.println("Digite a conversão que deseja realizar: ");
        System.out.println("[1] para converter Fahrenheit(ºF) para Celsius(ºC)");
        System.out.println("[2] para converter Celsius(ºC) para Fahrenheit(ºF)");
        System.out.println("[3] para sair");
        System.out.print("Digite sua escolha: ");
        escolha = teclado.nextInt();


        if(escolha == 1){
            System.out.println("Digite o valor que queria converter em ºF: ");
            fahre = teclado.nextDouble();
            System.out.println("O valor " + fahre + " em Celsius é igual a: " + celsius(fahre));
        } else if(escolha == 2){
            System.out.println("Digite o valor que queria converter em ºC: ");
            cels = teclado.nextDouble();
            System.out.println("O valor " + cels + " em Fahrenheit é igual a: " + fahrenheit(cels));
        } else if (escolha == 3) {
            System.out.println("Encerrando programa...");
        } else {
            System.out.println("Opção inválida!");
        }

        teclado.close();
    }while(!(escolha == 3));

    }

    static double celsius(double F){ // fahrenheit para celsius
        double C = (F - 32) * 5/9;
        return C;
    }
    static double fahrenheit(double c){ //celsius para fahrenheit
    double f = (c * 1.8) + 32;
    return f;
    }
}
