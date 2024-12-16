import enums.Color;

public class Knight extends Piece {
    public Knight(Color color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Board board) {
        int dx = Math.abs(newX - getX());
        int dy = Math.abs(newY - getY());
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}
