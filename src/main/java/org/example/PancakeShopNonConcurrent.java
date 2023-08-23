package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PancakeShopNonConcurrent {

    private static final int MAX_PANCAKES_SHOPKEEPER = 12;
    private static final int MAX_PANCAKES_USER = 5;
    private static final int NUM_USERS = 3;

    private static int totalPancakesMade = 0;
    private static int totalPancakesEaten = 0;
    private static int totalOrdersNotMet = 0;
    private static int totalPancakesWasted = 0;

    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                int pancakesMade = new Random().nextInt(MAX_PANCAKES_SHOPKEEPER + 1);

                int[] pancakesOrdered = new int[NUM_USERS];
                for (int i = 0; i < NUM_USERS; i++) {
                    pancakesOrdered[i] = new Random().nextInt(MAX_PANCAKES_USER + 1);
                }

                int totalPancakesOrdered = 0;
                for (int pancakes : pancakesOrdered) {
                    totalPancakesOrdered += pancakes;
                }

                int pancakesEaten = Math.min(totalPancakesOrdered, totalPancakesMade);
                int ordersNotMet = totalPancakesOrdered - pancakesEaten;
                int pancakesWasted = totalPancakesMade - pancakesEaten;

                totalPancakesMade += pancakesMade;
                totalPancakesEaten += pancakesEaten;
                totalOrdersNotMet += ordersNotMet;
                totalPancakesWasted += pancakesWasted;

                System.out.println("Starting time: " + System.currentTimeMillis());
                System.out.println("Ending time: " + (System.currentTimeMillis() + 30000));
                System.out.println("Number of pancakes made by the shopkeeper: " + pancakesMade);
                System.out.println("Number of pancakes eaten by users: " + pancakesEaten);
                System.out.println("Orders not met: " + ordersNotMet);
                System.out.println("Pancakes wasted: " + pancakesWasted);
                System.out.println("Total pancakes made: " + totalPancakesMade);
                System.out.println("Total pancakes eaten: " + totalPancakesEaten);
                System.out.println("Total orders not met: " + totalOrdersNotMet);
                System.out.println("Total pancakes wasted: " + totalPancakesWasted);

                System.out.println(11111111);
                System.out.println(22222222);
                System.out.println(33333333);
                System.out.println(44444444);
            }
        };

        timer.schedule(task, 0, 30000);
    }
}
