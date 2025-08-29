package example;
//########################################################################

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
        currentPlayer = player1;
        System.out.println("Spiel gestartet!");
        board.print();
        System.out.println("Spieler (" + currentPlayer.getMarker() + ") ist am Zug.");
    }
}