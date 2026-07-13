package ex27_months;

import java.util.Scanner;

public class TotalMes {
    public static void main(String[] args) {
        String mes[] = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun",
                "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
        int tot[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ano;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o ano: ");
        ano = teclado.nextInt();

        for(int i = 0; i<mes.length; i++){
            if (ano % 4 == 0 || ano % 400 == 0 ){
                tot[1] = 29;
            }
            System.out.println("O mês de " + mes[i] + " tem: " + tot[i] + " dias");

        }
    }
}