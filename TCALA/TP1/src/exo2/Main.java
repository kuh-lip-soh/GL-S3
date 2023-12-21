package exo2;
public class Main {

    public static void main(String[] args) {
        FabriqueJoueurs fabrique = new Fabrique2D();
        Joueur joueur = fabrique.creerJoueur("Lionel Messi");
        joueur.jouer();

        fabrique = new Fabrique3D();
        joueur = fabrique.creerJoueur("Zinedine Zidane");
        joueur.jouer();
    }

}