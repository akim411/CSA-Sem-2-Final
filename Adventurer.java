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

    // adds a potion or token to player's inventory
    public void addInv(String item) {
        for (int i = 0; i < 5; i++) {
            if (inv[i].equals("")) {
                inv[i] = item;
                return;
            }
        }
        // if all 5 slots are full, player can't add item to inventory
        System.out.println("Oh no! Your inventory is full. You must use an item to empty a slot.");
    }

    // returns the number of tokens in the player's inventory
    public int numTokens() {
        int tCnt = 0;
        for (String s : inv) {
            if (s.equals("token")) {
                tCnt++;
            }
        }
        return tCnt;
    }

    // player uses potion from their inventory
    public String use() {
        // count how many potions and tokens are in the player's inventory
        int pCnt = 0;
        int tCnt = 0;
        for (String s : inv) {
            if (s.equals("token")) {
                tCnt++;
            } else if (s.equals("potion")) {
                pCnt++;
            }
        }
        // print number of potions and tokens in player's inventory
        System.out.println(
                "Your inventory has 5 slots. You are currently holding " + pCnt + " potions and " + tCnt + " tokens.");
        // if player has potions in their inventory, ask if htey would like to use one
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

    // when player uses a potion, they have a 1/10 chance of a vision potion, 2/10
    // chance of a poison potion, and 7/10 chance of a potion with no effect
    public String usePotion() {
        Random rand = new Random();
        String potion;
        // remove potion the player is using from their inventory
        for (int i = 0; i < 5; i++) {
            if (inv[i].equals("potion")) {
                inv[i] = "";
                break;
            }
        }
        // roll random to choose effect of potion
        int temp = rand.nextInt(10);
        if (temp == 0) {
            potion = "vision";
        } else if (temp > 7) {
            potion = "poison";
        } else {
            potion = "nothing";
        }
        if (potion.equals("vision")) {
            // if player gets vision potion, map prints where location of tokens are
            // revealed
            System.out.println("You have taken a vision potion! You can now see which rooms the tokens are located.");
            System.out.println(
                    "X  |*|  X  |*|  X  | |  X  |*|  X   X  \n -   -   -   -   -   -   -   -   - [] \nX   X  |*|  X  | |  X  |*|  X  | |  X");
            return "";
        } else if (potion.equals("poison")) {
            // if player gets poison potion, game over
            System.out.println("Oh no! You have taken a potion of poison, game over!");
            return "end";
        } else {
            System.out.println("This potion has no effect.");
            return "";
        }
    }
}