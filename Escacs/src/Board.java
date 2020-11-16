import java.util.Scanner;

public class Board {
    
    private Scanner keyboard = new Scanner(System.in);
    private String pieceToMove;
    private String destination;
    private String[][] board = {
        {"t","c","a","q","k","a","c","t"},
        {"p","p","p","p","p","p","p","p"},
        {"·","·","·","·","·","·","·","·"},
        {"·","·","·","·","·","·","·","·"},
        {"·","·","·","·","·","·","·","·"},
        {"·","·","·","·","·","·","·","·"},
        {"P","P","P","P","P","P","P","P"},
        {"T","C","A","K","Q","A","C","T"}
    };
    
    /**
     * @return board
     */
    public String[][] getBoard() {
        return board;
    }

    public void printBoard () {
        
        System.out.println("  A " + "B " + "C " + "D " + "E " + "F " + "G " + "H ");
        System.out.println(" -----------------");
        
        for (int r = 0; r < this.board.length; r++) {

            if (r < 9) {
                System.out.print((r+1) + "|");
            }

            if (r == 9) {
                System.out.print((r+1) + "|");
            }

            for (int c = 0; c < this.board[r].length; c++) {
                System.out.print(this.board[r][c] + " ");
            }

            System.out.println();
        }
    }
    
    /**
     * Check if positions of piece to move and destination are valid
     * If movement is cancelled it gets restarted
     * @param turn
     */
    public void askPlay(String turn) {

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
                    printBoard();
                    System.out.println();

                    System.out.println("\n" + "If you want to cancel the movement at any time, just type \"C\"");
                    System.out.println("Which piece would you like to move? Position should be written like: 4B");
                    this.pieceToMove = this.keyboard.next();

                    cancel = (this.pieceToMove.equals("C")) ? true : false;

                    if (!cancel) {

                        X1 = getRow(this.pieceToMove.charAt(0)) - 1;
                        Y1 = getColumn(this.pieceToMove);

                        // Checks if each player is selecting their own pieces
                        if (turn.equals("white")) {
                            validPiece = (this.board[X1][Y1].matches(upperCasePattern)) ? true : false;
                        } else {
                            validPiece = (this.board[X1][Y1].matches(lowerCasePattern)) ? true : false;
                        }
                    }

                    if (!(this.pieceToMove.matches(movementPattern)) || !validPiece) {
                        System.out.println();
                        System.out.println("Position does not match with any of your pieces. Select carefully!");
                        System.out.println();
                    }
                } while (!(this.pieceToMove.matches(movementPattern)) || !validPiece);
                
                // Ask for destination
                do {

                    System.out.println("Where would you like to move piece " + this.pieceToMove + " ? Position should be written like: 4B");
                    this.destination = this.keyboard.next();

                    cancel = (this.destination.equals("C")) ? true : false;

                    if (!cancel) {

                        X2 = getRow(this.destination.charAt(0)) - 1;
                        Y2 = getColumn(this.destination);

                        // Checks if destination does not match with a piece of player's own team
                        if (turn.equals("white")) {
                            validDestination = (this.board[X2][Y2].matches(lowerCasePattern) || this.board[X2][Y2].equals("·")) ? true : false;
                        } else {
                            validDestination = (this.board[X2][Y2].matches(upperCasePattern) || this.board[X2][Y2].equals("·")) ? true : false;
                        }
                    }

                    if (!(this.destination.matches(movementPattern)) || !validDestination) {
                        System.out.println();
                        System.out.println("You can not reach this destination. Select carefully!");
                        System.out.println();
                    }
                } while (!(this.destination.matches(movementPattern)) && !cancel || !validDestination && !cancel);

            } while (cancel);

            pieceBeingMoved = this.board[X1][Y1];

            validMovement = checkMovementOfPieceSelected(pieceBeingMoved, turn, X1, Y1, X2, Y2, board, lowerCasePattern, upperCasePattern);
            
        } while (!validMovement);

        movePiece(X1, Y1, X2, Y2);
    }

    /**
     * 
     * @param pieceBeingMoved
     * @param turn
     * @param X1 x coordinate of piece to move
     * @param Y1 y coordinate of piece to move
     * @param X2 x coordinate of destination
     * @param Y2 y coordinate of destination
     * @param board
     * @param lowerCasePattern
     * @param upperCasePattern
     * @return
     */
    private boolean checkMovementOfPieceSelected (String pieceBeingMoved, String turn, int X1, int Y1, int X2, int Y2, String[][] board, String lowerCasePattern, String upperCasePattern) {

        boolean validMovement = false;

        switch (pieceBeingMoved.toUpperCase()) {

            // Pawn movement
            case "P":

                if (turn.equals("white")) {
                    Pawn pawn = new Pawn(X1, Y1, X2, Y2, turn, board, lowerCasePattern);
                    validMovement = pawn.isValidMove();
                } else {
                    Pawn pawn = new Pawn(X1, Y1, X2, Y2, turn, board, upperCasePattern);
                    validMovement = pawn.isValidMove();
                }

                break;

            // Rook movement
            case "T":

                if (turn.equals("white")) {
                    Rook rook = new Rook(X1, Y1, X2, Y2, turn, board, lowerCasePattern);
                    validMovement = rook.isValidMove();
                } else {
                    Rook rook = new Rook(X1, Y1, X2, Y2, turn, board, upperCasePattern);
                    validMovement = rook.isValidMove();
                }

                break;

            // Knight movement
            case "C":

                if (turn.equals("white")) {
                    Knight knight = new Knight(X1, Y1, X2, Y2, turn, board, lowerCasePattern);
                    validMovement = knight.isValidMove();
                } else {
                    Knight knight = new Knight(X1, Y1, X2, Y2, turn, board, upperCasePattern);
                    validMovement = knight.isValidMove();
                }

                break;

            // Bishop movement
            case "A":

                if (turn.equals("white")) {
                    Bishop bishop = new Bishop(X1, Y1, X2, Y2, turn, board, lowerCasePattern);
                    validMovement = bishop.isValidMove();
                } else {
                    Bishop bishop = new Bishop(X1, Y1, X2, Y2, turn, board, upperCasePattern);
                    validMovement = bishop.isValidMove();
                }

                break;

            // King movement
            case "K":

                if (turn.equals("white")) {
                    King king = new King(X1, Y1, X2, Y2, turn, board, lowerCasePattern);
                    validMovement = king.isValidMove();
                } else {
                    King king = new King(X1, Y1, X2, Y2, turn, board, upperCasePattern);
                    validMovement = king.isValidMove();
                }

                break;

            // Queen movement
            case "Q":

                if (turn.equals("white")) {
                    Queen queen = new Queen(X1, Y1, X2, Y2, turn, board, lowerCasePattern);
                    validMovement = queen.isValidMove();
                } else {
                    Queen queen = new Queen(X1, Y1, X2, Y2, turn, board, upperCasePattern);
                    validMovement = queen.isValidMove();
                }

                break;

            default:
                break;
        }

        return validMovement;
    }

    /**
     * 
     * @param X1 x coordinate of piece to move
     * @param Y1 y coordinate of piece to move
     * @param X2 x coordinate of destination
     * @param Y2 y coordinate of destination
     */
    private void movePiece(int X1, int Y1, int X2, int Y2) {
        this.board[X2][Y2] = this.board[X1][Y1];
        this.board[X1][Y1] = "·";
    }

    /**
     * Convert char to row number
     * @param number
     * @return
     */
    private int getRow(char number) {
        String fila = Character.toString(number);
        return Integer.valueOf(fila);
    }

    /**
     * Convert char to column number
     * @param boardCoordinates
     * @return
     */
    private int getColumn(String boardCoordinates) {
    
        int column = 0;

        switch (Character.toString(boardCoordinates.charAt(1)).toUpperCase()) {
            case "A":
                column = 0;
                break;
            
            case "B":
                column = 1;
                break;
                
            case "C":
                column = 2;
                break;
                
            case "D":
                column = 3;
                break;

            case "E":
                column = 4;
                break;

            case "F":
                column = 5;
                break;

            case "G":
                column = 6;
                break;

            case "H":
                column = 7;
                break;
            
            default:
                column = 0;
                break;
        }

        return column;
    }
}
