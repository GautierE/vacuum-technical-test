import classes.Grid;
import classes.Vacuum;
import enums.Orientation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Grid creation (x, y)\n");
        System.out.println("Enter x dimension :");
        int x = readDimensionInput(scanner);
        System.out.println("Enter y dimension :");
        int y = readDimensionInput(scanner);

        Grid grid = new Grid(x, y);

        System.out.print("Initialize vacuum position and orientation (x, y, orientation)\n");
        System.out.println("Enter x position (within the grid dimensions):");
        int initialX = readPositionInput(scanner, grid.getDimensionX());
        System.out.println("Enter y position (within the grid dimensions):");
        int initialY = readPositionInput(scanner, grid.getDimensionY());
        System.out.println("Enter orientation, possible values are N (North), E (East), W (West), S (South) : ");
        Orientation initialOrientation = readOrientationInput(scanner);

        Vacuum vacuum = new Vacuum(initialX, initialY, initialOrientation, grid);

        System.out.print("Enter the series of instructions (D for rotate right, G for rotate left, A to move) : ");

        scanner.nextLine(); // Consumes the excess new line before reading the instructions
        String instructions = scanner.nextLine();

        for (int i = 0; i < instructions.length(); i++) {
            char instruction = instructions.charAt(i);
            switch (instruction) {
                case 'D' -> vacuum.turnRight();
                case 'G' -> vacuum.turnLeft();
                case 'A' -> {
                    if (!vacuum.move()) { // if the vacuum is not able to move
                        System.out.println("Instruction number " + (i+1) + " ("+ instruction +") ignored: the vacuum is at the edge of the grid.");
                    }
                }
                default -> System.out.println("Instruction number " + (i+1) + " is invalid : " + instruction);
            }
        }

        System.out.println("Vacuum final position is : x=" + vacuum.getX() + " y=" + vacuum.getY() +
                " orientation=" + vacuum.getOrientation());
    }

    private static int readDimensionInput(Scanner scanner) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.next());
                if (input <= 0) {
                    System.out.println("Invalid entry, enter a positive integer greater than 0.");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry, enter a positive integer greater than 0.");
            }
        }
    }

    private static int readPositionInput(Scanner scanner, int maxPosition) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.next());
                if (input < 0 || input >= maxPosition) {
                    System.out.println("Invalid entry, enter a position within the grid dimensions.");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry, enter a valid position within the grid dimensions.");
            }
        }
    }

    private static Orientation readOrientationInput(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.next();
                return Orientation.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid orientation, possible values are : N (North), E (East), W (West), S (South).");
            }
        }
    }
}