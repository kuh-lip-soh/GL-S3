import static org.junit.Assert.*;
import java.util.Scanner;
import java.util.stream.Stream;
import org.junit.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.MethodSource;

public class LendemainTestStream {

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
	
	static Stream<int[]> Parametres() {
        return Stream.of(
                new int[]{1, 29, 30, 28, 30},
                new int[]{5, 2, 11, 8, 4},
                new int[]{1580, 1800, 2100, 1996, 3000}
        );
    }
	
    @ParameterizedTest
    @MethodSource("Parametres")
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
