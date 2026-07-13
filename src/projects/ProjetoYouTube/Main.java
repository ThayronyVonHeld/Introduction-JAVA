package projects.ProjetoYouTube;

public class Main {
    public static void main(String[] args) {
        Video v[] = new Video[3];

        v[0] = new Video("Aula 01 de POO");
        v[1] = new Video("Aula 02 de POO");
        v[2] = new Video("Novo Curso MySQL!");

        Gafanhoto g[] = new Gafanhoto[2];

        g[0] = new Gafanhoto("Thayrony", 21, "M", "theld");
        g[1] = new Gafanhoto("Clara", 27, "F", "clarita");

        Visualizacao view[] = new Visualizacao[5];

        view[0] = new Visualizacao(g[0],v[2]);
        view[0].avaliar(87.0f);
        System.out.println(view[0].toString());

        view[1] = new Visualizacao(g[0],v[1]);
        view[0].avaliar(9);
        System.out.println(view[1].toString());


    }
}
