package org.example;

public class Cell {

    private int row;
    private int column;
    private boolean wallTop;
    private boolean wallBottom;
    private boolean wallLeft;
    private boolean wallRight;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.wallTop = true;
        this.wallBottom = true;
        this.wallLeft = true;
        this.wallRight = true;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
