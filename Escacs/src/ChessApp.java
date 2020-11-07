import java.util.Scanner;

public class ChessApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String nom1;
        String nom2;

        System.out.println("Entra el nom del Jugador 1: ");
        nom1 = keyboard.next();

        System.out.println("Entra el nom del Jugador 2: ");
        nom2 = keyboard.next();

        Chess game = new Chess(nom1, nom2);
        game.initGame();

        Board taulell = new Board();
        taulell.printBoard();
        
        keyboard.close();
    }
}
