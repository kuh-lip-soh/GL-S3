package exo2;

public class BinObserver implements Observer {
    @Override
    public void update(int state) {
        System.out.println("Conversion Binaire : " + Integer.toBinaryString(state));
    }
}