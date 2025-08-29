package example;
//########################################################################

import java.util.Scanner;

public class TicTacToe {

    //#########################################################################
    // variables
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;


    //#########################################################################
    // Constructor
    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }


    //#########################################################################
    //methods

    //start the game
    public void start() {
        //local variables
        Scanner scanner = new Scanner(System.in);

        //gamestart
        currentPlayer = player1;
        System.out.println("Spiel gestartet!");
        board.print();

        while (true) {
            System.out.println("Spieler (" + currentPlayer.getMarker() + ") ist am Zug.");
            int x, y;

            // loop the input till a vaild move was made
            while (true) {

                System.out.print("Gib Zeile (0–2) ein: ");
                x = scanner.nextInt();
                System.out.print("Gib Spalte (0–2) ein: ");
                y = scanner.nextInt();

                if (x >= 0 && x < 3 && y >= 0 && y < 3) {
                    if (board.isCellEmpty(x, y) == ' ') {
                        board.place(x, y, currentPlayer.getMarker());
                        break;
                    } else {
                        System.out.println("Dieses Feld ist bereits belegt. Versuch es erneut.");
                    }
                } else {
                    System.out.println("Ungültige Eingabe. Werte müssen zwischen 0 und 2 liegen.");
                }

            }
            // check if the board is full
            if (board.isFull()) {
                System.out.println("Unentschieden!");
                break;
            }
            // show the current board state
            board.print();
            // switch the current player
            switchCurrentPlayer();
        }
            scanner.close();
    }

    // switch the current player
    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

}