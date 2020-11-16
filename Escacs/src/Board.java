import java.util.Scanner;

public class Board {
    
    //DEFINITION OF VARIABLES
    private Scanner keyboard = new Scanner(System.in);
    private String pieceToMove;
    private String movement;
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
     * 
     * @return
     */
    public String[][] getBoard() {
        return board;
    }
    
    /**
     * 
     * @return
     */
    public String getMovement() {
        return movement;
    }

    /**
     * 
     * @param movement
     */
    public void setMovement(String movement) {
        this.movement = movement;
    }

    /**
     * 
     * @return
     */
    public String getPieceToMove() {
        return pieceToMove;
    }
    
    /**
     * 
     * @param pieceToMove
     */
    public void setPieceToMove(String pieceToMove) {
        this.pieceToMove = pieceToMove;
    }

    /**
     * METHOD FOR PRINT THE BOARD
     */
    public void printBoard () {
        
        System.out.println("   A " + " B " + " C " + " D " + " E " + " F " + " G " + " H ");
        System.out.println(" -------------------------");
        
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
     * 
     * @param turn
     */
    public void askPlay(String turn) {

        String pieceBeingMoved;
        String movementPattern = "^[1-8]{1}[A-H]{1}$";
        String upperCasePattern = "[A-Z]";
        String lowerCasePattern = "[a-z]";
        boolean validPiece = false;
        boolean validDestination = false;
        boolean cancel = false;
        boolean validMovement = false;
        int X1 = 0;
        int Y1 = 0;
        int X2 = 0;
        int Y2 = 0;

        do {
            
            do {
                
                do {
                    System.out.println("\n" + "If you want to cancel the movement at any time, just type \"C\"");
                    System.out.println("Which piece would you like to move? Position should be written like: 4B");
                    this.pieceToMove = this.keyboard.next();

                    cancel = (this.pieceToMove.equals("C")) ? true : false;

                    if (!cancel) {

                        X1 = getRow(this.pieceToMove.charAt(0)) - 1;
                        Y1 = getColumn(this.pieceToMove);

                        if (turn.equals("white")) {
                            validPiece = (this.board[X1][Y1].matches(upperCasePattern)) ? true : false;
                        } else {
                            validPiece = (this.board[X1][Y1].matches(lowerCasePattern)) ? true : false;
                        }
                    }

                } while (!(this.pieceToMove.matches(movementPattern)) || !validPiece);
                
                do {
                    System.out.println("Where would you like to move piece " + this.pieceToMove + " ? Position should be written like: 4B");
                    this.movement = this.keyboard.next();

                    cancel = (this.movement.equals("C")) ? true : false;

                    if (!cancel) {

                        X2 = getRow(this.movement.charAt(0)) - 1;
                        Y2 = getColumn(this.movement);

                        if (turn.equals("white")) {
                            validDestination = (this.board[X2][Y2].matches(lowerCasePattern) || this.board[X2][Y2].equals("·")) ? true : false;
                        } else {
                            validDestination = (this.board[X2][Y2].matches(upperCasePattern) || this.board[X2][Y2].equals("·")) ? true : false;
                        }
                    }

                } while (!(this.movement.matches(movementPattern)) && !cancel || !validDestination && !cancel);

            } while (cancel);

            pieceBeingMoved = this.board[X1][Y1];

            switch (pieceBeingMoved.toUpperCase()) {

                case "P":

                    if (turn.equals("white")) {
                        Pawn pawn = new Pawn(X1, Y1, X2, Y2, turn, board, lowerCasePattern);
                        validMovement = pawn.isValidMove();
                    } else {
                        Pawn pawn = new Pawn(X1, Y1, X2, Y2, turn, board, upperCasePattern);
                        validMovement = pawn.isValidMove();
                    }

                    break;

                case "T":

                    if (turn.equals("white")) {
                        Rook rook = new Rook(X1, Y1, X2, Y2, turn, board, lowerCasePattern);
                        validMovement = rook.isValidMove();
                    } else {
                        Rook rook = new Rook(X1, Y1, X2, Y2, turn, board, upperCasePattern);
                        validMovement = rook.isValidMove();
                    }

                    break;

                case "C":

                    if (turn.equals("white")) {

                    } else {

                    }

                    break;

                case "A":

                    if (turn.equals("white")) {
                        Bishop bishop = new Bishop(X1, Y1, X2, Y2, turn, board, lowerCasePattern);
                        validMovement = bishop.isValidMove();
                    } else {
                        Bishop bishop = new Bishop(X1, Y1, X2, Y2, turn, board, upperCasePattern);
                        validMovement = bishop.isValidMove();
                    }

                    break;

                case "K":

                    if (turn.equals("white")) {

                    } else {

                    }

                    break;

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

        } while (!validMovement);

        movePiece(X1, Y1, X2, Y2);

    }

    private void movePiece(int X1, int Y1, int X2, int Y2) {
        this.board[X2][Y2] = this.board[X1][Y1];
        this.board[X1][Y1] = "·";
    }

    /**
     * 
     * @param number
     * @return
     */
    public static int getRow(char number) {
        String fila = Character.toString(number);

        return Integer.valueOf(fila);
    }

    /**
     * 
     * @param boardCoordinates
     * @return
     */
    public static int getColumn(String boardCoordinates) {
    
        int column = 0;

        switch (Character.toString(boardCoordinates.charAt(1))) {
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
