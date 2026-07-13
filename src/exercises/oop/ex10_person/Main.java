package ex10_person;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        Aluno p2 = new Aluno();
        Professor p3 = new Professor();
        Funcionario p4 = new Funcionario();


        p1.setNome("Pedro");
        p1.setSexo("M");
        p1.setIdade(20);

        p2.setNome("Maria");
        p2.setSexo("F");
        p2.setIdade(18);
        p2.setCurso("Informatica");

        p3.setNome("Claudio");
        p3.setSexo("M");
        p3.setSalario(2500.75f);

        p4.setNome("Fabiana");
        p4.setSexo("F");
        p4.setSetor("Estoque");

        System.out.println(p1.dadosPessoa());
        System.out.println(p2.dadosPessoa());
        System.out.println(p3.dadosPessoa());
        System.out.println(p4.dadosPessoa());
    }
}
