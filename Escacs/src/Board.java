public class Board {
    
    private String movement;
    private char[][] taulell = {
        {'t','c','a','q','k','a','c','t'},
        {'p','p','p','p','p','p','p','p'},
        {' ',' ',' ',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ',' ',' ',' '},
        {'P','P','P','P','P','P','P','P'},
        {'T','C','A','K','Q','A','C','T'}
    };
    
    public String getMovement() {
        return movement;
    }
    
    public char[][] getTaulell() {
        return taulell;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public void printBoard () {
        for (int f = 0; f < this.taulell.length; f++) {
            System.out.println();

            for (int c = 0; c < this.taulell[f].length; c++) {
                System.out.print(this.taulell[f][c]);
            }
            
        }
    }
}
