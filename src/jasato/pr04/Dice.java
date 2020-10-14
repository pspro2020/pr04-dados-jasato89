package jasato.pr04;

import java.util.Random;

public class Dice implements Runnable {

    public static volatile int[] diceRolls = new int[6];
    public static int totalThrows;
    protected final int numThrows = 100000;
    Random random = new Random();


    @Override
    public synchronized void run() {
        int result;
        for (int i = 0; i < numThrows; i++) {

            result = random.nextInt(6) + 1;
            switch (result) {
                case 1:
                    diceRolls[0] += 1;
                    break;
                case 2:
                    diceRolls[1] += 1;
                    break;
                case 3:
                    diceRolls[2] += 1;
                    break;
                case 4:
                    diceRolls[3] += 1;
                    break;
                case 5:
                    diceRolls[4] += 1;
                    break;
                case 6:
                    diceRolls[5] += 1;
                    break;

            }
            totalThrows++;

        }
    }

    public int[] getDiceRolls() {
        return diceRolls;
    }

    public int getTotalThrows() {
        return totalThrows;
    }
}
