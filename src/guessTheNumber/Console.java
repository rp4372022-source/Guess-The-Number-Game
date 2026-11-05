package guessTheNumber;

import java.util.Scanner;
import java.util.Random;

class Console {
    Engine engine = new Engine();

    private void setInitialParameters(Scanner sc){
        System.out.print("Enter range min value : ");
        int initialRangeValue = sc.nextInt();
        System.out.print("Enter range max value : ");
        int finalRangeValue = sc.nextInt();
        System.out.println();

        engine.setRangeMinimum(initialRangeValue);
        engine.setRangeMaximum(finalRangeValue);

        engine.generateComputerGuessedNumber();
    }
    private void play(Scanner sc, boolean stopSignal){

        while (!stopSignal) {
            System.out.print("Your turn\nGuess the number :");
            int playerGuessedNumber = sc.nextInt();

            switch (engine.match(playerGuessedNumber)) {
                case StateOfNumber.EQUAL -> {
                    System.out.println("Congratulations, you won!!!");
                    stopSignal = true;
                }
                case StateOfNumber.HIGHER -> System.out.println("Higher");
                case StateOfNumber.LOWER -> System.out.println("Lower");
            }

            int computerCurrentGuessedNumber = engine.generateNumber();
            System.out.println("Computers turn\nIs you number " + computerCurrentGuessedNumber + " ?");
            System.out.println("1.Yes 2.Higher 3.Lower");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Computer Won, good game");
                    stopSignal = true;
                }
                case 2 -> engine.setRangeMinimum(computerCurrentGuessedNumber + 1);
                case 3 -> engine.setRangeMaximum(computerCurrentGuessedNumber - 1);
            }
        }
    }

    private boolean endOptions(Scanner sc){
        System.out.println("\n1.Quit 2.Rematch");
        int choice = sc.nextInt();
        return choice == 1;
    }
    public void run(){
        Scanner sc = new Scanner(System.in);
        boolean stopSignal = false;
        while(!stopSignal) {
            setInitialParameters(sc);
            play(sc, stopSignal);
            stopSignal = endOptions(sc);
        }
    }
}
