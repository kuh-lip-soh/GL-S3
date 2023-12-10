package exo2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Observable observable = new Observable();
        Observer hexObserver = new HexObserver();
        Observer octObserver = new BinObserver();
        Observer binObserver = new OctObserver();

        observable.addObserver(hexObserver);
        observable.addObserver(octObserver);
        observable.addObserver(binObserver);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Entrez un entier : ");
            int userInput = scanner.nextInt();
            observable.setState(userInput);
        }
    }
}