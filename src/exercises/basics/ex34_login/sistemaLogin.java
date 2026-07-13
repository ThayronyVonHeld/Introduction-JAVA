package ex34_login;


import java.util.Scanner;

public class sistemaLogin {
    public static void main(String[] args) {
        String username = "ThayronyVonHeld";
        String passoword = "@123456";
        String user = "";
        String pin = "";

        Scanner teclado = new Scanner(System.in);

        for (int i = 3; i > 0; i--) {
            System.out.println("Você tem: " + i + " tentativas");
            System.out.println("Digite seu login:");
            user = teclado.next();
            System.out.println("Digite sua senha:");
            pin = teclado.next();

            if (username.equals(user) && (passoword.equals(pin))) {
                System.out.println("Login realizado com sucesso!");
                break;
            } else {
                System.out.println("Login ou senha incorreto, tente novamente!");
            }
        }
    }
}
