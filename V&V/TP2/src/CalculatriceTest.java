import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatriceTest {

	public CalculatriceTest() {
    }

    @Test
    public void racineCarreTest() {
        try {
            Calculatrice.racineCarree(10);
            fail("Une exception doit etre lever si on calcule la racine carre d'un nombre negatif");
        } catch (IllegalArgumentException aExp) {
            assert (aExp.getMessage().contains("nombre negative"));
        }
    }

}
