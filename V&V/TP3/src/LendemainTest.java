import static org.junit.Assert.*;
import java.util.Scanner;
import org.junit.*;

public class LendemainTest {

	private int j;
	private int m;
	private int a;
	private Scanner s;
	private Lendemain lendemain;
	
	@Before
	public void setUp() {
		lendemain = new Lendemain();
		s = new Scanner(System.in);
        System.out.print("Entrez le jour : ");
        j = s.nextInt();
        System.out.print("Entrez le mois : ");
        m = s.nextInt();
        System.out.print("Entrez l'année : ");
        a = s.nextInt();
	}
	
	@Test
	public void CalculerTest() {
		try {
			lendemain.Calculer(j,m,a);
		fail("Une exception doit être levée si une donnée est invalide");
		}
		catch (IllegalArgumentException aExp){
			assert (aExp.getMessage().contains("Jour"));
			assert (aExp.getMessage().contains("Mois"));
			assert (aExp.getMessage().contains("Année"));
		}
	
	}

}
