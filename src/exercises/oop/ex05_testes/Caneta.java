package ex05_testes;

/*
No intellij clicando com Alt + i, irá abrir uma janera "Generate" e com ela
você consegue criar os construtores automaticamente selecionando eles na janela
no neatbens é Ctrl + i
 */
public class Caneta {
    public String modelo;
    private float ponta;
    private boolean tampada;
    private String cor;

    public Caneta(String m, float p, String c) {
        this.modelo = m;
        this.ponta = p;
        this.cor = c;
    }

    /*
    Agora para criar os metodos getters e setters, basta clicar o mesmo o botão alt + insert
    ir em Getters and Setters, que você criará os metodos!
     */
    public String getModelo() {

        return modelo;
    }

    public void setModelo(String modelo) {

        this.modelo = modelo;
    }

    public float getPonta() {

        return ponta;
    }

    public void setPonta(float ponta) {

        this.ponta = ponta;
    }

    public boolean isTampada() {

        return tampada;
    }

    public void setTampada(boolean tampada) {

        this.tampada = tampada;
    }

    public String getCor() {

        return cor;
    }

    public void setCor(String cor) {

        this.cor = cor;
    }
}
