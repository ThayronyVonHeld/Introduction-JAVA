package ex03_primitive_types;

public class Main {
    public static void main(String[] args) {
        /* Parte primeira parte aula 06
	Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o nome do aluno: ");
        String name = teclado.nextLine();
        System.out.print("Digite a nota do aluno: ");
        float note = teclado.nextFloat();
        System.out.printf("%s note is: %.2f\n", name, note);
        */
        /* Testando Conversão Inteiro para String
        int idade = 30;
        String valor = Integer.toString(idade);
        System.out.println(valor);
        */

        String valor = "30";
        int idade = Integer.parseInt(valor);
         System.out.println(idade);

    }
}