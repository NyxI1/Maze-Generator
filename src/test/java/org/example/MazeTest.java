package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    private Maze maze;
    private Cell cell;
    private MazeGenerator mazeGenerator;

    @BeforeEach
    void setUp() {
        maze = new Maze(5,7);
        mazeGenerator = new MazeGenerator(maze);
    }

    @Test
    void cellCoordinateMapping() {
        assertNotNull(maze.getCell(2,3));
        assertEquals(2, maze.getCell(2,3).getRow());
        assertEquals(3, maze.getCell(2,3).getColumn());
    }

    @Test
    void invalidMazeSizeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Maze(30, 10);
        });
    }

    @Test
    void isWallBetween() {
        mazeGenerator.generate();
        assertTrue(!maze.getCell(0,0).isWallRight()
                    || !maze.getCell(0, 0).isWallBottom());
    }

    @Test
    void neighboringWallsAreConsistent() {
        mazeGenerator.generate();
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                Cell currentCell = maze.getCell(i, j);

                if (currentCell.getRow() + 1 < maze.getHeight()) {
                    assertEquals(currentCell.isWallBottom(),
                                maze.getCell(currentCell.getRow() + 1, currentCell.getColumn()).isWallTop());
                }
                if (currentCell.getColumn() + 1 < maze.getWidth()) {
                    assertEquals(currentCell.isWallRight(),
                            maze.getCell(currentCell.getRow(), currentCell.getColumn() + 1).isWallLeft());
                }

            }
        }
    }



}