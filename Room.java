// package main.java;

import java.util.Scanner;

public class Room {
    private static final Scanner scanner = new Scanner(System.in);
    private boolean item;
    private Adventurer player;

    public Room(Adventurer a) {
        item = true;
        player = a;
    }

    public void take() {
        item = false;
    }

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

    public void exit() {
        System.out.println("You have exited the room.");
    }

    public void askExit() {
        System.out.println("Would you like to exit the room? (Yes/No)");
        String input = scanner.nextLine();
        if (input.equals("Yes")) {
            exit();
        } else if (input.equals("No")) {
            look();
        } else {
            System.out.println("Invalid input. Try again!");
            askExit();
        }
    }

    public void look() {
        if (!item) {
            System.out.println("The room is empty.");
            askExit();
        }
    }

    public Adventurer getPlayer() {
        return player;
    }
}
