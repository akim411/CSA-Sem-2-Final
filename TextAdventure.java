package main.java;

import java.util.Scanner;
import java.util.ArrayList;

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
                    "You have an inventory of 5 items. Once you have all 5 tokens you may head to the room at the end of the hallway and exit. \n But do not try to exit without your tokens...");
            map.printMap();
            System.out.println(
                    "Here is the map of the mansion. Your position is marked with a '!', the doors are marked with '| |', the hallway is marked with '-', and the brackets mark the exit.");
        }
    }

    public void loseGame() {
        // if the player loses, ask if they want to play again or exit
        System.out.println("Game over! Type R to restart!");
        String input = scanner.nextLine();
        if (input.equals("R")) {
            return;
        } else {
            endGame();
        }
    }

    public void endGame() {
        // switches run boolean to off to end game
        System.out.println("Game closing...thank you for playing!");
        run = false;
    }
}
