import example.TicTacToe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    public void testPlaceOnEmptyCell() {
        TicTacToe game = new TicTacToe();

        // (0,0) ist zu Beginn leer
        assertTrue(game.board.isCellEmpty(0, 0));

        // Spieler X setzt
        game.board.place(0, 0);

        // Danach darf es nicht mehr leer sein
        assertFalse(game.board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlaceOnOccupiedCell() {
        TicTacToe game = new TicTacToe();

        // Spieler X setzt auf (0,0)
        game.board.place(0, 0);

        // Spieler O versucht ebenfalls auf (0,0)
        game.board.place(0, 0);

        // Feld bleibt belegt
        assertFalse(game.board.isCellEmpty(0, 0));
    }

    @Test
    public void testRowWin() {
        TicTacToe game = new TicTacToe();

        game.board.place(0, 0); // X
        game.board.place(1, 0); // O
        game.board.place(0, 1); // X
        game.board.place(1, 1); // O
        game.board.place(0, 2); // X gewinnt

        assertTrue(game.hasWinner(), "X sollte durch die obere Reihe gewinnen");
    }

    @Test
    public void testColumnWin() {
        TicTacToe game = new TicTacToe();

        game.board.place(0, 0); // X
        game.board.place(0, 1); // O
        game.board.place(1, 0); // X
        game.board.place(1, 1); // O
        game.board.place(2, 0); // X gewinnt

        assertTrue(game.hasWinner(), "X sollte durch die linke Spalte gewinnen");
    }

    @Test
    public void testDiagonalWin() {
        TicTacToe game = new TicTacToe();

        game.board.place(0, 0); // X
        game.board.place(0, 1); // O
        game.board.place(1, 1); // X
        game.board.place(0, 2); // O
        game.board.place(2, 2); // X gewinnt

        assertTrue(game.hasWinner(), "X sollte durch die Diagonale gewinnen");
    }

    @Test
    public void testDraw() {
        TicTacToe game = new TicTacToe();

        // Brett vollspielen ohne Sieger
        game.board.place(0, 0); // X
        game.board.place(0, 1); // O
        game.board.place(0, 2); // X
        game.board.place(1, 1); // O
        game.board.place(1, 0); // X
        game.board.place(1, 2); // O
        game.board.place(2, 1); // X
        game.board.place(2, 0); // O
        game.board.place(2, 2); // X

        assertFalse(game.hasWinner(), "Kein Sieger erwartet");
        assertTrue(game.board.isFull(), "Das Spielfeld sollte voll sein");
    }
}
