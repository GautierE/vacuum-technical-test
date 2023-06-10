import classes.Grid;
import classes.Vacuum;
import enums.Orientation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Grid creation (x, y)\n");
        System.out.println("Enter x dimension :");
        int x = readIntInput(scanner);
        System.out.println("Enter y dimension :");
        int y = readIntInput(scanner);

        Grid grid = new Grid(x, y);

        System.out.print("Initialize vacuum position and orientation (x, y, orientation)\n");
        System.out.println("Enter x position :");
        int initialX = readIntInput(scanner);
        System.out.println("Enter y position :");
        int initialY = readIntInput(scanner);
        System.out.println("Enter orientation, possible values are N (North), E (East), W (West), S (South) : ");
        Orientation initialOrientation = readOrientationInput(scanner);

        Vacuum vacuum = new Vacuum(initialX, initialY, initialOrientation, grid);

        System.out.print("Enter the series of instructions (D for rotate right, G for rotate left, A to move) : ");

        scanner.nextLine(); // Consumes the excess new line before reading the instructions
        String instructions = scanner.nextLine();

       for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'D' -> vacuum.turnRight();
                case 'G' -> vacuum.turnLeft();
                case 'A' -> vacuum.move();
                default -> System.out.println("Invalid instruction : " + instruction);
            }
        }

        System.out.println("Vacuum final position is : x=" + vacuum.getX() + " y=" + vacuum.getY() +
                " orientation=" + vacuum.getOrientation());
    }

    private static int readIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry, enter an integer.");
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