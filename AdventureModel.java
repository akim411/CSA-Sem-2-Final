// package main.java;

public class AdventureModel {
    private String[][] map = new String[3][10];
    private int playerX = 0;
    private Room[] rooms = new Room[8];
    private Adventurer player = new Adventurer();

    public AdventureModel() {
        // populate map with doors and player initial pos
        map[0] = new String[] { " X ", "| |", " X ", "| |", " X ", "| |", " X ", "| |", " X ", " X " };
        map[1] = new String[] { " ! ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", "[ ]" };
        map[2] = new String[] { " X ", " X ", "| |", " X ", "| |", " X ", "| |", " X ", "| |", " X " };
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

    public void moveForward() {
        if (playerX == 8) {
            System.out.println("Player cannot move forwards.");
            return;
        }
        map[1][playerX] = " - ";
        playerX++;
        map[1][playerX] = " ! ";
    }

    public void moveBackwards() {
        if (playerX == 0) {
            System.out.println("Player cannot move backwards.");
            return;
        }
        map[1][playerX] = " - ";
        playerX--;
        map[1][playerX] = " ! ";
    }

    public void enterRoom() {
        rooms[playerX - 1].entered();
    }
}
