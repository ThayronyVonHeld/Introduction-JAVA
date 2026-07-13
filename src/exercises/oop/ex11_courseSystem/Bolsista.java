package ex11_courseSystem;

public class Bolsista extends Aluno{
    private float bolsa;

    public void RenovarBolsa(){
        System.out.println("Renovando Bolsa do Aluno(a): " + this.getNome());
    }

    @Override
    public void PagarMensalidade(){
        System.out.println(this.getNome() + " É Bolsista! Desconto aplicado!");
    }

    public float getBolsa() {
        return bolsa;
    }

    public void setBolsa(float bolsa) {
        this.bolsa = bolsa;
    }
}
