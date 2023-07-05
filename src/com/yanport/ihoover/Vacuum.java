package com.yanport.ihoover;

public class Vacuum {
    private int x;
    private int y;
    private Orientation orientation;
    private final Grid grid;

    public Vacuum(int x, int y, Orientation orientation, Grid grid) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.grid = grid;
    }

    public void turnRight() {
        switch (orientation) {
            case N -> orientation = Orientation.E;
            case E -> orientation = Orientation.S;
            case S -> orientation = Orientation.W;
            case W -> orientation = Orientation.N;
        }
    }

    public void turnLeft() {
        switch (orientation) {
            case N -> orientation = Orientation.W;
            case E -> orientation = Orientation.N;
            case S -> orientation = Orientation.E;
            case W -> orientation = Orientation.S;
        }
    }

    public void move() {
        int newX = x;
        int newY = y;

        switch (orientation) {
            case N -> newY++;
            case E -> newX++;
            case S -> newY--;
            case W -> newX--;
        }

        if (grid.isPositionValid(newX, newY)) {
            x = newX;
            y = newY;
        }
        else {
            throw new InvalidPositionException();
        }
    }

    public void executeInstruction(Command instruction) {
        switch (instruction) {
            case RIGHT -> this.turnRight();
            case LEFT -> this.turnLeft();
            case FORWARD -> this.move();
            default -> throw new IllegalArgumentException("Wrong instruction");
        }
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
