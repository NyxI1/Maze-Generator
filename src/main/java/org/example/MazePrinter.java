package org.example;

public class MazePrinter {
    private Maze maze;

    public MazePrinter(Maze maze) {
        this.maze = maze;
    }

    public void print() {
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getCell(i, j).isWallTop()) {
                    System.out.print("+---");
                }
                else {
                    System.out.print("+   ");
                }
            }
            System.out.print("+");
            System.out.println();

            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getCell(i, j).isWallLeft()) {
                    System.out.print("|   ");

                }
                else {
                    System.out.print("   ");
                }
            }
            if (maze.getCell(i,maze.getWidth() - 1).isWallRight()) {
                System.out.print("|");
            }
            System.out.println();
        }
        for (int j = 0; j < maze.getWidth(); j++) {
            if (maze.getCell(maze.getHeight() - 1, j).isWallBottom()) {
                System.out.print("+---");
            }
            else {
                System.out.print("+   ");
            }
        }
        System.out.print("+");
        System.out.println();
    }

}
