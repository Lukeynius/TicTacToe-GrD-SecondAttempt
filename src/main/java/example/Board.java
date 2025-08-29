package example;

public class Board {


    //#########################################################################
    // variables
    private char[][] cells;


    //#########################################################################
    // Constructor
    public Board() {
        cells = new char[3][3];
    }

    //#########################################################################
    //methods
    // print the board in the console
    public void print() {
        System.out.println("Aktuelles Spielfeld:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] == ' ' ? "-" : cells[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
        }
    }
}