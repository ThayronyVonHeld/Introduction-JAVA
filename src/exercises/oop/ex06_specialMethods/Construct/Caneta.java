package ex06_specialMethods.Construct;

public class Caneta {
   public String modelo;
   private float ponta;
   private boolean tampada;
   private String cor;

   public Caneta(String m, String c, float p){  // Para identificar um método construtor basta achar um método igual ao nome da classe
        this.modelo = m;
        this.cor = c;
        this.ponta = p;
        this.tampar();
    }
    public String getModelo() {     // Todo metodo getter é public
        return modelo;
    }

    public void setModelo(String m) {     // Todo Modelo Setters é publico
        this.modelo = m;
    }

    public float getPonta(){
        return ponta;
    }

    public void setPonta(float p){
        this.ponta = p;
    }
    public void tampar(){
       this.tampada = true;
    }
    public void destampada(){
       this.tampada = false;
    }
    public void status(){
        System.out.println("SOBRE A CANETA: ");
        System.out.println("Modelo: " + this.getModelo());// podemos usar também, this.modelo
        System.out.println("Ponta: " + this.getPonta());
        System.out.println("Cor: " + this.cor);
        System.out.println("Tampada: " + this.tampada);

    }
}
