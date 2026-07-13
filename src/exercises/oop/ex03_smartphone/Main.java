package ex03_smartphone;

public class Main {
    public static void main(String[] args) {
        Smartphone c1 = new Smartphone();
        c1.modelo = "Samsung S25 ultra";
        c1.cor = "Verde";
        c1.ram = 8;
        c1.ligar = true;
        c1.status();
        c1.desbloquear();
        c1.camera();


    }
}
