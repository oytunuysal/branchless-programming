package branchless.src;

import java.util.Random;

public class Brachless {
    public static void main(String[] args) throws Exception {
        int[] randomNumbers = new int[10000];
        Random random = new Random();
        int currentNumber = 0;
        int[] operation = new int[10];
        int[] operation1 = new int[10];

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(10);
        }
      //  System.out.println("number = " + (randomNumbers[1]));
      //  System.out.println("result = " + (((5 - randomNumbers[1])>>>31)&1));

        // with branches
        long branchTime = System.nanoTime();
        for (int i = 0; i < randomNumbers.length; i++) {
            currentNumber = randomNumbers[i];
            if (currentNumber > 9) {
                operation[9] = operation[9] + 1;
            }

            if (currentNumber > 8) {
                operation[8] = operation[8] + 1;
            }

            if (currentNumber > 7) {
                operation[7] = operation[7] + 1;
            }

            if (currentNumber > 6) {
                operation[6] = operation[6] + 1;
            }

            if (currentNumber > 5) {
                operation[5] = operation[5] + 1;
            }

            if (currentNumber > 4) {
                operation[4] = operation[4] + 1;
            }

            if (currentNumber > 3) {
                operation[3] = operation[3] + 1;
            }

            if (currentNumber > 2) {
                operation[2] = operation[2] + 1;
            }

            if (currentNumber > 1) {
                operation[1] = operation[1] + 1;
            }
        }
        branchTime = System.nanoTime() - branchTime;


        // with else branches 
        long elseBranchTime = System.nanoTime();
        for (int i = 0; i < randomNumbers.length; i++) {
            currentNumber = randomNumbers[i];
            if (currentNumber > 9) {
                operation[9] = operation[9] + 1;
                operation[8] = operation[8] + 1;
                operation[7] = operation[7] + 1;
                operation[6] = operation[6] + 1;
                operation[5] = operation[5] + 1;
                operation[4] = operation[4] + 1;
                operation[3] = operation[3] + 1;
                operation[2] = operation[2] + 1;
                operation[1] = operation[1] + 1;
            }else if (currentNumber > 8) {
                operation[8] = operation[8] + 1;
                operation[7] = operation[7] + 1;
                operation[6] = operation[6] + 1;
                operation[5] = operation[5] + 1;
                operation[4] = operation[4] + 1;
                operation[3] = operation[3] + 1;
                operation[2] = operation[2] + 1;
                operation[1] = operation[1] + 1;
            }else if (currentNumber > 7) {
                operation[7] = operation[7] + 1;
                operation[6] = operation[6] + 1;
                operation[5] = operation[5] + 1;
                operation[4] = operation[4] + 1;
                operation[3] = operation[3] + 1;
                operation[2] = operation[2] + 1;
                operation[1] = operation[1] + 1;
            }else if (currentNumber > 6) {
                operation[6] = operation[6] + 1;
                operation[5] = operation[5] + 1;
                operation[4] = operation[4] + 1;
                operation[3] = operation[3] + 1;
                operation[2] = operation[2] + 1;
                operation[1] = operation[1] + 1;
            }else if (currentNumber > 5) {
                operation[5] = operation[5] + 1;
                operation[4] = operation[4] + 1;
                operation[3] = operation[3] + 1;
                operation[2] = operation[2] + 1;
                operation[1] = operation[1] + 1;
            }else if (currentNumber > 4) {
                operation[4] = operation[4] + 1;
                operation[3] = operation[3] + 1;
                operation[2] = operation[2] + 1;
                operation[1] = operation[1] + 1;
            }else if (currentNumber > 3) {
                operation[3] = operation[3] + 1;
                operation[2] = operation[2] + 1;
                operation[1] = operation[1] + 1;
            }else if (currentNumber > 2) {
                operation[2] = operation[2] + 1;
                operation[1] = operation[1] + 1;
            }else if (currentNumber > 1) {
                operation[1] = operation[1] + 1;
            }
        }
        elseBranchTime = System.nanoTime() - elseBranchTime;


        // branchless
        long brachlessTime = System.nanoTime();
        for (int i = 0; i < randomNumbers.length; i++) {
            currentNumber = randomNumbers[i];
            operation1[9] = operation1[9] + ((9 - currentNumber)>>>31&1);
            operation1[8] = operation1[8] + ((8 - currentNumber)>>>31&1);
            operation1[7] = operation1[7] + ((7 - currentNumber)>>>31&1);
            operation1[6] = operation1[6] + ((6 - currentNumber)>>>31&1);
            operation1[5] = operation1[5] + ((5 - currentNumber)>>>31&1);
            operation1[4] = operation1[4] + ((4 - currentNumber)>>>31&1);
            operation1[3] = operation1[3] + ((3 - currentNumber)>>>31&1);
            operation1[2] = operation1[2] + ((2 - currentNumber)>>>31&1);
            operation1[1] = operation1[1] + ((1 - currentNumber)>>>31&1);
        }
        brachlessTime = System.nanoTime() - brachlessTime;

        System.out.println("Branch Time : " + branchTime);
        System.out.println("Else Branch Time : " + elseBranchTime);
        System.out.println("Branchless Time : " + brachlessTime);
    }
}
