package exo2;
public class Joueur2D extends JoueurAbstrait {

    public Joueur2D(String nom) {
        super(nom);
    }

    @Override
    public void jouer() {
        System.out.println(this.nom + " joue au foot en 2D");
    }

}