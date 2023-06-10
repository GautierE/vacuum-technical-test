package classes;

public class Grid {
    private final int dimensionX;
    private final int dimensionY;

    public Grid(int dimensionX, int dimensionY) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
    }

    public boolean isPositionValid(int x, int y) {
        return x >= 0 && x < dimensionX && y >= 0 && y < dimensionY;
    }
}