package exercises.Collections.ex04;

import java.util.Objects;

public class Produtos implements Comparable<Produtos>{

    private long id;
    private String nome;
    private double preco;

    public Produtos(long id, String nome, double preco) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(nome);
        Objects.requireNonNull(preco);
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produtos produtos = (Produtos) o;
        return id == produtos.id && Double.compare(preco, produtos.preco) == 0 && Objects.equals(nome, produtos.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco);
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }


    @Override
    public int compareTo(Produtos outroproduto) {

       if(this.id < outroproduto.getId()){
           return -1;
       } else if (this.id.equals(outroproduto.getId())){
        return 0;
       } else {
           return 1;
       }
    }
}
