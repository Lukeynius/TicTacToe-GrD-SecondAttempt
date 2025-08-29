package example;

public class Board {


    //#########################################################################
    // variables
    private char[][] cells;


    //#########################################################################
    // Constructor
    public Board() {
        cells = new char[3][3];
        clear();
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

    // check if the cell is empty
    public char isCellEmpty(int x, int y) {
        return cells[x][y];
    }

    // place a symbol if it is empty
    public void place(int x, int y, char marker) {
        if (cells[x][y] == ' ') {
            cells[x][y] = marker;
        }
    }

    // check if the board is full
    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // clear the board
    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

}