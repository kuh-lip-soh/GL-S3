package exo1;

public class UsineVoiture implements UsineVehicule {
	@Override
    public Vehicule createVehicule() {
        return new Voiture(6, 120);
    }
}