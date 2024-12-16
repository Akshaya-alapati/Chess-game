import enums.Color;

public class Pawn extends Piece {
    public Pawn(Color color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Board board) {
        int direction = (getColor() == Color.WHITE) ? 1 : -1;
        return newX == getX() + direction && newY == getY() && board.getPieceAt(newX, newY) == null;
    }
}
