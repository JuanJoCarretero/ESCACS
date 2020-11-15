public class Chess {
    
    private String player1 = "";
    private String player2 = "";
    private String turn = ""; 

    private int turnNumber;
    
    private boolean victory;

    /**
     * Constructor
     * @param player1
     * @param player2
     */
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

    /**
     * Game starts
     * Checks which turn is it
     * Asks player his movement
     */
    public void initGame () {
        
        Board board = new Board();
        
        System.out.println("Hello " + this.player1);
        System.out.println("Hello " + this.player2);
        System.out.println("\nThe game starts!!");
        System.out.println();
        board.printBoard();
        System.out.println();
        System.out.println(this.player1 + " starts!\nReminder: you play with Upper Case pieces!");
        System.out.println();

        do {
            if (this.turnNumber%2 == 0 && this.turnNumber != 1) {
                System.out.println("Is " + this.player2 + "'s turn!\nReminder: you play with Lower Case pieces!");
                this.turn = "black";
            } else if (this.turnNumber%2 != 0 && this.turnNumber != 1) {
                System.out.println("Is " + this.player1 + "'s turn!\nReminder: you play with Upper Case pieces!");
                this.turn = "white";
            }

            board.askPlay(this.turn);


            this.turnNumber++;
        } while (victory);
    }

    private boolean checkVictory() {
        return this.victory;
    }


}
