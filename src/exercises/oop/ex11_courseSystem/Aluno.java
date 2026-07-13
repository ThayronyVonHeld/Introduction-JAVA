package ex11_courseSystem;

public class Aluno extends Pessoa{
    private int matricula;
    private String curso;

    public void PagarMensalidade(){
        System.out.println("Pagando Mensalidade do aluno(a): " + this.getNome());
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
