package exo2;
public class Fabrique3D implements FabriqueJoueurs {

    @Override
    public Joueur creerJoueur(String nom) {
        return new Joueur3D(nom);
    }
}