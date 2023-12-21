package exo3_2;

import java.util.Scanner;



public class Main {
    public  static void main(String[] args) {
        System.out.println("Entrez la valeur de la chaine : ");
        Scanner scn = new Scanner(System.in);
        String ch = scn.next();
        Validateur v=new Validateur(ch);
        if(ch.endsWith("@gmail.com")|| ch.endsWith("@yahoo.com") || ch.endsWith("@live.fr")){
            v.setStrategie(new Mail());

            System.out.println("Votre chaine est un mail");
        }
        else {
            if(ch.matches("[+-]?\\d*(\\.\\d+)?")) {
                entier e1=new entier();
             v.setStrategie(e1);
             e1.entier=Integer.getInteger(ch);
                System.out.println("Votre chaine est un entier");
            }
        }

}
}
