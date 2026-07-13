package ex03_smartphone;

public class Smartphone {
        String modelo;
        String cor;
        int ram;
        boolean ligar;
        boolean desbloquear;

    void status(){
    if (this.ligar == true){
        System.out.println("Carregando...");
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Cor: " + this.cor);
        System.out.println("Memoria Ram: " + this.ram);
        System.out.println("====================================");
        System.out.println("Você Ligou seu Celular");
        System.out.println("====================================");
    }
    }

    void camera(){
    if(this.ligar == true && desbloquear == true) {
        System.out.println("Pode abrir sua camera");
        }

    }
    void desbloquear(){
        if(this.ligar == true) {
            this.desbloquear = true;
            System.out.print("Celular Desbloqueado!");
        } else{
            System.out.print("Celular Bloqueado!! Ligue o celular primeiro!");
        }
    }
}
