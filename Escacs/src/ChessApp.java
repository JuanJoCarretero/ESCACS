import java.util.Scanner;

public class ChessApp {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        String player1;
        String player2;

        // Ask player1 name
        System.out.println("\nPlayer 1's name (Will be playing with white pieces which are Upper Case): ");
        player1 = keyboard.next();

        // Ask player2 name
        System.out.println("\nPlayer 2's name (Will be playing with black pieces which are Lower Case): ");
        player2 = keyboard.next();

        // Start game
        Chess game = new Chess(player1, player2);
        game.initGame();
        
        keyboard.close();
    }
}
