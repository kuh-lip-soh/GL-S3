package exo2;

public class OctObserver implements Observer {
    @Override
    public void update(int state) {
        System.out.println("Conversion Octale : " + Integer.toOctalString(state));
    }
}