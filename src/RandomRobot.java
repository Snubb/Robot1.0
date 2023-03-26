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

    public void move() {
        Position[] positions = {
                position.getPosToNorth(),
                position.getPosToSouth(),
                position.getPosToEast(),
                position.getPosToWest()
        };

        ArrayList<Position> possibleMoves = new ArrayList<>();

        for (Position pos :
                positions) {
            if (maze.isMovable(pos) && !pos.equals(previousPosition)) possibleMoves.add(pos);
        }

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
