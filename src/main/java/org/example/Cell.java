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

    public void removeTopWall() {
        wallTop = false;
    }
    public void removeBottomWall() {
        wallBottom = false;
    }
    public void removeLeftWall() {
        wallLeft = false;
    }
    public void removeRightWall() {
        wallRight = false;
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isWallTop() {
        return wallTop;
    }

    public boolean isWallBottom() {
        return wallBottom;
    }

    public boolean isWallLeft() {
        return wallLeft;
    }

    public boolean isWallRight() {
        return wallRight;
    }
}
