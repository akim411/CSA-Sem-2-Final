// package main.java;

import java.util.Random;
import java.util.Scanner;

public class Adventurer {
    private static final Scanner scanner = new Scanner(System.in);
    // array to keep track of adventurer's inventory
    private String[] inv;

    public Adventurer() {
        // initialize empty inventory for adventurer
        inv = new String[] { "", "", "", "", "" };
    }

    public void addInv(String item) {
        for (int i = 0; i < 5; i++) {
            if (inv[i].equals("")) {
                inv[i] = item;
                return;
            }
        }
        System.out.println("Oh no! Your inventory is full. You must use an item to empty a slot.");
    }

    public int numTokens() {
        int tCnt = 0;
        for (String s : inv) {
            if (s.equals("token")) {
                tCnt++;
            }
        }
        return tCnt;
    }

    public String use() {
        int pCnt = 0;
        int tCnt = 0;
        for (String s : inv) {
            if (s.equals("token")) {
                tCnt++;
            } else if (s.equals("potion")) {
                pCnt++;
            }
        }
        System.out.println(
                "Your inventory has 5 slots. You are currently holding " + pCnt + " potions and " + tCnt + " tokens.");
        if (pCnt > 0) {
            System.out.println("Would you like to use a potion? (Yes/No)");
            String input = scanner.nextLine();
            if (input.equals("Yes")) {
                return usePotion();
            } else if (input.equals("No")) {
                return "";
            } else {
                System.out.println("Invalid input. Try again!");
                use();
            }
        }
        return "";
    }

    public String usePotion() {
        Random rand = new Random();
        String potion;
        for (int i = 0; i < 5; i++) {
            if (inv[i].equals("potion")) {
                inv[i] = "";
                break;
            }
        }
        int temp = rand.nextInt(10);
        if (temp == 0) {
            potion = "vision";
        } else if (temp > 8) {
            potion = "poison";
        } else {
            potion = "nothing";
        }
        if (potion.equals("vision")) {
            System.out.println("You have taken a vision potion! You can now see which rooms the tokens are located.");
            System.out.println(
                    "X  |*|  X  |*|  X  | |  X  |*|  X   X  \n -   -   -   -   -   -   -   -   - [] \nX   X  |*|  X  | |  X  |*|  X  | |  X");
            return "";
        } else if (potion.equals("poison")) {
            System.out.println("Oh no! You have taken a potion of poison, game over!");
            return "end";
        } else {
            System.out.println("This potion has no effect.");
            return "";
        }
    }
}