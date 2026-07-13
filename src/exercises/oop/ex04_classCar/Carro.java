package ex04_classCar;

public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private float velocidade;
    private boolean ligado;

    public Carro() {
        this.marca = "Peugeot";
        this.modelo = "Peugeot 106";
        this.ano = 1991;
        this.velocidade = 0;
    }

    public void setLigar() {
        ligado = true;
        System.out.println("---------------------------");
        System.out.println("INICIALIZANDO");
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Ano: " + this.ano);
        System.out.println("---------------------------");

    }

    public float setAcelerar() {
        if (ligado == true) {
            System.out.println("Acelerador ON");
            for (int i = 0; i < 5; i++) {
                this.velocidade += 10;
                System.out.println("Acelerando, " + this.velocidade + "Km/h");
            }
        } else {
            System.out.println("Ligue o carro antes de acelerar!");
        }
        return velocidade;
    }

    public float setFrear() {
        if (ligado == true && velocidade > 0) {
            System.out.println("Freio ATIVADO");
            for (int j = 5; j > 0; j--) {
                this.velocidade -= 10;
                System.out.println("Desacelerando, " + this.velocidade + "Km/h");
            }
        }
        return velocidade;
    }
}


