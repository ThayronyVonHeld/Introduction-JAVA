package ex09_fighters_part2;

public class Main {
    public static void main(String[] args) {

        Lutador l[] = new Lutador[6];

        l[0] = new Lutador("Pretty Boy", "French", 31, 1.75f, 68.9f, 11, 2, 1);
        l[1] = new Lutador("Putscript", "Brazil", 29, 1.68f, 57.8f, 14, 2, 3);
        l[2] = new Lutador("SnapShadow", "EUA", 35, 1.65f, 80.9f, 12, 2, 1);
        l[3] = new Lutador("Dead Code", "Austalia", 28, 1.70f, 82.9f, 13, 0, 2);
        l[4] = new Lutador("UFOCobol", "Brazil", 37, 1.93f, 119.3f, 5, 4, 3);
        l[5] = new Lutador("Nerdaart", "Espanish", 30, 1.81f, 105.7f, 12, 2, 4);

        Luta ufc = new Luta();
        ufc.marcarLuta(l[4], l[5]);
        ufc.Lutar();

    }
}
