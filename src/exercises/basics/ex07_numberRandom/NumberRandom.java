package ex07_numberRandom;

public class NumberRandom {
    public static void main(String[] args) {
        double aleatorio = Math.random(); //Classe Math
        int n = (int) (1 + aleatorio * (10 - 1)); // Gerando numeros aleatorios entre 1 e 10
        System.out.println(n);
    }
}
