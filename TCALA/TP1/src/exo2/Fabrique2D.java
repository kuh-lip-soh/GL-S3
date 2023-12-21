package exo2;
public class Fabrique2D implements FabriqueJoueurs {

    @Override
    public Joueur creerJoueur(String nom) {
        return new Joueur2D(nom);
    }

}
