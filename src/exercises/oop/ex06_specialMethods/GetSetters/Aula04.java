package ex06_specialMethods.GetSetters;

public class Aula04 {
    public static void main(String[] args) {
    Caneta c1 = new Caneta();

    c1.setModelo("Bic");
    // c1.modelo = "bic"; Como modelo é public podemos fazer essa declaração

    c1.setPonta(0.5f);
    // c1.ponta = 0.5f; Como ponta é privada, só podemos mudar o atributo apenas pelo método setter

       // System.out.println("Tenho uma caneta: " + c1.getModelo() + " de ponta: " + c1.getPonta());
       c1.status();

    }
}
