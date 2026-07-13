package ex12_zoo;

public class Cachorro extends Mamifero{

    @Override
    public void emitirSom() {
        System.out.println("Au! Au! Au!");
    }

    public void enterrarOsso(){
        System.out.println("Enterrando Osso...");
    }

    public void abanarRabo(){
        System.out.println("Abanando Rabo...");
    }
}
