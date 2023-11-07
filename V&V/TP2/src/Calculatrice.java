import static java.lang.Math.sqrt;

public class Calculatrice {

    public double racineCarree(int x) throws IllegalArgumentException {

        if (x <= 0) {
            throw new IllegalArgumentException("Impossible de calculer la racine carree d'un nombre negative");
        } else {
            return sqrt(x);
        }
    }

    public double diviser(int x, int y) throws IllegalArgumentException {
        if (y == 0) {
            throw new IllegalArgumentException("impossible de diviser par 0");
        } else {
            return x / y;
        }
    }
}
