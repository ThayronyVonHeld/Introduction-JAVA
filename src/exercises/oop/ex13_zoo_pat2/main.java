package ex13_zoo_pat2;

public class main {
    public static void main(String[] args) {
        Cachorro c = new Cachorro();
        Lobo l = new Lobo();

        l.emitirSom();
        c.emitirSom();

        c.reagir("Olá");
        //c.reagir("Vai apanhar");
        c.reagir(11,45);
        //c.reagir(21,00);
        c.reagir(true);
        //c.reagir(false);
        //c.reagir(2, 12.5f);
        c.reagir(17, 4.5f);
    }
}
