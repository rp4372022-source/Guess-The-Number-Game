package guessTheNumber;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

class Engine {
    private int lowest;
    private int highest;

    int machineGeneratedNumber;

    int generateNumber() {
        return ThreadLocalRandom.current().nextInt(this.lowest, this.highest + 1);//enclusive,exclusive
    }

    void setmMchineGeneratedRandomNumber(int num){
        machineGeneratedNumber = num;
    }
    void setRange(int lowest, int highest) {
        this.lowest = lowest;
        this.highest = highest;
    }
    void setMaxRange(int max){highest = max;}
    void setMinRange(int min){lowest = min;}
    int getNumber(){
        return machineGeneratedNumber;
    }
    boolean match(int num1,int num2){
        if(num1 == num2) return true;
        return false;
    }

}
class Console{
    Scanner sc = new Scanner(System.in);
    Engine engine = new Engine();

    void initialRangeSetUp(){
        //Scanner sc = new Scanner(System.in);

        System.out.print("Enter lowest number in range :");
        int low = sc.nextInt();
        System.out.print("Enter highest number in range :");
        int high = sc.nextInt();

        engine.setRange(low,high);
        //System.out.print(low+" "+high);

        int num = engine.generateNumber();
        engine.setmMchineGeneratedRandomNumber(num);
    }

    void running(){

        while(true){
            System.out.print("Guess the number :");
            int playerGuessedNumber = sc.nextInt();

            if(playerGuessedNumber == engine.getNumber()){
                System.out.println("Win");
                break;
            } else if(playerGuessedNumber < engine.getNumber()){
                System.out.println("Higher");
            } else {
                System.out.println("Lower");
            }

            int machineGeneratedNumber = engine.generateNumber();
            System.out.println("Is your number is "+machineGeneratedNumber);
            System.out.println("1.Yes 2.Higher 3.Lower");
            int playerAnswer = sc.nextInt();
            if(playerAnswer == 1){
                System.out.println("Lose");
                break;
            } else if (playerAnswer == 2){
                engine.setMinRange(machineGeneratedNumber+1);
            } else if(playerAnswer == 3){
                engine.setMaxRange(machineGeneratedNumber);
            }
        }
    }
}

public class NumberGuess {
    public static void play(){

        Console console = new Console();
        console.initialRangeSetUp();
        console.running();
    }
}