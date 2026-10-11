package org.example;

public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze(25,25);
        MazeGenerator mazeGenerator = new MazeGenerator(maze);
        mazeGenerator.generate();
        MazePrinter mazePrinter = new MazePrinter(maze);
        mazePrinter.print();
    }
}