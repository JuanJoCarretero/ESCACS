public abstract class Piece {
    protected int X1;
    protected int Y1;
    protected int X2;
    protected int Y2;
    protected String turn;
    protected String[][] board = new String[8][8];
    protected String pattern;

    public Piece (int X1, int Y1, int X2, int Y2, String turn, String[][] board, String pattern) {
        this.X1 = X1;
        this.X2 = X2;
        this.Y1 = Y1;
        this.Y2 = Y2;
        this.turn = turn;
        this.board = board;
        this.pattern = pattern;
    }

    public abstract boolean isValidMove();
    
}
