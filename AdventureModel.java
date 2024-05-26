package main.java;

public class AdventureModel {
    private String[][] map = new String[3][10];
    private int playerX = 0;
    private int playerY = 1;

    public AdventureModel() {
        // populate map with doors and player initial pos
        map[0] = new String[] { "X", "| |", "X", "| |", "X", "| |", "X", "| |", "X", "X" };
        map[1] = new String[] { "!", "-", "-", "-", "-", "-", "-", "-", "-", "[]" };
        map[2] = new String[] { "X", "X", "| |", "X", "| |", "X", "| |", "X", "| |", "X" };
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

    public void move(int x, int y) {

    }
}
