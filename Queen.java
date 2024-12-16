public import enums.Color;

public class Queen extends Piece {
    public Queen(Color color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Board board) {
        int dx = Math.abs(newX - getX());
        int dy = Math.abs(newY - getY());
        // Queen moves like both Rook and Bishop
        return dx == dy || getX() == newX || getY() == newY;
    }
}
 {
    
}
