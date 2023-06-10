package tests;

import classes.Vacuum;
import enums.Orientation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VacuumTest {
    @Test
    public void shouldReturnEastIfTurnRightFromNorth()
    {
        Vacuum vacuum = new Vacuum( Orientation.N);
        vacuum.turnRight();
        assertEquals(Orientation.E, vacuum.getOrientation());
    }

    @Test
    public void shouldReturnSouthIf2TurnRightFromNorth()
    {
        Vacuum vacuum = new Vacuum( Orientation.N);
        vacuum.turnRight();
        vacuum.turnRight();
        assertEquals(Orientation.S, vacuum.getOrientation());
    }

    @Test
    public void shouldReturnNorthIf4TurnRightFromNorth()
    {
        Vacuum vacuum = new Vacuum( Orientation.N);
        vacuum.turnRight();
        vacuum.turnRight();
        vacuum.turnRight();
        vacuum.turnRight();
        assertEquals(Orientation.N, vacuum.getOrientation());
    }

    @Test
    public void shouldReturnWestIfTurnLeftFromNorth() {
        Vacuum vacuum = new Vacuum(Orientation.N);
        vacuum.turnLeft();
        assertEquals(Orientation.W, vacuum.getOrientation());
    }

    @Test
    public void shouldReturnSouthIf2TurnsLeftFromNorth() {
        Vacuum vacuum = new Vacuum(Orientation.N);
        vacuum.turnLeft();
        vacuum.turnLeft();
        assertEquals(Orientation.S, vacuum.getOrientation());
    }

    @Test
    public void shouldReturnNorthIf4TurnsLeftFromNorth() {
        Vacuum vacuum = new Vacuum(Orientation.N);
        vacuum.turnLeft();
        vacuum.turnLeft();
        vacuum.turnLeft();
        vacuum.turnLeft();
        assertEquals(Orientation.N, vacuum.getOrientation());
    }
}