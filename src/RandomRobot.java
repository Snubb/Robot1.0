import java.util.ArrayList;

public class RandomRobot {
    private Position position;
    private Position previousPosition;
    private final Maze maze;

    public RandomRobot(Maze maze) {
        this.maze = maze;
        this.position = this.maze.getStart();
        this.previousPosition = this.position;
    }

    // Moves the robot in a random valid direction that is not its previous position
    // Will move to its previous position if it can't move anywhere else
    public void move() {
        Position[] positions = {
                position.getPosToNorth(),
                position.getPosToSouth(),
                position.getPosToEast(),
                position.getPosToWest()
        }; // All potential movement options

        ArrayList<Position> possibleMoves = new ArrayList<>();

        // Add a movement option to the possibleMoves list if it is a valid option
        for (Position pos :
                positions) {
            if (maze.isMovable(pos) && !pos.equals(previousPosition)) possibleMoves.add(pos);
        }

        // Randomize a move. If there are no possible moves, move back
        if (possibleMoves.size() > 0) {
            int randomIndex = (int)(Math.random() * (possibleMoves.size()));
            setPosition(possibleMoves.get(randomIndex));
        } else {
            setPosition(previousPosition);
        }
    }

    public Position getPosition() {
        return position;
    }

    private void setPosition(Position position) {
        this.previousPosition = this.position;
        this.position = position;
    }

    public boolean hasReachedGoal() {
        return maze.isGoal(position);
    }
}
