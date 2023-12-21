package exo1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Vehicule> parcAutomobile = new ArrayList<>();

        UsineVehicule usineBus = new UsineBus();
        UsineVehicule usineVoiture = new UsineVoiture();
        UsineVehicule usineBicyclette = new UsineBicyclette();

        for (int i = 0; i < 3; i++) {
            Vehicule bus = usineBus.createVehicule();
            parcAutomobile.add(bus);
        }
        
        for (int i = 0; i < 5; i++) {
            Vehicule voiture = usineVoiture.createVehicule();
            parcAutomobile.add(voiture);
        }

        for (int i = 0; i < 2; i++) {
            Vehicule bicyclette = usineBicyclette.createVehicule();
            parcAutomobile.add(bicyclette);
        }

        UsineVehicule usineCamion = new UsineCamion();
        Vehicule camion = usineCamion.createVehicule();
        parcAutomobile.add(camion);
        
        System.out.println("Parc Automobile :");
        for (Vehicule vehicule : parcAutomobile) {
            System.out.println(vehicule.toString());
        }
        

    }
}
