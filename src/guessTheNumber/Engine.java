package guessTheNumber;

//import java.util.concurrent.ThreadLocalRandom;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    Random random = new Random();
    private int rangeMinimum;
    private int rangeMaximum;

    private int computerGuessedNumber;

    protected int generateNumber() {
        //return ThreadLocalRandom.current().nextInt(this.rangeMinimum, this.rangeMaximum + 1);//inclusive,exclusive
        return random.nextInt(rangeMinimum, rangeMaximum+1);
    }

    protected void generateComputerGuessedNumber(){
        this.computerGuessedNumber = generateNumber();
    }
    protected void setRangeMinimum(int rangeMinimum){
        this.rangeMinimum = rangeMinimum;
    }
    protected void setRangeMaximum(int rangeMaximum){
        this.rangeMaximum = rangeMaximum;
    }

    protected StateOfNumber match(int playerGuessedNumber){
        if( this.computerGuessedNumber == playerGuessedNumber)
            return StateOfNumber.EQUAL;
        else if(this.computerGuessedNumber < playerGuessedNumber)
            return StateOfNumber.HIGHER;
        else
            return StateOfNumber.LOWER;
    }
}
