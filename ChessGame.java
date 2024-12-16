public class ChessGame {
    private GameController gameController;

    public ChessGame(String player1Name, String player2Name) {
        // Initialize the GameController with player names
        this.gameController = new GameController(player1Name, player2Name);
    }

    public void start() {
        // Start the chess game
        gameController.startGame();
    }
}

