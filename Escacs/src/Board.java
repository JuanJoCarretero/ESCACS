public class Board {
    
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
    public boolean checkMovementOfPieceSelected (String pieceBeingMoved, String turn, int X1, int Y1, int X2, int Y2, String[][] board, String lowerCasePattern, String upperCasePattern) {

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
    public void movePiece(int X1, int Y1, int X2, int Y2) {
        this.board[X2][Y2] = this.board[X1][Y1];
        this.board[X1][Y1] = "·";
    }

    /**
     * Convert char to row number
     * @param number
     * @return
     */
    public int getRow(char number) {
        String fila = Character.toString(number);
        return Integer.valueOf(fila);
    }

    /**
     * Convert char to column number
     * @param boardCoordinates
     * @return
     */
    public int getColumn(String boardCoordinates) {
    
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

     /**
      * Looks for both kings in the field
      * @return whether both kings exist or not
      */
    public boolean[] checkVictory() {

        boolean whiteKing = false;
        boolean blackKing = false;
        boolean[] kingsStatus = new boolean [2];

        for (int r = 0; r < this.board.length; r++) {
            for (int c = 0; c < this.board[r].length; c++) {

                if (this.board[r][c].equals("K")) {
                    whiteKing = true;
                }

                if (this.board[r][c].equals("k")) {
                    blackKing = true;
                }
            }
        }

        kingsStatus[0] = whiteKing;
        kingsStatus[1] = blackKing;

        return kingsStatus;
    }
}
