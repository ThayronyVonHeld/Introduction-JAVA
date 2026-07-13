package ex09_fighters_part2;

import java.util.Random;

public class Luta {
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;

    public void marcarLuta(Lutador l1, Lutador l2){
    if(l1.getCategoria().equals(l2.getCategoria()) && l1 != l2){
    this.aprovada = true;
    this.desafiado = l1;
    this.desafiante = l2;
    } else{
        this.aprovada = false;
        this.desafiado = null;
        this.desafiante = null;
    }
    }

    public void Lutar(){
    if(this.aprovada){
        System.out.println("### Desafiado ###");
        this.desafiado.apresentar();
        System.out.println("### Desafiante ###");
        this.desafiante.apresentar();

        Random aleatorio = new Random();

        int vencedor = aleatorio.nextInt(3);
        System.out.println("### RESULTADO ###");
        switch (vencedor){
            case 0: // empate
                System.out.println("--------------------");
                System.out.println("Houve um Em pate!");
                this.desafiado.empatarLuta();
                this.desafiante.empatarLuta();
                    break;

            case 1: // Vitoria Desafiado
                System.out.println("---------------------");
                System.out.println(this.desafiado.getNome() + " Ganhou a LUTA!");
                this.desafiado.ganharLuta();
                this.desafiante.perderLuta();
                    break;

            case 2: //vitoria desafiante
                System.out.println("---------------------");
                System.out.println(this.desafiante.getNome() + " Ganhou a Luta!");
                this.desafiado.perderLuta();
                this.desafiante.ganharLuta();
                    break;
        }
    } else{
        System.out.println("A luta não pode Acontecer!");
    }
    }

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDefiante() {
        return desafiante;
    }

    public void setDefiante(Lutador defiante) {
        this.desafiante = defiante;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean getAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
}
