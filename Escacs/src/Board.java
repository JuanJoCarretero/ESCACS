import java.util.Scanner;

public class Board {
    
    private Scanner keyboard = new Scanner(System.in);
    private String pieceToMove;
    private String movement;
    private String[][] taulell = {
        {" t "," c "," a "," q "," k "," a "," c "," t "},
        {" p "," p "," p "," p "," p "," p "," p "," p "},
        {" . "," . "," . "," . "," . "," . "," . "," . "},
        {" . "," . "," . "," . "," . "," . "," . "," . "},
        {" . "," . "," . "," . "," . "," . "," . "," . "},
        {" . "," . "," . "," . "," . "," . "," . "," . "},
        {" P "," P "," P "," P "," P "," P "," P "," P "},
        {" T "," C "," A "," K "," Q "," A "," C "," T "}
    };
    
    public String[][] getTaulell() {
        return taulell;
    }
    
    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getPieceToMove() {
        return pieceToMove;
    }

    public void setPieceToMove(String pieceToMove) {
        this.pieceToMove = pieceToMove;
    }

    public void printBoard () {
        
        System.out.println("   A " + " B " + " C " + " D " + " E " + " F " + " G " + " H ");
        System.out.println(" -------------------------");
        
        for (int f = 0; f < this.taulell.length; f++) {

            if (f < 9) {
                System.out.print((f+1) + "|");
            }

            if (f == 9) {
                System.out.print((f+1) + "|");
            }

            for (int c = 0; c < this.taulell[f].length; c++) {
                System.out.print(this.taulell[f][c]);
            }

            System.out.println();
        }
    }
    
    public void askPlay() {

        String pattern = "^[1-8]{1}[A-H]{1}$";

        do {
            System.out.println("Which piece would you like to move? Position should be written like: 4B");
            this.pieceToMove = this.keyboard.next();
        } while (!(this.pieceToMove.matches(pattern)));
        
        do {
            System.out.println("Where would you like to move piece " + this.pieceToMove + " ? Position should be written like: 4B");
            this.movement = this.keyboard.next();
        } while (!(this.movement.matches(pattern)));
    }
}
