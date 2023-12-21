package exo1;

abstract class Vehicule {
    double vitesse = 0;
    double vitesseMax;
    double longueur;

    public Vehicule(double longueur, double vitesseMax) {
        this.longueur = longueur;
        this.vitesseMax = vitesseMax;
    }

    public double getVitesse() {
        return vitesse;
    }

    public double getLongueur() {
        return longueur;
    }

    public void accelerer(double deltaV) {
        vitesse += deltaV;
        if (vitesse > vitesseMax) {
            vitesse = vitesseMax;
        }
    }

    public void decelerer(double deltaV) {
        vitesse -= deltaV;
        if (vitesse < 0) {
            vitesse = 0;
        }
    }

    public String toString() {
        return "Vitesse: " + vitesse + " km/h, Longueur: " + longueur + " m" +", Vitesse max: " + vitesseMax + " km/h";
    }
}
