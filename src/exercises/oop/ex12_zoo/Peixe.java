package ex12_zoo;

public class Peixe extends Animal{

    private String corEscama;

    public void soltarBolha(){
        System.out.println("Soltou uma Bolha");
    }

    @Override
    public void locomover() {
        System.out.println("Nadando");
    }

    @Override
    public void alimentar() {
        System.out.println("Comendo...Subs");
    }

    @Override
    public void emitirSom() {
        System.out.println("Soltou uma Bolha");
    }

    public String getCorEscama() {
        return corEscama;
    }

    public void setCorEscama(String corEscama) {
        this.corEscama = corEscama;
    }
}
