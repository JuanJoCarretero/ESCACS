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
        
        for (int r = 0; r < this.taulell.length; r++) {

            if (r < 9) {
                System.out.print((r+1) + "|");
            }

            if (r == 9) {
                System.out.print((r+1) + "|");
            }

            for (int c = 0; c < this.taulell[r].length; c++) {
                System.out.print(this.taulell[r][c]);
            }

            System.out.println();
        }
    }
    
    public void askPlay() {

        String pattern = "^[1-8]{1}[A-H]{1}$";
        int row;
        int column;

        do {
            System.out.println("Which piece would you like to move? Position should be written like: 4B");
            this.pieceToMove = this.keyboard.next();

            row = getRow(this.pieceToMove.charAt(0)) - 1;
            column = getColumn(this.pieceToMove);

        } while (!(this.pieceToMove.matches(pattern)) || (this.taulell[row][column].equals(" . ")));
        
        do {
            System.out.println("Where would you like to move piece " + this.pieceToMove + " ? Position should be written like: 4B");
            this.movement = this.keyboard.next();

            row = getRow(this.pieceToMove.charAt(0)) - 1;
            column = getColumn(this.pieceToMove);

        } while (!(this.movement.matches(pattern)) || (this.taulell[row][column].equals(" . ")));
    }

    public static int getRow(char number) {
        String fila = Character.toString(number);

        return Integer.valueOf(fila);
    }

    public static int getColumn(String boardCoordinates) {
    
        int column = 0;

        switch (Character.toString(boardCoordinates.charAt(1))) {
            case "A":
                column = 0;
                break;
            
            case "B":
                column = 1;
                break;
                
            case "C":
                column = 2;
                break;
                
            case "D":
                column = 3;
                break;

            case "E":
                column = 4;
                break;

            case "F":
                column = 5;
                break;

            case "G":
                column = 6;
                break;

            case "H":
                column = 7;
                break;
            
            default:
                column = 0;
                break;
        }

        return column;
    }
}
