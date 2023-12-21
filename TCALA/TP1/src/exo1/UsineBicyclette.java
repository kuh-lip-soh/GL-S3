package exo1;

public class UsineBicyclette implements UsineVehicule {
	@Override
    public Vehicule createVehicule() {
        return new Bicyclette(1.5, 30);
    }
}
