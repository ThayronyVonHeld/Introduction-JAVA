package ex15_bankSystem;

import java.util.Scanner;

public class ContaBanco {

    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    Scanner teclado = new Scanner(System.in);

    public void infoConta(){
       System.out.println("-------------------------------");
       System.out.println("Conta: " + this.getNumConta());
       System.out.println("Tipo: " + this.getTipo());
       System.out.println("Dono: " + this.getDono());
       System.out.println("Saldo: " + this.getSaldo());
       System.out.println("Status: " + this.getStatus());
       System.out.println("-------------------------------");
   }

    public ContaBanco() { //Construtor
        this.setStatus(false); // ou this.status = false;
        this.setSaldo(0); // ou this.saldo = 0;

    }

    //Metodos
    public void abrirConta() {
        this.setStatus(true);
        int Valor;

        System.out.print("Digite o Numero desejado da conta: ");
        this.setNumConta(teclado.nextInt());
        teclado.nextLine();
        System.out.print("Digite seu nome: ");
        this.setDono(teclado.nextLine());

        System.out.println("Digite o Tipo de conta:");
        System.out.print("Digite [1] para Conta Corrente ou Digite [2] para Conta Poupança: ");
        Valor = teclado.nextInt();

        if(Valor == 1){
            this.setTipo("Conta Corrente");
            this.setSaldo(50);
        }
        else if(Valor == 2){
            this.setTipo("Conta Poupança");
            this.setSaldo(150);
        }
        else{
            System.out.println("Resposta incorreta! Selecione [1] ou [2]!");
        }


    }


    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Saque todo o valor da sua conta para fechar");
        } else if (getSaldo() < 0) {
            System.out.println("Sua conta Posui saldo negativo, para fechar, deposite o valor restante: Valor restante: " + getSaldo());
        } else {
            this.setStatus(false);
            System.out.println("Sua Conta foi Fechada");
        }
    }

    public void depositar() {
        if (this.getStatus()) {
            System.out.println("Digite o valor que deseja depositar: ");
            this.setSaldo(this.getSaldo() + teclado.nextFloat());
            System.out.println("Deposito realizado com sucesso na conta de " + this.getDono());
        }
        else {
            System.out.println("Impossivel depositar em uma conta fechada");
        }
    }

    public void sacar() {
        if (this.getStatus()) {
            float saque = this.getSaldo();
            if (this.getSaldo() >= 0) {
                System.out.println("Digite o valor que deseja sacar: ");
                saque -= teclado.nextFloat();
                    if(saque < 0){
                        System.out.println("Você escolheu um valor maior que o Disponivel, escolha um valor menor, ou deposite");
                    }
                    else{
                        System.out.println("Saque realizado com sucesso.");
                        this.setSaldo(saque);
                    }
            }
        }else {
            System.out.println("Você precisa abrir sua conta, antes de tentar efetuar um saque!");
        }

    }

    public void pagarMensal() {
        if(this.getStatus()){
            if (this.tipo.equals("Conta Corrente")) {
                this.setSaldo(this.getSaldo() - 12);
                System.out.println("Mensalidade Paga com Sucesso");
            } else {
                this.setSaldo(this.getSaldo() - 20);
                System.out.println("Mensalidade Paga com Sucesso");
            }
        }
        else {
            System.out.println("Impossivel pagar a mensalidade de uma conta fechada");
        }
    }

    //Metodos especiais
    public int getNumConta() {
        return this.numConta;
    }

    public void setNumConta(int nc) {
        this.numConta = nc;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String t) {
        this.tipo = t;
    }


    public String getDono() {
        return this.dono;
    }

        public void setDono(String d){
        this.dono = d;
        }

    public float getSaldo() {
        return this.saldo;
    }

        public void setSaldo(float s) {
            this.saldo = s;

    }

    public boolean getStatus(){
        return this.status;
    }

    public void setStatus(boolean stts){
        this.status = stts;
    }

}