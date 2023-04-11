import java.util.HashMap;

public class Maze {
    private int columns;
    private int rows;
    private final HashMap<Integer, Character> positions = new HashMap<>();
    private Position start;

    public Maze(java.util.Scanner Scanner) {
        int col = 0;
        boolean hasGoal = false;

        Scanner.useDelimiter(""); // Will make scanner read one character at a time
        while (Scanner.hasNext()) {
            char buffer = Scanner.next().charAt(0);
            if (buffer != '\n') {
                Position newPos = new Position(col, rows);
                positions.put(newPos.hashCode(), buffer);
                col++;

                if (buffer == 'S') {
                    if (start != null) { // Only true if a start position has already been set
                        System.err.println("You can only have one start in a maze.");
                        System.exit(0);
                    }
                    start = newPos;
                }

                if (buffer == 'G') {
                    hasGoal = true;
                }
            } else {
                if (col > columns) columns = col;
                col = 0;
                rows++;
            }
        }

        if (start == null || !hasGoal) {
            System.err.println("Incomplete maze.");
            System.exit(0);
        }
    }

    public boolean isMovable(Position pos) {
        // Checks that the given position exists and that it isn't a wall
        return positions.containsKey(pos.hashCode()) && positions.get(pos.hashCode()) != '*';
    }

    public boolean isGoal(Position pos) {
        return positions.get(pos.hashCode()) == 'G';
    }

    public Position getStart() {
        return start;
    }

    public int getNumOfColumns() {
        return columns;
    }

    public int getNumOfRows() {
        return rows;
    }
}
