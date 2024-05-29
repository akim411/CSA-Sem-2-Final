// package main.java;

import java.util.Scanner;

public class Room {
    private static final Scanner scanner = new Scanner(System.in);
    // boolean to track if there is still an item in the room
    private boolean item;
    private Adventurer player;

    public Room(Adventurer a) {
        // initializes item
        item = true;
        player = a;
    }

    // if player takes item, room is empty
    public void take() {
        item = false;
    }

    // ask player if they want to look around the room or exit
    public void entered() {
        System.out.println("You have entered a room. What would you like to do? \n 1. Look around \n 2. Exit room");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            look();
            return;
        } else if (input.equals("2")) {
            exit();
        } else {
            System.out.println("Invalid input. Try again!");
            entered();
        }
    }

    // player exits room
    public void exit() {
        System.out.println("You have exited the room.");
    }

    // ask the player if they want to exit the room
    public void askExit() {
        System.out.println("Would you like to exit the room? (Yes/No)");
        String input = scanner.nextLine();
        if (input.equals("Yes")) {
            exit();
        } else if (input.equals("No")) {
            // if they don't want to exit, they look around the room again
            look();
        } else {
            System.out.println("Invalid input. Try again!");
            askExit();
        }
    }

    // checks if room is empty or not
    public boolean look() {
        if (!item) {
            System.out.println("The room is empty.");
            askExit();
            return false;
        }
        return true;
    }

    // returns Adventurer player
    public Adventurer getPlayer() {
        return player;
    }
}
