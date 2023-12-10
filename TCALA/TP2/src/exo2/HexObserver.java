package exo2;

public class HexObserver implements Observer {
    @Override
    public void update(int state) {
        System.out.println("Conversion Hexadecimale : " + Integer.toHexString(state));
    }
}