import enums.Color;

public class GameController {
    private Board board;
    private Player player1, player2;
    private Player currentPlayer;
    private boolean gameOver;

    public GameController(String player1Name, String player2Name) {
        board = new Board();
        player1 = new Player(player1Name, Color.WHITE);
        player2 = new Player(player2Name, Color.BLACK);
        currentPlayer = player1;
        gameOver = false;
        board.initializeBoard();
    }

    public void startGame() {
        System.out.println("Chess game started!");
        System.out.println(player1.getName() + " will play as WHITE.");
        System.out.println(player2.getName() + " will play as BLACK.");
        while (!gameOver) {
            System.out.println("\nCurrent Turn: " + currentPlayer.getName() + " (" + currentPlayer.getColor() + ")");
            printBoard();

            // Simulate a move or accept user input for the move
            simulateMove();

            // Check for game over condition (simplified checkmate)
            if (isCheckmate()) {
                System.out.println("\nCheckmate! " + currentPlayer.getName() + " (" + currentPlayer.getColor() + ") wins!");
                gameOver = true;
            } else {
                togglePlayer();
            }
        }
        System.out.println("Game Over!");
    }

    private void simulateMove() {
        // Example logic: Moves the first available piece if possible
        boolean moveMade = false;
        for (int x = 0; x < 8 && !moveMade; x++) {
            for (int y = 0; y < 8 && !moveMade; y++) {
                Piece piece = board.getPieceAt(x, y);
                if (piece != null && piece.getColor() == currentPlayer.getColor()) {
                    int newX = x + (currentPlayer.getColor() == Color.WHITE ? 1 : -1);
                    int newY = y;
                    try {
                        processMove(x, y, newX, newY);
                        moveMade = true;
                    } catch (InvalidMoveException ignored) {
                    }
                }
            }
        }

        if (!moveMade) {
            System.out.println(currentPlayer.getName() + " has no valid moves! Stalemate or loss.");
            gameOver = true;
        }
    }

    public void processMove(int fromX, int fromY, int toX, int toY) throws InvalidMoveException {
        Piece piece = board.getPieceAt(fromX, fromY);
        if (piece == null || piece.getColor() != currentPlayer.getColor()) {
            throw new InvalidMoveException("Invalid move: Not your piece.");
        }

        Move move = new Move(piece, toX, toY);
        move.execute(board);
        System.out.println(currentPlayer.getName() + " moved " + piece.getClass().getSimpleName() + " to (" + toX + ", " + toY + ")");
    }

    private void togglePlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean isCheckmate() {
        // Simplified logic: Game ends when the opponent's King is no longer on the board
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Piece piece = board.getPieceAt(x, y);
                if (piece instanceof King && piece.getColor() != currentPlayer.getColor()) {
                    return false; // Opponent's King is still on the board
                }
            }
        }
        return true; // Opponent's King is captured
    }

    private void printBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board.getPieceAt(i, j);
                if (piece == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(piece.getClass().getSimpleName().charAt(0) + " ");
                }
            }
            System.out.println();
        }
    }
}
