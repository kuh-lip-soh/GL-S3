package exo1;

import java.util.ArrayList;
import java.util.List;

public class ListeAbonnes {
    private List<AbonneBean> abonnes;

    public ListeAbonnes() {
        abonnes = new ArrayList<>();
    }

    public void ajouteAbonne(AbonneBean abonne) {
        abonnes.add(abonne);
    }

    public void supprimeAbonne(AbonneBean abonne) {
        abonnes.remove(abonne);
    }

    public List<AbonneBean> getAbonnes() {
        return abonnes;
    }
}
