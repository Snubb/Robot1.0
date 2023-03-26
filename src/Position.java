public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getPosToSouth() {
        return new Position(x, y + 1);
    }

    public Position getPosToNorth() {
        return new Position(x, y - 1);
    }

    public Position getPosToWest() {
        return new Position(x - 1, y);
    }

    public Position getPosToEast() {
        return new Position(x + 1, y);
    }

    public boolean equals(Object obj) {
        if (obj.getClass() != Position.class) {
            return false;
        }

        return ((Position) obj).x == this.x && ((Position) obj).y == this.y;
    }

    public int hashCode() {
        return x + y * 50; // TODO: hermhmehhmeh
    }
}
