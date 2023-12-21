package exo2;
public abstract class JoueurAbstrait implements Joueur {

    protected String nom;

    public JoueurAbstrait(String nom) {
        this.nom = nom;
    }

    @Override
    public void jouer() {
        System.out.println(this.nom + " joue");
    }

}