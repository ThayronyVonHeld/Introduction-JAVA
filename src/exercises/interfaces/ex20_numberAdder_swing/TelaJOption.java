package ex20_numberAdder_swing;

import javax.swing.JOptionPane; // Classe que "faz" interface automática

public class TelaJOption {


    public static void main(String[] args) {
        int n;
        int contador = 0, soma = 0, par = 0, impar = 0;
        float media = 0;
        do {
            n = Integer.parseInt(JOptionPane.showInputDialog(null,"<html>Digite um número: <br><em>(Digite 0 para interromper)</em></html>"));
            contador++;
if(n % 2 == 0){
    par++;
} else {
    impar++;
}

            soma +=n;
        } while(n != 0);
        media = soma / (contador -1);
        JOptionPane.showMessageDialog(null, "<html> Resultados Obtidos!<br><hr>" +
                "<strong>Total Números digitados: </strong>" + (contador - 1) +"</html>"+
                "<html>Soma dos números: " + soma + "</html>" +
                "<html>Total pares: " + (par - 1) + "</html>" +
                "<html>Total Impar: " + impar + "</html>" +
                "<html>Media dos valores: " + media + "</html>");

    }
}