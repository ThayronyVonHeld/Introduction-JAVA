package ex09_fighters_part2;

public class Lutador {
    //atributos
    private String nome;
    private String nacionalidade;
    private int idade;
    private float altura;
    private float peso;
    private String categoria;
    private int vitorias;
    private int derrotas;
    private int empates;

    //construtor
    public Lutador(String no, String na, int id, float al, float pe, int vi, int de, int em){
    this.setNome(no);
    this.setNacionalidade(na);
    this.setIdade(id);
    this.setAltura(al);
    this.setPeso(pe);
    this.setVitorias(vi);
    this.setDerrotas(de);
    this.setEmpates(em);
    }
//metodos
    public void apresentar(){
        System.out.println("-----------------------------------------------");
        System.out.print("CHEGOU A HORA! Apresentamos o Lutador: " + this.getNome());
        System.out.print(" diretamente da " + this.getNacionalidade());
        System.out.print(" com " + this.getIdade() + " anos" + " e com " + this.getAltura() + " m altura,");
        System.out.print(" pesando " + this.getPeso() + " kg");
        System.out.print(" com o historico de " + this.getVitorias() + " vitorias em lutas");
        System.out.print(" tendo " + this.getDerrotas() + " derrotas");
        System.out.println(" e por fim, " + this.getEmpates() + " empates!");

    }
    public void status(){
        System.out.println("-----------------------------------------------");
        System.out.println(getNome());
        System.out.println("É um peso " + this.getCategoria());
        System.out.println("tendo, " + this.getVitorias() + " Vitorias");
        System.out.println(this.getDerrotas() + " Derrotas");
        System.out.println(this.getEmpates() + " Empates");
    }
    public void ganharLuta(){
    this.setVitorias(this.getVitorias() + 1);
    }
    public void perderLuta(){
    this.setDerrotas(this.getDerrotas() + 1);
    }
    public void empatarLuta(){
    this.setEmpates(this.getEmpates() + 1);
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
    this.nome = nome;
    }

    public String getNacionalidade(){
        return nacionalidade;
    }
    public void setNacionalidade(String nacionalidade){
        this.nacionalidade = nacionalidade;
    }

    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }

    public float getAltura(){
        return altura;
    }
    public void setAltura(float altura){
        this.altura = altura;
    }
    public float getPeso(){
        return peso;
    }
    public void setPeso(float peso){
        this.peso = peso;
       this.setCategoria();
    }

    public String getCategoria(){
        return categoria;
    }
    private void setCategoria(){
       if(peso < 52.2){
           categoria = "Inválido";
       }else if (peso <= 70.3){
           categoria = "Leve";
       } else if(peso <= 83.9){
           categoria = "Medio";
       } else if(peso <= 120.2){
           categoria = "pesado";
       } else{
           categoria = "Invalido!";
       }

    }

    public int getVitorias(){
        return vitorias;
    }
    public void setVitorias(int vitorias){
        this.vitorias = vitorias;
    }

    public int getDerrotas(){
        return derrotas;
    }
    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates(){
        return empates;
    }
    public void setEmpates(int empates) {
        this.empates = empates;
    }

}
