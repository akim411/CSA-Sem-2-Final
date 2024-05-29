// package main.java;

import java.util.Scanner;

public class TextAdventure {
    private static final Scanner scanner = new Scanner(System.in);
    // boolean that switches to false when the game ends
    private static boolean run = true;
    // map for the game
    private static AdventureModel map = new AdventureModel();

    public static void main(String[] args) {
        while (run) {
            // print introduction for the player
            System.out.println(
                    "Welcome, adventurer! \n It seems like you have found yourself trapped in a strange mansion. \n If you look down the hallway you'll see a series of doors. Behind each door is a room, in these rooms you will find the 5 tokens needed to escape. \n But beware! Tokens are not the only things in these rooms...");
            System.out.println(
                    "You have an inventory of 5 items. Once you have all 5 tokens you may head to the portal at the end of the hallway and exit. \n But do not try to exit without your tokens...");
            System.out.println(
                    "Here is the map of the mansion. Your position is marked with a '!', the doors are marked with '| |', the hallway is marked with '-', and the brackets mark the exit portal.");
            // begins the player's first turn
            turn();
        }
    }

    // asks the player what they would like to do on their current turn
    public static void turn() {
        map.printMap();
        System.out.println(
                "What would you like to do next? \n 1. Move forward \n 2. Move backwards \n 3. Enter room \n 4. Use item \n 5. Use exit portal");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            // player moves right, gets another turn
            map.moveForward();
            turn();
        } else if (input.equals("2")) {
            // player moves left, gets another turn
            map.moveBackwards();
            turn();
        } else if (input.equals("3")) {
            // player enters room, gets another turn once room is exited
            map.enterRoom();
            turn();
        } else if (input.equals("4")) {
            // player is able to use potions in their inventory, gets another turn unless
            // they take the potion of poison
            String temp = map.getPlayer().use();
            if (temp.equals("end")) {
                // if the player takes the potion of poison, game over
                loseGame();
            } else {
                turn();
            }
        } else if (input.equals("5")) {
            // player attempts to finish the game
            int temp = map.getPlayer().numTokens();
            if (temp == 5) {
                // if player has all 5 tokens, they win and finish the game
                winGame();
            } else {
                // if player tries to finish without all 5 tokens, game over
                System.out.println(
                        "Uh oh! You have not collected enough tokens to use the portal! We warned you not to try this...");
                loseGame();
            }
        } else {
            System.out.println("Invalid input. Try again!");
            turn();
        }
    }

    // player successfully exits with all 5 tokens, ask if they want to play again
    // or exit
    public static void winGame() {
        System.out.println(
                "Congratulations! You have collected the 5 tokens to go through the portal! You have left the mansion and returned to safety.");
        System.out.println("Type R to restart.");
        String input = scanner.nextLine();
        if (input.equals("R")) {
            return;
        } else {
            endGame();
        }
    }

    // player takes poison or tries to exit without all 5 tokens, ask if they want
    // to play again or exit
    public static void loseGame() {
        // if the player loses, ask if they want to play again or exit
        System.out.println("Game over! Type R to restart!");
        String input = scanner.nextLine();
        if (input.equals("R")) {
            return;
        } else {
            endGame();
        }
    }

    // player exits game
    public static void endGame() {
        // switches run boolean to off to end game
        System.out.println("Game closing...thank you for playing!");
        run = false;
    }
}
