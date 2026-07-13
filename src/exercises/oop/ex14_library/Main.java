package ex14_library;

public class Main {
    public static void main(String[] args) {
        Pessoa[] p = new Pessoa[2];
        Livro[] l = new Livro[3];

        p[0] = new Pessoa("Thayrony", 21, "M");
        p[1] = new Pessoa("Clara", 22, "F");

        l[0] = new Livro("Bridgerton - O Duque e Eu", "Julia Quinn",496, p[1]);
        l[1] = new Livro("Código Limpo", "Robert C.", 320, p[0]);
        l[2] = new Livro("Alchemised", "SenLinYu", 1324, p[1]);

        l[0].abrir();
        l[0].folhear(100);
        l[0].avancarPag();
        System.out.println(l[0].detalhes());
    }
}
