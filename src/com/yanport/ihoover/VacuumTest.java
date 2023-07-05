package com.yanport.ihoover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VacuumTest {
    private Grid grid;
    @BeforeEach
    public void setup()
    {
    grid = new Grid(20,20);
    }

    @Test
    public void shouldRotateToEastIfTurnRightFromNorth()
    {
        Grid grid = new Grid(20,20);
        Vacuum vacuum = new Vacuum(0,0, Orientation.N,grid);
        vacuum.turnRight();
        assertEquals(Orientation.E, vacuum.getOrientation());
    }

    @Test
    public void shouldRotateToSouthIf2TurnRightFromNorth()
    {
        Vacuum vacuum = new Vacuum(0,0, Orientation.N,grid);
        vacuum.turnRight();
        vacuum.turnRight();
        assertEquals(Orientation.S, vacuum.getOrientation());
    }

    @Test
    public void shouldRotateToNorthIf4TurnRightFromNorth()
    {
        Vacuum vacuum = new Vacuum(0,0, Orientation.N,grid);
        vacuum.turnRight();
        vacuum.turnRight();
        vacuum.turnRight();
        vacuum.turnRight();
        assertEquals(Orientation.N, vacuum.getOrientation());
    }

    @Test
    public void shouldRotateToWestIfTurnLeftFromNorth() {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.N,grid);
        vacuum.turnLeft();
        assertEquals(Orientation.W, vacuum.getOrientation());
    }

    @Test
    public void shouldRotateToSouthIf2TurnsLeftFromNorth() {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.N,grid);
        vacuum.turnLeft();
        vacuum.turnLeft();
        assertEquals(Orientation.S, vacuum.getOrientation());
    }

    @Test
    public void shouldRotateToNorthIf4TurnsLeftFromNorth() {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.N,grid);
        vacuum.turnLeft();
        vacuum.turnLeft();
        vacuum.turnLeft();
        vacuum.turnLeft();
        assertEquals(Orientation.N, vacuum.getOrientation());
    }

    @Test
    public void shouldMoveTo1InYIfMoveFromNorthAndOrigin()
    {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.N,grid);
        vacuum.move();
        assertEquals(1, vacuum.getY());
        assertEquals(0, vacuum.getX());
    }

    @Test
    public void shouldMoveTo10InYIf10MoveFromNorthAndOrigin()
    {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.N,grid);
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
    public void shouldMoveTo19InYIfMoveFromNorthAnd18Y() {
        Vacuum vacuum = new Vacuum(0, 18, Orientation.N, grid);
        vacuum.move();
        assertEquals(0, vacuum.getX());
        assertEquals(19, vacuum.getY());
    }

    @Test
    public void shouldNotMoveOutOfGridInYIfMoveFromNorthAndGridEdge() {
        Vacuum vacuum = new Vacuum(0, 19, Orientation.N, grid);
        assertThrows(InvalidPositionException.class, vacuum::move);
        assertEquals(0, vacuum.getX());
        assertEquals(19, vacuum.getY());
    }

    @Test
    public void shouldMoveTo0InYIfMoveFromSouthAndY1()
    {
        Vacuum vacuum = new Vacuum(0, 1, Orientation.S,grid);
        vacuum.move();
        assertEquals(0, vacuum.getY());
        assertEquals(0, vacuum.getX());
    }

    @Test
    public void shouldNotMoveToNegativeYIfMoveFromSouthAndOrigin() {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.S,grid);
        assertThrows(InvalidPositionException.class, vacuum::move);
        assertEquals(0, vacuum.getX());
        assertEquals(0, vacuum.getY());
    }

    @Test
    public void shouldMoveTo1InXIfMoveFromEastAndOrigin()
    {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.E,grid);
        vacuum.move();
        assertEquals(1, vacuum.getX());
        assertEquals(0, vacuum.getY());
    }

    @Test
    public void shouldMoveTo19InXIfMoveFromEastAnd18X() {
        Vacuum vacuum = new Vacuum(18, 0, Orientation.E, grid);
        vacuum.move();
        assertEquals(19, vacuum.getX());
        assertEquals(0, vacuum.getY());
    }

    @Test
    public void shouldNotMoveOutOfGridInXIfMoveFromEastAndGridEdge() {
        Vacuum vacuum = new Vacuum(19, 0, Orientation.E, grid);
        assertThrows(InvalidPositionException.class, vacuum::move);
        assertEquals(19, vacuum.getX());
        assertEquals(0, vacuum.getY());
    }


    @Test
    public void shouldMoveTo0InXIfMoveFromWestAndX1()
    {
        Vacuum vacuum = new Vacuum(1, 0, Orientation.W,grid);
        vacuum.move();
        assertEquals(0, vacuum.getX());
        assertEquals(0, vacuum.getY());
    }

    @Test
    public void shouldNotMoveToNegativeXIfMoveFromWestAndOrigin() {
        Vacuum vacuum = new Vacuum(0, 0, Orientation.W,grid);
        assertThrows(InvalidPositionException.class, vacuum::move);
        assertEquals(0, vacuum.getX());
        assertEquals(0, vacuum.getY());
    }
}