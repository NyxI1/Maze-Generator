package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    private Maze maze;
    private Cell cell;

    @BeforeEach
    void setUp() {
        maze = new Maze(5,7);
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

}