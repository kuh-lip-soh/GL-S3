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
        		new int[] {32, 10 ,2000},
        		new int[] {10, 50, 2000},
        		new int[] {10, 10, 3500},
        		new int[] {-5, 10, 2000},
        		new int[] {10, -2, 2000},
        		new int[] {10, 10, 1000},
        		new int[] {31, 12, 2000},
        		new int[] {31, 1, 2000},
        		new int[] {30, 4, 2000},
        		new int[] {28, 2, 2000},
        		new int[] {28, 2, 2001}
        );
    }
	
    @ParameterizedTest
    @MethodSource("Parametres")
	public void CalculerTest(int p[]) {
		try {
			int[] result = lendemain.Calculer(p[0], p[1], p[2]);
			fail("Une exception doit être levée si une donnée est invalide");
		}
		catch (IllegalArgumentException aExp){
			assert (aExp.getMessage().contains("Jour"));
			assert (aExp.getMessage().contains("Mois"));
			assert (aExp.getMessage().contains("Année"));
		}
	
	}

}
