import enums.Color;

public class King extends Piece {
    public King(Color color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Board board) {
        int dx = Math.abs(newX - getX());
        int dy = Math.abs(newY - getY());
        return dx <= 1 && dy <= 1; // King moves one square in any direction
    }
}
