public class Knight extends Piece {
    
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
    public Knight (int X1, int Y1, int X2, int Y2, String turn, String[][] board, String pattern) {
        super(X1, Y1, X2, Y2, turn, board, pattern);
    }

    /**
     * Check if knight can move following an "L" movement pattern in any direction
     * @return 
     */
    @Override
    public boolean isValidMove() {
        boolean valid = false;

        if ((this.Y1 + 1 == this.Y2) && (this.X1 - 2 == this.X2)) {
            valid = true;
        }
        
        if ((this.Y1 + 2 == this.Y2) && (this.X1 - 1 == this.X2)) {
            valid = true;
        }
        
        if ((this.Y1 + 1 == this.Y2) && (this.X1 + 1 == this.X2)) {
            valid = true;
        }
        
        if ((this.Y1 + 2 == this.Y2) && (this.X1 + 1 == this.X2)) {
            valid = true;
        }
        
        if ((this.Y1 + 1 == this.Y2) && (this.X1 + 2 == this.X2)) {
            valid = true;
        }
        
        if ((this.Y1 - 1 == this.Y2) && (this.X1 + 2 == this.X2)) {
            valid = true;
        }
        
        if ((this.Y1 - 2 == this.Y2) && (this.X1 + 1 == this.X2)) {
            valid = true;
        }
        
        if ((this.Y1 - 2 == this.Y2) && (this.X1 - 1 == this.X2)) {
            valid = true;
        }

        if ((this.Y1 - 1 == this.Y2) && (this.X1 - 2 == this.X2)) {
            valid = true;
        }

        return valid;
    }
}
