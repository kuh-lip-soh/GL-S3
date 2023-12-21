package exo2;
public class Joueur3D extends JoueurAbstrait {

    public Joueur3D(String nom) {
        super(nom);
    }

    @Override
    public void jouer() {
        System.out.println(this.nom + " joue au foot en 3D");
    }
}
