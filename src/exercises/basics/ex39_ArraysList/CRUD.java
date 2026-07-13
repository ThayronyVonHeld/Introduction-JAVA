package ex39_ArraysList;

import java.util.ArrayList;
import java.util.Scanner;

public class CRUD {

    /* Update futuro
    Criar uma classe contato, ArrayList<Contato>
     */

    public static void main(String[] args) {
        System.out.println("--------------------------------------");
        System.out.println("Cadastro de Contatos");

        int escolha = 0;

        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<String> numero = new ArrayList<>();

        Scanner teclado = new Scanner(System.in);

        do{
            System.out.println("--------------------------------------");
            System.out.println("Digite [1] para ADICIONAR um novo contato");
            System.out.println("Digite [2] para VER todos os seus contatos");
            System.out.println("Digite [3] para ALTERAR um contato");
            System.out.println("Digite [4] para REMOVER um contato");
            System.out.println("Digite [0] para SAIR");
            System.out.print("Digite sua escolha: ");
            escolha = teclado.nextInt();

            System.out.println("--------------------------------------");

            switch (escolha){
               case 1:
                   String continuar = "";
                   do{
                       System.out.print("Digite o nome do Contato: ");
                       nomes.add(teclado.next());
                       System.out.print("Digite o numero: ");
                       numero.add(teclado.next());
                       System.out.print("Deseja continuar adicionando? [S/N]: ");
                       continuar = teclado.next();
                       System.out.println("--------------------------------------");
                   }while(continuar.equals("S") || continuar.equals("s"));
                   break;

               case 2:
                   for(int i = 0; i < nomes.size(); i++){
                       System.out.println(i + "." + nomes.get(i) +
                               " | Telefone/Celular: " + numero.get(i));
                   }
                   break;

               case 3:
                   int valor;
                   System.out.println("Digite a posição da lista que deseja alterar: ");
                   valor = teclado.nextInt();

                   nomes.remove(valor);
                   numero.remove(valor);

                   System.out.println("Digite o nome do Contato: ");
                   nomes.add((valor), teclado.next());
                   System.out.println("Digite o numero: ");
                   numero.add((valor), teclado.next());

                   System.out.println("Alterado com sucesso!");
                 break;

               case 4:
                   int removed;
                   System.out.print("Digite a posição do contato que deseja excluir: ");
                   removed = teclado.nextInt();
                   nomes.remove(removed);
                   numero.remove(removed);
                   System.out.println("Contato excluido com sucesso!");
           }

        } while(escolha != 0);

    }
}
