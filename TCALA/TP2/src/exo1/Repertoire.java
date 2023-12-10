package exo1;

import java.util.HashMap;
import java.util.Map;

public class Repertoire extends RepParent{
    HashMap<String,RepParent> liste= new HashMap<>();
    Repertoire(String n){
        nom=n;
    }
    public  void Ajouter(RepParent r){
        this.liste.put(r.nom,r);
    }

    public void Lister(){

        if(this.nom ==null)
            System.out.println(" Repertoire n'existe pas!!");
        else
        if(!this.liste.isEmpty()){
            for (Map.Entry<String,RepParent> m :liste.entrySet()) {
                System.out.println("Nom: "+m.getKey());
            }}
        else
            System.out.println(this.nom+" est vide");

    }
   public RepParent Parent(){
      return this.rp;
   }
    public void Renommer(String n){
    	 this.nom=n;
    }

    public void Effacer(){
        if(!this.liste.isEmpty())
        {
            for (Map.Entry<String,RepParent> m : liste.entrySet()) {
                   System.out.println(m.getKey());
                    (m.getValue()).Effacer();
                }
        }
       this.rp.EffacerFichier(this.nom);
       this.nom=null;
       this.rp=null;
    }
    public void EffacerFichier(String nom){

        liste.remove(nom);
    }
    public RepParent cd(String name){
        for (Map.Entry<String,RepParent> m : liste.entrySet()) {
            if((m.getKey()).equals(name)) {
                return m.getValue();
            }
        }
        return null;
    }
}
