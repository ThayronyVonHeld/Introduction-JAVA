package ex11_courseSystem;

public class Main {
    public static void main(String[] args) {
      //  Pessoa p1 = new Pessoa(); Pessoa é uma classe abstrata, ou seja, ela não pode ser instanciada e não pode ter objetos.
       /* Visitante v1 = new Visitante();
        v1.setNome("Thayrony");
        v1.setIdade(21);
        v1.setSexo("M");
        System.out.println(v1.toString());
        */
        Aluno a1 = new Aluno();
        a1.setNome("Clara");
        a1.setIdade(27);
        a1.setSexo("F");
        a1.setCurso("Saúde da Mulher");
        a1.setMatricula(32456);
        System.out.println(a1.toString());
        a1.PagarMensalidade();

        Bolsista b1 = new Bolsista();
        b1.setNome("Maria Maggessy");
        b1.setSexo("F");
        b1.setMatricula(2314);
        b1.setBolsa(12.5f);
        b1.PagarMensalidade();
    }
}
