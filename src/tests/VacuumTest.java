package tests;

import classes.Vacuum;
import enums.Orientation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VacuumTest {
    @Test
    public void shouldRotateToEastIfTurnRightFromNorth()
    {
        Vacuum vacuum = new Vacuum(0,0, Orientation.N);
        vacuum.turnRight();
        assertEquals(Orientation.E, vacuum.getOrientation());
    }

    @Test
    public void shouldRotateToSouthIf2TurnRightFromNorth()
    {
        Vacuum vacuum = new Vacuum(0,0, Orientation.N);
        vacuum.turnRight();
        vacuum.turnRight();
        assertEquals(Orientation.S, vacuum.getOrientation());
    }

    @Test
    public void shouldRotateToNorthIf4TurnRightFromNorth()
    {
        Vacuum vacuum = new Vacuum(0,0, Orientation.N);
        vacuum.turnRight();
        vacuum.turnRight();
        vacuum.turnRight();
        vacuum.turnRight();
        assertEquals(Orientation.N, vacuum.getOrientation());
    }

    @Test
    public void shouldRotateToWestIfTurnLeftFromNorth() {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.N);
        vacuum.turnLeft();
        assertEquals(Orientation.W, vacuum.getOrientation());
    }

    @Test
    public void shouldRotateToSouthIf2TurnsLeftFromNorth() {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.N);
        vacuum.turnLeft();
        vacuum.turnLeft();
        assertEquals(Orientation.S, vacuum.getOrientation());
    }

    @Test
    public void shouldRotateToNorthIf4TurnsLeftFromNorth() {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.N);
        vacuum.turnLeft();
        vacuum.turnLeft();
        vacuum.turnLeft();
        vacuum.turnLeft();
        assertEquals(Orientation.N, vacuum.getOrientation());
    }

    @Test
    public void shouldMoveTo1InYIfMoveFromNorthAndOrigin()
    {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.N);
        vacuum.move();
        assertEquals(1, vacuum.getY());
        assertEquals(0, vacuum.getX());
    }

    @Test
    public void shouldMoveTo10InYIf10MoveFromNorthAndOrigin()
    {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.N);
        vacuum.move();
        vacuum.move();
        vacuum.move();
        vacuum.move();
        vacuum.move();
        vacuum.move();
        vacuum.move();
        vacuum.move();
        vacuum.move();
        vacuum.move();
        assertEquals(10, vacuum.getY());
        assertEquals(0, vacuum.getX());
    }

    @Test
    public void shouldMoveTo0InYIfMoveFromSouthAndY1()
    {
        Vacuum vacuum = new Vacuum(0, 1, Orientation.S);
        vacuum.move();
        assertEquals(0, vacuum.getY());
        assertEquals(0, vacuum.getX());
    }

    @Test
    public void shouldNotMoveToNegativeYIfMoveFromSouthAndOrigin() {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.S);
        vacuum.move();
        assertEquals(0, vacuum.getX());
        assertEquals(0, vacuum.getY());
    }

    @Test
    public void shouldMoveTo1InXIfMoveFromEastAndOrigin()
    {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.E);
        vacuum.move();
        assertEquals(1, vacuum.getX());
        assertEquals(0, vacuum.getY());
    }

    @Test
    public void shouldMoveTo0InXIfMoveFromWestAndX1()
    {
        Vacuum vacuum = new Vacuum(1, 0, Orientation.W);
        vacuum.move();
        assertEquals(0, vacuum.getX());
        assertEquals(0, vacuum.getY());
    }

    @Test
    public void shouldNotMoveToNegativeXIfMoveFromWestAndOrigin() {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.W);
        vacuum.move();
        assertEquals(0, vacuum.getX());
        assertEquals(0, vacuum.getY());
    }
}