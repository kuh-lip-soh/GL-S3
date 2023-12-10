package exo1;

import java.util.Scanner;

public class Main {
    public  static void main(String[] args){
        System.out.println("Indiquez le nom de votre fichier\n");
        Scanner scn=new Scanner(System.in);
        String nom1= scn.next();
        RepParent rpp =new Repertoire("Repertoire père");
        RepParent fichier1,rp2,rp3,fichier2;

        System.out.println("Indiquez le nom de votre repertoire\n");
        scn=new Scanner(System.in);
        String nom= scn.next();

            fichier1=new Fichier(nom1);
            rp2=new Repertoire(nom);
            rp3=new Repertoire("rep3");
            fichier2=new Fichier("shmem.txt");

            ((Repertoire) rp3).Ajouter(fichier2);
            ((Repertoire) rpp).Ajouter(rp2);
              fichier2.rp=rp3;

            ((Repertoire) rp2).Ajouter(fichier1);
            ((Repertoire) rp2).Ajouter(rp3);

            rp3.rp=rp2;
            fichier1.rp=rp2;
            rp2.rp=rpp;
           System.out.println("Avant avoir renommé");
           ((Repertoire) rp2).Lister(); 

           rp2.Renommer("rep2");
           System.out.println("Apres avoir renommé");
           ((Repertoire) rp2).Lister();
           
           if(((Repertoire) rp2).cd("fichierfils") != null)
        	   System.out.println("le fichier ou le dossier existe");
        	else
        		System.out.println("n'existe pas");

        ((Repertoire) rp3).Effacer();
        ((Repertoire) rp2).Lister();
        ((Repertoire) rp3).Lister();
    }
}

