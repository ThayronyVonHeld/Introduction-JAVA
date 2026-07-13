package ex02_jokenpo;

import java.util.Scanner;

//Travei aqui voltar para prosseguir

public class Main {
    public static void main(String[] args) {
        Game jogador1 = new Game();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite seu nome[Jogador 1]:  ");
        jogador1.nome = teclado.nextLine();
        System.out.println("Escolha entre [pedra], [papel] ou [tesoura]: ");
        jogador1.escolha = teclado.nextLine();

        Game jogador2 = new Game();
        System.out.println("Digite seu nome[Jogador 2]:");
        jogador2.nome = teclado.nextLine();
        System.out.println("Escolha entre [pedra], [papel] ou [tesoura]: ");
        jogador2.escolha = teclado.nextLine();


    }
}

/*
Refazer o exercicio de logica em C, porém agora utilizando Classes e objetos, metodos... Pensei em algo como Classe Jogo,
Objetos, pedra, papel, tesoura. E seus metodos,
win sla
loser
pedra perde para papel,  ganha de tesoura,
Papel ganha de pedra, e perde para tesoura
tesoura ganha de papel e perde para pedra

 */
