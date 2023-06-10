package tests;

import classes.Vacuum;
import enums.Orientation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VacuumTest {
    @Test
    public void shouldReturnEastIfTurnRightFromNorth()
    {
        Vacuum vacuum = new Vacuum(0,0, Orientation.N);
        vacuum.turnRight();
        assertEquals(Orientation.E, vacuum.getOrientation());
    }

    @Test
    public void shouldReturnSouthIf2TurnRightFromNorth()
    {
        Vacuum vacuum = new Vacuum(0,0, Orientation.N);
        vacuum.turnRight();
        vacuum.turnRight();
        assertEquals(Orientation.S, vacuum.getOrientation());
    }

    @Test
    public void shouldReturnNorthIf4TurnRightFromNorth()
    {
        Vacuum vacuum = new Vacuum(0,0, Orientation.N);
        vacuum.turnRight();
        vacuum.turnRight();
        vacuum.turnRight();
        vacuum.turnRight();
        assertEquals(Orientation.N, vacuum.getOrientation());
    }

    @Test
    public void shouldReturnWestIfTurnLeftFromNorth() {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.N);
        vacuum.turnLeft();
        assertEquals(Orientation.W, vacuum.getOrientation());
    }

    @Test
    public void shouldReturnSouthIf2TurnsLeftFromNorth() {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.N);
        vacuum.turnLeft();
        vacuum.turnLeft();
        assertEquals(Orientation.S, vacuum.getOrientation());
    }

    @Test
    public void shouldReturnNorthIf4TurnsLeftFromNorth() {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.N);
        vacuum.turnLeft();
        vacuum.turnLeft();
        vacuum.turnLeft();
        vacuum.turnLeft();
        assertEquals(Orientation.N, vacuum.getOrientation());
    }

    @Test
    public void shouldReturn1InYIfMoveFromNorthAndOrigin()
    {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.N);
        vacuum.move();
        assertEquals(1, vacuum.getY());
    }

    @Test
    public void shouldReturn10InYIf10MoveFromNorthAndOrigin()
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
    }

    @Test
    public void shouldReturn0InYIfMoveFromSouthAndY1()
    {
        Vacuum vacuum = new Vacuum(0, 1, Orientation.S);
        vacuum.move();
        assertEquals(0, vacuum.getY());
    }

    @Test
    public void shouldReturn1InXIfMoveFromEastAndOrigin()
    {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.E);
        vacuum.move();
        assertEquals(1, vacuum.getX());
    }

    @Test
    public void shouldReturn0InXIfMoveFromWestAndX1()
    {
        Vacuum vacuum = new Vacuum(1, 0, Orientation.W);
        vacuum.move();
        assertEquals(0, vacuum.getX());
    }
}