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

            // show the current board state
            board.print();
            // check if the currentplayer has won
            if (hasWinner()) {
                System.out.println("Spieler (" + currentPlayer.getMarker() + ") hat gewonnen!");
                break;
            }
            // check if the board is full
            if (board.isFull()) {
                System.out.println("Unentschieden!");
                break;
            }
            // switch the current player
            switchCurrentPlayer();
        }
            scanner.close();
    }

    // switch the current player
    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    // check if a player has won
    private boolean hasWinner() {
        int[][][] kombis = {
                {{0, 0}, {0, 1}, {0, 2}},
                {{1, 0}, {1, 1}, {1, 2}},
                {{2, 0}, {2, 1}, {2, 2}},
                {{0, 0}, {1, 0}, {2, 0}},
                {{0, 1}, {1, 1}, {2, 1}},
                {{0, 2}, {1, 2}, {2, 2}},
                {{0, 0}, {1, 1}, {2, 2}},
                {{0, 2}, {1, 1}, {2, 0}}
        };

        for (int[][] kombi : kombis) {
            char m1 = board.isCellEmpty(kombi[0][0], kombi[0][1]);
            char m2 = board.isCellEmpty(kombi[1][0], kombi[1][1]);
            char m3 = board.isCellEmpty(kombi[2][0], kombi[2][1]);

            if (m1 != ' ' && m1 == m2 && m2 == m3) {
                return true;
            }
        }

        return false;
    }

}