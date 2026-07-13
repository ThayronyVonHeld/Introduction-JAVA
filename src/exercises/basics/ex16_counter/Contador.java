package ex16_counter;

public class Contador {

    public static void main(String[] args) {
        int i = 0;

        while(i < 15){
            i++;
            if(i == 2 || i==3 || i==4){
                continue; // O continue pula essas condições
            }
            if (i == 7){
                break; // o break interrompe o fluxo
            }
            System.out.println("conte " + i);

        }
    }

}