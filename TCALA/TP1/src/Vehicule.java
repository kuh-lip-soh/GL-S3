
public abstract class Vehicule {
    double vitesse = 0;
    double vitesseMax;
    double longueur;
    
    public Vehicule (double vitesseMax, double longueur)
    {
        this.vitesseMax=vitesseMax;
        this.longueur=longueur;
    }
    
    public void getVitesse(double vitesse)
    {
        this.vitesse = vitesse;
    }
    
    public void getLongueur(double longueur)
    {
        this.longueur = longueur;
    }
    
    public void accelerer(double deltaV)
    {
        if(vitesse + deltaV<=vitesseMax)
            vitesse += deltaV;
        else
            vitesse = vitesseMax;
    }
    
    public void decelerer(double deltaV)
    {
        if(vitesse - deltaV>=0)
            vitesse -= deltaV;
        else
            vitesse = 0;
    }
    
    public String toString()
    {
        return "Vitesse : "+vitesse+"\nVitesse Max : "+vitesseMax+"\nLongueur : "+longueur;
    }
}
