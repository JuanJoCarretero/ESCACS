import java.util.Scanner;

public class Chess {
    
    private String player1 = "";
    private String player2 = "";
    private String turn = ""; 
    private int turnNumber;
    private boolean victory;

    private Scanner keyboard = new Scanner(System.in);
    private String pieceToMove;
    private String destination;

    /**
     * Constructor
     * @param player1
     * @param player2
     */
    public Chess (String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.turn = "white";
        this.turnNumber = 1;
        this.victory = false;
    }

    /**
     * Game starts
     * Checks which turn is it
     * Asks player his movement
     * Prints updated board
     * Checks if there is a winner
     */
    public void initGame () {
        
        Board board = new Board();
        
        System.out.println();
        System.out.println("===============================================");
        System.out.println();
        System.out.println("Welcome " + this.player1 + "!!!");
        System.out.println("Welcome " + this.player2 + "!!!");
        System.out.println("\nGood luck everyone :D\nThe game starts");
        System.out.println();
        System.out.println("===============================================");
        System.out.println();

        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("\nIs " + this.player1 + "'s turn!\nReminder: you play with Lower Case pieces!");
        System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * *");

        while (!this.victory) {

            // Even turn number means black pieces turn
            if (this.turnNumber%2 == 0 && this.turnNumber != 1) {

                System.out.println();
                System.out.println();
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * ");
                System.out.println("\nIs " + this.player2 + "'s turn!\nReminder: you play with Lower Case pieces!");
                System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * *");
                this.turn = "black";

            // Odd turn number means white pieces turn
            } else if (this.turnNumber%2 != 0 && this.turnNumber != 1) {

                System.out.println();
                System.out.println();
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *");
                System.out.println("\nIs " + this.player1 + "'s turn!\nReminder: you play with Lower Case pieces!");
                System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * *");
                this.turn = "white";
            }

            askPlay(this.turn, board);
            System.out.println();
            board.printBoard();
            this.turnNumber++;
            displayVictory(board);
        }
    }

    /**
     * Check if positions of piece to move and destination are valid
     * If movement is cancelled it gets restarted
     * @param turn
     */
    private void askPlay(String turn, Board board) {

        String[][] gameBoard = board.getBoard();
        String pieceBeingMoved;

        // Patterns to check
        String movementPattern = "^[1-8]{1}(?i)[A-H]{1}$";
        String upperCasePattern = "[A-Z]";
        String lowerCasePattern = "[a-z]";

        boolean validPiece = false;
        boolean validDestination = false;
        boolean cancel = false;
        boolean validMovement = false;

        // Piece to move position coordinates
        int X1 = 0;
        int Y1 = 0;

        // Destination position coordinates
        int X2 = 0;
        int Y2 = 0;

        do {

            // Repeat while movement is cancelled
            do {

                // Ask for piece to move
                do {

                    System.out.println();
                    board.printBoard();
                    System.out.println();

                    System.out.println("\n" + "If you want to cancel the movement at any time, just type \"C\"");
                    System.out.println("Which piece would you like to move? Position should be written like: 4B");
                    this.pieceToMove = this.keyboard.next();

                    cancel = (this.pieceToMove.equals("C")) ? true : false;

                    if (!cancel && this.pieceToMove.matches(movementPattern)) {

                        X1 = board.getRow(this.pieceToMove.charAt(0)) - 1;
                        Y1 = board.getColumn(this.pieceToMove);

                        // Checks if each player is selecting their own pieces
                        if (turn.equals("white")) {
                            validPiece = (gameBoard[X1][Y1].matches(upperCasePattern)) ? true : false;
                        } else {
                            validPiece = (gameBoard[X1][Y1].matches(lowerCasePattern)) ? true : false;
                        }
                    }

                    if (!(this.pieceToMove.matches(movementPattern)) || !validPiece) {
                        System.out.println();
                        System.out.println("===============================================");
                        System.out.println("\nPosition does not match with any of your pieces. Select carefully!");
                    
                        // Even turn number means black pieces turn
                        if (this.turnNumber%2 == 0) {

                            System.out.println("\n" + this.player2 + " repeat your turn!\nReminder: you play with Lower Case pieces!");

                        // Odd turn number means white pieces turn
                        } else if (this.turnNumber%2 != 0) {

                            System.out.println("\n" + this.player1 + " repeat your turn!\nReminder: you play with Lower Case pieces!");
                        }

                        System.out.println("\n===============================================");
                        System.out.println();
                    }
                } while (!(this.pieceToMove.matches(movementPattern)) || !validPiece);
                
                // Ask for destination
                do {

                    System.out.println("Where would you like to move piece " + this.pieceToMove + " ? Position should be written like: 4B");
                    this.destination = this.keyboard.next();

                    cancel = (this.destination.equals("C")) ? true : false;

                    if (!cancel && this.destination.matches(movementPattern)) {

                        X2 = board.getRow(this.destination.charAt(0)) - 1;
                        Y2 = board.getColumn(this.destination);

                        // Checks if destination does not match with a piece of player's own team
                        if (turn.equals("white")) {
                            validDestination = (gameBoard[X2][Y2].matches(lowerCasePattern) || gameBoard[X2][Y2].equals("·")) ? true : false;
                        } else {
                            validDestination = (gameBoard[X2][Y2].matches(upperCasePattern) || gameBoard[X2][Y2].equals("·")) ? true : false;
                        }
                    }

                    if (!(this.destination.matches(movementPattern)) || !validDestination) {
                        System.out.println();
                        System.out.println("===============================================");
                        System.out.println("\nYou can not reach this destination. Select carefully!");
                        System.out.println();

                        // Even turn number means black pieces turn
                        if (this.turnNumber%2 == 0) {

                            System.out.println("\n" + this.player2 + " repeat your destination!\nReminder: you play with Lower Case pieces!");

                        // Odd turn number means white pieces turn
                        } else if (this.turnNumber%2 != 0) {

                            System.out.println("\n" + this.player1 + " repeat your destination!\nReminder: you play with Lower Case pieces!");
                        }

                        System.out.println("\n===============================================");
                        System.out.println();
                    }
                } while (!(this.destination.matches(movementPattern)) && !cancel || !validDestination && !cancel);

            } while (cancel);

            pieceBeingMoved = gameBoard[X1][Y1];

            validMovement = board.checkMovementOfPieceSelected(pieceBeingMoved, turn, X1, Y1, X2, Y2, gameBoard, lowerCasePattern, upperCasePattern);
            
            if (!validMovement) {
                System.out.println();
                System.out.println("===============================================");
                System.out.println("\nYou can not reach this destination. Select carefully!");
                System.out.println();

                // Even turn number means black pieces turn
                if (this.turnNumber%2 == 0) {

                    System.out.println("\n" + this.player2 + " repeat your turn!\nReminder: you play with Lower Case pieces!");

                // Odd turn number means white pieces turn
                } else if (this.turnNumber%2 != 0) {

                    System.out.println("\n" + this.player1 + " repeat your turn!\nReminder: you play with Lower Case pieces!");
                }

                System.out.println("\n===============================================");
                System.out.println();
            }
            

        } while (!validMovement);

        board.movePiece(X1, Y1, X2, Y2);
    }

    /**
     * 
     * @param board
     */
    private void displayVictory (Board board) {

        boolean[] kingsStatus = board.checkVictory();
        boolean whiteKing = kingsStatus[0];
        boolean blackKing = kingsStatus[1];

        // Both kings are still alive
        if (whiteKing && blackKing) {
            return;
        }

        if (whiteKing || blackKing) {
            this.victory = true;

            if (!blackKing) {

                System.out.println();
                System.out.println("===============================================");
                System.out.println();
                System.out.println(this.player1 + " with white pieces wins the match!!!");
                System.out.println();
            } else if (!whiteKing) {

                System.out.println();
                System.out.println("===============================================");
                System.out.println();
                System.out.println(this.player2 + " with black pieces wins the match!!!");
                System.out.println();
            }
        }
    }
}
