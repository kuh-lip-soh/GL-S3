package exo1;

public class Fichier extends RepParent{
    public void Effacer(){
        this.rp.EffacerFichier(this.nom);
        this.nom= null;
        this.rp=null;
    }
    
    public void Renommer(String n){
       // ((Repertoire)this.rp).liste.put(n,this);
       // ((Repertoire)this.rp).liste.remove(this.nom);
        this.nom=n;
    }
    Fichier(String n){
        nom=n;
    }
}
