public class Board {
    private Piece[][] board;

    public Board() {
        // Initialize an 8x8 board
        board = new Piece[8][8];
    }

    // Initializes the chessboard with all pieces in their starting positions
    public void initializeBoard() {
        // Place Pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(enums.Color.WHITE);
            board[6][i] = new Pawn(enums.Color.BLACK);
        }

        // Place Rooks
        board[0][0] = new Rook(enums.Color.WHITE);
        board[0][7] = new Rook(enums.Color.WHITE);
        board[7][0] = new Rook(enums.Color.BLACK);
        board[7][7] = new Rook(enums.Color.BLACK);

        // Place Knights
        board[0][1] = new Knight(enums.Color.WHITE);
        board[0][6] = new Knight(enums.Color.WHITE);
        board[7][1] = new Knight(enums.Color.BLACK);
        board[7][6] = new Knight(enums.Color.BLACK);

        // Place Bishops
        board[0][2] = new Bishop(enums.Color.WHITE);
        board[0][5] = new Bishop(enums.Color.WHITE);
        board[7][2] = new Bishop(enums.Color.BLACK);
        board[7][5] = new Bishop(enums.Color.BLACK);

        // Place Queens
        board[0][3] = new Queen(enums.Color.WHITE);
        board[7][3] = new Queen(enums.Color.BLACK);

        // Place Kings
        board[0][4] = new King(enums.Color.WHITE);
        board[7][4] = new King(enums.Color.BLACK);
    }

    // Returns the piece at a specific position
    public Piece getPieceAt(int x, int y) {
        if (isValidPosition(x, y)) {
            return board[x][y];
        }
        return null;
    }

    // Sets a piece at a specific position
    public void setPieceAt(int x, int y, Piece piece) {
        if (isValidPosition(x, y)) {
            board[x][y] = piece;
        }
    }

    // Validates if the position is within board bounds
    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    // Clears a position on the board
    public void clearPosition(int x, int y) {
        if (isValidPosition(x, y)) {
            board[x][y] = null;
        }
    }
}
