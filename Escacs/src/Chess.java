public class Chess {
    
    private String player1 = "";
    private String player2 = "";
    private String turn = ""; 
    private int turnNumber;
    private boolean victory;

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
        board.printBoard();
        System.out.println();
        System.out.println(this.player1 + " starts!\nReminder: you play with Upper Case pieces!");
        System.out.println();

        while (!this.victory) {

            if (this.turnNumber%2 == 0 && this.turnNumber != 1) {
                System.out.println();
                System.out.println("===============================================");
                System.out.println();
                System.out.println("\nIs " + this.player2 + "'s turn!\nReminder: you play with Lower Case pieces!");
                this.turn = "black";
            } else if (this.turnNumber%2 != 0 && this.turnNumber != 1) {
                System.out.println();
                System.out.println("===============================================");
                System.out.println();
                System.out.println("\nIs " + this.player1 + "'s turn!\nReminder: you play with Upper Case pieces!");
                this.turn = "white";
            }

            board.askPlay(this.turn);
            System.out.println();
            board.printBoard();

            this.turnNumber++;

            checkVictory(board);
        }
    }

    /**
     * Looks for both kings in the field
     * Displays wining message if someone wins
     * @param board
     */
    private void checkVictory(Board board) {

        String[][] winnerBoard = board.getBoard();
        boolean whiteKing = false;
        boolean blackKing = false;

        for (int r = 0; r < winnerBoard.length; r++) {
            for (int c = 0; c < winnerBoard[r].length; c++) {
                
                if (winnerBoard[r][c].equals("K")) {
                    whiteKing = true;
                }

                if (winnerBoard[r][c].equals("k")) {
                    blackKing = true;
                }
            }
        }

        if (!whiteKing || !blackKing) {
            this.victory = true;

            if (!blackKing) {
                System.out.println();
                System.out.println("===============================================");
                System.out.println();
                System.out.println(this.player1 + " with white pieces wins the match!!!");
            } else if (!whiteKing) {
                System.out.println();
                System.out.println("===============================================");
                System.out.println();
                System.out.println(this.player2 + " with black pieces wins the match!!!");
            }
        }
    }
}
