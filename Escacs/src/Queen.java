public class Queen extends Piece {

    public Queen (int X1, int Y1, int X2, int Y2, String turn, String[][] board, String pattern) {
        super(X1, Y1, X2, Y2, turn, board, pattern);
    }

    @Override
    public boolean isValidMove() {
        boolean valid = false;
        
        // Moves in vertical direction (up or down)
        if (this.Y1 == this.Y2) {
            
            if (this.X1 > this.X2) {

                if (this.X1 - this.X2 != 1) {

                    for (int r = (this.X1 - 1); r > this.X2; r--) {

                        if (this.board[r][this.Y1].equals("·")) {
                            continue;
                        }
                        return valid = false;
                    }
                } 

                if (this.board[this.X2][this.Y2].equals("·") || this.board[this.X2][this.Y2].matches(this.pattern)) {
                    valid = true;
                }

            } else if (this.X1 < this.X2){

                if (this.X2 - this.X1 != 1) {

                    for (int r = (this.X1 + 1); r < this.X2; r++) {

                        if (this.board[r][this.Y1].equals("·")) {
                            continue;
                        }
                        return valid = false;
                    }
                }

                if (this.board[this.X2][this.Y2].equals("·") || this.board[this.X2][this.Y2].matches(this.pattern)) {
                    valid = true;
                }
            }
        }

        // Moves in horizontal direction (left or right)
        if (this.X1 == this.X2) {
            
            if (this.Y1 > this.Y2) {

                if (this.Y1 - this.Y2 != 1) {

                    for (int c = (this.Y1 - 1); c > this.Y2; c--) {

                        if (this.board[this.X1][c].equals("·")) {
                            continue;
                        }
                        return valid = false;
                    }
                }

                if (this.board[this.X2][this.Y2].equals("·") || this.board[this.X2][this.Y2].matches(this.pattern)) {
                    valid = true;
                }

            } else if (this.Y1 < this.Y2){

                if (this.Y2 - this.Y1 != 1) {

                    for (int c = (this.Y1 + 1); c < this.Y2; c++) {

                        if (this.board[this.X1][c].equals("·")) {
                            continue;
                        }
                        return valid = false;
                    }
                }
                
                if (this.board[this.X2][this.Y2].equals("·") || this.board[this.X2][this.Y2].matches(this.pattern)) {
                    valid = true;
                }
            }
        }

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
        
        // Bottom left diagonal movemen
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
