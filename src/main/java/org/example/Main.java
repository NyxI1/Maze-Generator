package org.example;

public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze(5,5);
        MazeGenerator mazeGenerator = new MazeGenerator(maze);
        mazeGenerator.generate();
    }
}