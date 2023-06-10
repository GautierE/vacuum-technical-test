package tests;

import classes.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {
    private Grid grid;
    @BeforeEach
    public void setup()
    {
        grid = new Grid(5,5);
    }
    @Test
    public void shouldReturnTrueIfPositionAreOrigin() {
        assertTrue(grid.isPositionValid(0, 0));
    }

    @Test
    public void shouldReturnTrueIfPositionAreWithinGrid() {
        assertTrue(grid.isPositionValid(3, 4));
        assertTrue(grid.isPositionValid(4, 4));
    }

    @Test
    public void shouldReturnFalseIfPositionAreNegative() {
        assertFalse(grid.isPositionValid(-1, 2));
        assertFalse(grid.isPositionValid(0, -2));
    }

    @Test
    public void shouldReturnFalseIfPositionAreOutOfGrid() {
        assertFalse(grid.isPositionValid(5, 0));
        assertFalse(grid.isPositionValid(0, 5));
        assertFalse(grid.isPositionValid(10, 10));
    }

    // Additional test methods...

}