import enums.Color;

public class Bishop extends Piece {
    public Bishop(Color color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Board board) {
        int dx = Math.abs(newX - getX());
        int dy = Math.abs(newY - getY());
        return dx == dy; // Bishop moves diagonally
    }
}
