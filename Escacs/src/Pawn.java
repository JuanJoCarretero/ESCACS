public class Pawn extends Piece {
    
    /**
     * Constructor
     * @param X1 x coordinate of piece to move
     * @param Y1 y coordinate of piece to move
     * @param X2 x coordinate of destination
     * @param Y2 y coordinate of destination
     * @param turn
     * @param board
     * @param pattern
     */
    public Pawn (int X1, int Y1, int X2, int Y2, String turn, String[][] board, String pattern) {
        super(X1, Y1, X2, Y2, turn, board, pattern);
    }

    /**
     * Check if pawns can advance one position or kill with diagonal movement
     * @return 
     */
    @Override
    public boolean isValidMove() {
        boolean valid = false;

        // White pawns movement
        if (this.turn.equals("white")) {
            
            // Pawn is at start position and it can move 2 positions at once
            if (this.X1 == 6) {
                
                if (this.Y1 == this.Y2 && this.board[X2][Y2].equals("·") && ((this.X1 - 1) == X2 || (this.X1 - 2 == this.X2))) {
                    valid = true;
                } else if ((this.Y1 != this.Y2 && (this.X1 - this.X2) == 1)) {

                    if ((this.Y1 + 1) == this.Y2 && this.board[this.X2][this.Y2].matches(this.pattern)) {
                        valid = true;
                    } else if ((this.Y1 - 1) == this.Y2 && this.board[this.X2][this.Y2].matches(this.pattern)) {
                        valid = true;
                    }
                }
                
            } else {
                if ((this.X1 - this.X2) != 1) {
                    valid = false;
                } else {

                    if (this.Y1 == this.Y2 && this.board[this.X2][this.Y2].equals("·")) {
                        valid = true;
                    } else if ((this.Y1 != this.Y2)) {

                        if ((this.Y1 + 1) == this.Y2 && this.board[this.X2][this.Y2].matches(this.pattern)) {
                            valid = true;
                        } else if ((this.Y1 - 1) == this.Y2 && board[this.X2][this.Y2].matches(this.pattern)) {
                            valid = true;
                        }
                    }
                }
            }

        } else {

            // Black pawns movement
            
            // Pawn is at start position and it can move 2 positions at once
            if (this.X1 == 1) {
                
                if (this.Y1 == this.Y2 && this.board[this.X2][this.Y2].equals("·") && ((this.X1 + 1) == this.X2 || (this.X1 + 2 == this.X2))) {
                    valid = true;
                } else if ((this.Y1 != this.Y2 && (this.X2 - this.X1) == 1)) {

                    if ((this.Y1 + 1) == this.Y2 && this.board[this.X2][this.Y2].matches(this.pattern)) {
                        valid = true;
                    } else if ((this.Y1 - 1) == this.Y2 && board[this.X2][this.Y2].matches(this.pattern)) {
                        valid = true;
                    }
                }
                
            } else {
                if ((this.X2 - this.X1) != 1) {
                    valid = false;
                } else {

                    if (this.Y1 == this.Y2 && this.board[this.X2][this.Y2].equals("·")) {
                        valid = true;
                    } else if ((this.Y1 != this.Y2)) {

                        if ((this.Y1 + 1) == this.Y2 && this.board[this.X2][this.Y2].matches(this.pattern)) {
                            valid = true;
                        } else if ((this.Y1 - 1) == this.Y2 && this.board[this.X2][this.Y2].matches(this.pattern)) {
                            valid = true;
                        }
                    }
                }
            }
        }

        return valid;
    }
}
