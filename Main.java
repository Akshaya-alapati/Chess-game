import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get player names from the user
        System.out.print("Enter Player 1's name (White pieces): ");
        String player1Name = scanner.nextLine();

        System.out.print("Enter Player 2's name (Black pieces): ");
        String player2Name = scanner.nextLine();

        // Create the GameController with the input names
        GameController gameController = new GameController(player1Name, player2Name);

        // Start the game
        gameController.startGame();

        scanner.close();
    }
}
