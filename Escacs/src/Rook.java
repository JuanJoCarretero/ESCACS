public class Rook extends Piece {
    
    public Rook (int X1, int Y1, int X2, int Y2, String turn, String[][] board, String pattern) {
        super(X1, Y1, X2, Y2, turn, board, pattern);
    }

    @Override
    public boolean isValidMove() {
        boolean valid = false;

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

        return valid;
    }
}
