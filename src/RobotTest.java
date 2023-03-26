import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RobotTest {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Must include on argument for maze generation.");
            return;
        }
        File input = new File(args[0]);
        Scanner scanner;

        try {
            scanner = new Scanner(input);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find/open file: \"" + args[0] + "\"");
            return;
        }

        Maze maze = new Maze(scanner);

        RandomRobot robot = new RandomRobot(maze);

        System.out.println("X: " + robot.getPosition().getX() + "\tY: " + robot.getPosition().getY());
        while (!robot.hasReachedGoal()) {
            robot.move();
            System.out.println("X: " + robot.getPosition().getX() + "\tY: " + robot.getPosition().getY());
        }
    }
}
