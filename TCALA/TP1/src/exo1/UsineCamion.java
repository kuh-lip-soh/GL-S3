package exo1;

class UsineCamion implements UsineVehicule {
    @Override
    public Vehicule createVehicule() {
        return new Camion(12, 80);
    }
}