import java.util.HashMap;

public class Maze {
    private int columns;
    private int rows;
    private final HashMap<Integer, Character> positions = new HashMap<>();
    private Position start;

    public Maze(java.util.Scanner Scanner) {
        int col = 0;

        Scanner.useDelimiter(""); // Will make scanner read one character at a time
        while (Scanner.hasNext()) {
            char buffer = Scanner.next().charAt(0);
            if (buffer != '\n') {
                Position newPos = new Position(col, rows);
                positions.put(newPos.hashCode(), buffer);
                col++;
                if (buffer == 'S') start = newPos;
            } else {
                if (col > columns) columns = col;
                col = 0;
                rows++;
            }
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
