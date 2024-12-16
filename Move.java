public class Move {
    private Piece piece;
    private int newX, newY;

    public Move(Piece piece, int newX, int newY) {
        this.piece = piece;
        this.newX = newX;
        this.newY = newY;
    }

    public void execute(Board board) throws InvalidMoveException {
        if (!piece.isValidMove(newX, newY, board)) {
            throw new InvalidMoveException("Invalid move!");
        }
        board.setPieceAt(newX, newY, piece);
        piece.move(newX, newY);
    }
}
