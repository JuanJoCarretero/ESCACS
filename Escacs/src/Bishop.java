public class Bishop extends Piece {

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
    public Bishop (int X1, int Y1, int X2, int Y2, String turn, String[][] board, String pattern) {
        super(X1, Y1, X2, Y2, turn, board, pattern);
    }

    /**
     * Check if bishop can move in any direction in diagonal
     * @return 
     */
    @Override
    public boolean isValidMove() {
        boolean valid = false;

        // Top left diagonal movement
        if (this.X1 > this.X2 && this.Y1 > this.Y2 && (Math.abs(this.X2 - this.X1) == Math.abs(this.Y2 - this.Y1))) {

            if ((this.X1 - this.X2 != 1) && (this.Y1 - this.Y2 != 1)) {

                for (int i = 1; i < Math.abs(this.X2 - this.X1); i++) {
                    
                    if (this.board[this.X1-i][this.Y1-i].equals("·")) {
                        continue;
                    }
                    return valid = false; 
                }
            }

            if (this.board[this.X2][this.Y2].equals("·") || this.board[this.X2][this.Y2].matches(this.pattern)) {
                valid = true;
            }
        }
        
        // Top right diagonal movement
        if (this.X1 > this.X2 && this.Y1 < this.Y2 && (Math.abs(this.X2 - this.X1) == Math.abs(this.Y2 - this.Y1))){

            if ((this.X1 - this.X2 != 1) && (this.Y2 - this.Y1 != 1)) {

                for (int i = 1; i < Math.abs(this.X2 - this.X1); i++) {
                    
                    if (this.board[this.X1-i][this.Y1+i].equals("·")) {
                        continue;
                    }
                    return valid = false; 
                }
            }

            if (this.board[this.X2][this.Y2].equals("·") || this.board[this.X2][this.Y2].matches(this.pattern)) {
                valid = true;
            }
        }
        
        // Bottom right diagonal movement
        if (this.X1 < this.X2 && this.Y1 < this.Y2 && (Math.abs(this.X2 - this.X1) == Math.abs(this.Y2 - this.Y1))){

            if ((this.X1 - this.X2 != 1) && (this.Y2 - this.Y1 != 1)) {

                for (int i = 1; i < Math.abs(this.X2 - this.X1); i++) {
                    
                    if (this.board[this.X1+i][this.Y1+i].equals("·")) {
                        continue;
                    }
                    return valid = false; 
                }
            }

            if (this.board[this.X2][this.Y2].equals("·") || this.board[this.X2][this.Y2].matches(this.pattern)) {
                valid = true;
            }
        }
        
        // Bottom left diagonal movement
        if (this.X1 < this.X2 && this.Y1 > this.Y2 && (Math.abs(this.X2 - this.X1) == Math.abs(this.Y2 - this.Y1))){

            if ((this.X1 - this.X2 != 1) && (this.Y2 - this.Y1 != 1)) {

                for (int i = 1; i < Math.abs(this.X2 - this.X1); i++) {
                    
                    if (this.board[this.X1+i][this.Y1-i].equals("·")) {
                        continue;
                    }
                    return valid = false; 
                }
            }

            if (this.board[this.X2][this.Y2].equals("·") || this.board[this.X2][this.Y2].matches(this.pattern)) {
                valid = true;
            }
        }
        
        return valid;
    }
}
