package org.example;

public class Maze {

    private int width;
    private int height;
    private Cell[][] cells;

    public Maze(int width, int height) {
        validateSize(width, height);
        this.width = width;
        this.height = height;
        this.cells = new Cell[height][width];
        initializeCells();
    }

    private void initializeCells() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    private void validateSize(int width, int height) {
        if ((width < 2 || width > 25) || (height < 2 || height > 25)) {
            throw new IllegalArgumentException("Введение некорректных значений создания лабиринта");
        }
    }

    public Cell getCell(int row, int column) {
        return cells[row][column];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
