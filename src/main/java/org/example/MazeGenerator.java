package org.example;

import java.util.*;

public class MazeGenerator {

    private Maze maze;
    private boolean[][] visited;
    private Deque<Cell> stack = new ArrayDeque<>();
    Random random = new Random();

    public MazeGenerator(Maze maze) {
        this.maze = maze;
        this.visited = new boolean[maze.getHeight()][maze.getWidth()];
    }

    private void initGenerator() {
        Cell cell = maze.getCell(0,0);
        visited[0][0] = true;
        stack.push(cell);
    }

    private List<Cell> findUnvisitedNeighbors(Cell currentCell) {
        List<Cell> neighboringCells = new ArrayList<>();

        if (currentCell.getRow() - 1 >= 0 && !visited[currentCell.getRow() - 1][currentCell.getColumn()]) {
            neighboringCells.add(maze.getCell(
                    currentCell.getRow() - 1,
                    currentCell.getColumn()));
        }
        if (currentCell.getRow() + 1 < maze.getHeight() && !visited[currentCell.getRow() + 1][currentCell.getColumn()]) {
            neighboringCells.add(maze.getCell(
                    currentCell.getRow() + 1,
                    currentCell.getColumn()
            ));
        }
        if (currentCell.getColumn() - 1 >= 0 && !visited[currentCell.getRow()][currentCell.getColumn() - 1]) {
            neighboringCells.add(maze.getCell(
                    currentCell.getRow(),
                    currentCell.getColumn() - 1
            ));
        }
        if (currentCell.getColumn() + 1 < maze.getWidth() && !visited[currentCell.getRow()][currentCell.getColumn() + 1]) {
            neighboringCells.add(maze.getCell(
                    currentCell.getRow(),
                    currentCell.getColumn() + 1
            ));
        }
        return neighboringCells;
    }

    private void removeWall(Cell currentCell, Cell nextCell) {
        if (nextCell.getRow() == currentCell.getRow() - 1) {
            currentCell.removeTopWall();
            nextCell.removeBottomWall();

        } else if (nextCell.getRow() == currentCell.getRow() + 1) {
            currentCell.removeBottomWall();
            nextCell.removeTopWall();

        } else if (nextCell.getColumn() == currentCell.getColumn() - 1) {
            currentCell.removeLeftWall();
            nextCell.removeRightWall();

        } else if (nextCell.getColumn() == currentCell.getColumn() + 1) {
            currentCell.removeRightWall();
            nextCell.removeLeftWall();
        }
    }

    public void generate () {
        initGenerator();

        while (!stack.isEmpty()) {
            Cell currentCell = stack.peek();
            List<Cell> unvisitedNeighbors = findUnvisitedNeighbors(currentCell);

            if (unvisitedNeighbors.isEmpty()) {
                stack.pop();
            }
            else {
                int randomIndex = random.nextInt(unvisitedNeighbors.size());
                Cell nextCell = unvisitedNeighbors.get(randomIndex);

                removeWall(currentCell, nextCell);
                visited[nextCell.getRow()][nextCell.getColumn()] = true;
                stack.push(nextCell);
            }

        }
    }
}
