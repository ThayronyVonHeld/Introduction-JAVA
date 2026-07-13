package ex12_zoo;

public class Mamifero extends Animal{

    private String corPelo;

    @Override
    public void locomover() {
        System.out.println("Correndo...");
    }

    @Override
    public void alimentar() {
        System.out.println("Comendo... Ração");
    }

    @Override
    public void emitirSom() {
        System.out.println("Som de Mamifero");
    }

    public String getCorPelo() {
        return corPelo;
    }

    public void setCorPelo(String corPelo) {
        this.corPelo = corPelo;
    }
}
