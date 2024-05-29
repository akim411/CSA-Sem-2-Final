// package main.java;

import java.util.Scanner;

public class PotionRoom extends Room {
    private static final Scanner scanner = new Scanner(System.in);

    public PotionRoom(Adventurer a) {
        super(a);
    }

    // player can take any items found in the room
    public boolean look() {
        // check if room is empty
        if (!super.look()) {
            return false;
        }
        // if not empty, player finds a potion in the room and can either take it or
        // leave it
        System.out.println(
                "You are looking around the room...and you find a potion! But you're not sure what the potion does.");
        System.out.println("What would you like to do? \n 1. Take potion \n 2. Exit room");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            take();
        } else if (input.equals("2")) {
            super.exit();
        } else {
            System.out.println("Invalid input. Try again!");
            look();
        }
        return false;
    }

    // potion added to player's inventory and room set to empty
    public void take() {
        // add potion to player's inventory
        super.getPlayer().addInv("potion");
        // sets room to empty
        super.take();
        super.askExit();
    }

}
