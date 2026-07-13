package ex12_zoo;

public class Ave extends Animal{

    private String corPena;

    public void fazerNinho(){
        System.out.println("Construindo Ninho");
    }

    @Override
    public void locomover() {
        System.out.println("Voando");
    }

    @Override
    public void alimentar() {
        System.out.println("Comendo...Alpiste");
    }

    @Override
    public void emitirSom() {
        System.out.println("Som Aves");
    }

    public String getCorPena() {
        return corPena;
    }

    public void setCorPena(String corPena) {
        this.corPena = corPena;
    }
}
