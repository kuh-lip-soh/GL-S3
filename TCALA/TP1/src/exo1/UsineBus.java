package exo1;

public class UsineBus implements UsineVehicule {
	@Override
    public Vehicule createVehicule() {
        return new Bus(18, 90);
    }
}
