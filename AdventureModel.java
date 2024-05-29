// package main.java;

public class AdventureModel {
    // arraylist map to keep track of player's position and provide visual of doors
    private String[][] map = new String[3][10];
    // int to keep track of player's position
    private int playerX = 0;
    // array to store the rooms (potion rooms and token rooms)
    private Room[] rooms = new Room[8];
    private Adventurer player = new Adventurer();

    public AdventureModel() {
        // populate map with doors and player initial position
        map[0] = new String[] { " X ", "| |", " X ", "| |", " X ", "| |", " X ", "| |", " X ", " X " };
        map[1] = new String[] { " ! ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", "[ ]" };
        map[2] = new String[] { " X ", " X ", "| |", " X ", "| |", " X ", "| |", " X ", "| |", " X " };
        // populate rooms with the 5 token rooms and 3 potion rooms
        for (int i = 0; i < 8; i++) {
            if (i == 3 || i == 4 || i == 7) {
                PotionRoom tempRoom = new PotionRoom(player);
                rooms[i] = tempRoom;
            } else {
                TokenRoom tempRoom = new TokenRoom(player);
                rooms[i] = tempRoom;
            }
        }
    }

    // returns Adventurer player
    public Adventurer getPlayer() {
        return player;
    }

    // prints out the map for the player
    public void printMap() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    // player moves right one space
    public void moveForward() {
        // check if player is already at rightmost spot
        if (playerX == 8) {
            System.out.println("Player cannot move forwards.");
            return;
        }
        // change markers on map and change int of player's position
        map[1][playerX] = " - ";
        playerX++;
        map[1][playerX] = " ! ";
    }

    // player moves left one space
    public void moveBackwards() {
        // check if player is already at leftmost spot
        if (playerX == 0) {
            System.out.println("Player cannot move backwards.");
            return;
        }
        // change markers on map and change int of player's position
        map[1][playerX] = " - ";
        playerX--;
        map[1][playerX] = " ! ";
    }

    // player enters room either above/below its position
    public void enterRoom() {
        rooms[playerX - 1].entered();
    }
}
