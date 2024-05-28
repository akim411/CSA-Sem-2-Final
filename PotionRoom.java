// package main.java;

import java.util.Scanner;

public class PotionRoom extends Room {
    private static final Scanner scanner = new Scanner(System.in);

    public PotionRoom(Adventurer a) {
        super(a);
    }

    public void look() {
        super.look();
        System.out.println(
                "You are looking around the room...and you find a potion! But you're not sure what the potion does.");
        System.out.println("What would you like to do? \n 1. Take potion \n 2. Exit room");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            take();
            return;
        } else if (input.equals("2")) {
            super.exit();
        } else {
            System.out.println("Invalid input. Try again!");
            look();
        }
    }

    public void take() {
        super.getPlayer().addInv("potion");
        super.take();
        super.askExit();
    }

}
