package ex13_zoo_pat2;

public class Mamifero extends Animal {

    protected String corPelo;

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
