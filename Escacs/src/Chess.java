public class Chess {
    
    private String player1 = "";
    private String player2 = "";

    private int turn;
    
    private boolean victory;

    public Chess (String player1, String player2) {
        setPlayer1(player1);
        setPlayer2(player2);
        this.turn = 0;
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

    public void initGame () {
        
        System.out.println("Hello " + this.player1);
        System.out.println("Hello " + this.player2);

        do {
            
        } while (!victory);
    }

    private boolean checkVictory() {
        return this.victory;
    }
}
