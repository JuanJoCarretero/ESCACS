public class Chess {
    
    private String player1 = "";
    private String player2 = "";
    private String turn = ""; 

    private int turnNumber;
    
    private boolean victory;

    public Chess (String player1, String player2) {
        setPlayer1(player1);
        setPlayer2(player2);
        this.turn = "white";
        this.turnNumber = 1;
        this.victory = false;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }
    
    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer1() {
        return player1;
    }
    
    public String getPlayer2() {
        return player2;
    }

    public String getTurn() {
        return this.turn;
    }

    public void initGame () {
        
        Board taulell = new Board();

        System.out.println("Hello " + this.player1);
        System.out.println("Hello " + this.player2);
        System.out.println("The game starts!!");
        System.out.println();
        taulell.printBoard();
        System.out.println();
        System.out.println("Player with white pieces starts!");
        System.out.println();

        do {
            if (this.turnNumber%2 == 0 && this.turnNumber != 1) {
                System.out.println("Player with black pieces plays!");
                this.turn = "black";
            } else if (this.turnNumber%2 != 0 && this.turnNumber != 1) {
                System.out.println("Player with white pieces plays!");
                this.turn = "white";
            }

            taulell.askPlay();


            this.turnNumber++;
        } while (victory);
    }

    private boolean checkVictory() {
        return this.victory;
    }


}
