package classes;

import enums.Orientation;

public class Vacuum {
    private int x;
    private int y;
    private Orientation orientation;

    public Vacuum(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
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

        if (isPositionValid(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    private boolean isPositionValid(int x, int y) {
        return x >= 0 && y >= 0;
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
