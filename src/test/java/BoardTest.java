import example.Board;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void testPlacePositive() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertEquals('X', board.isCellEmpty(0, 0));
    }

    @Test
    void testPlaceNegative() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(0, 0, 'O'); // darf Feld nicht überschreiben
        assertEquals('X', board.isCellEmpty(0, 0));
    }

    @Test
    void testIsCellEmptyPositive() {
        Board board = new Board();
        assertEquals(' ', board.isCellEmpty(1, 1)); // frisch angelegt → leer
    }

    @Test
    void testIsCellEmptyNegative() {
        Board board = new Board();
        board.place(2, 2, 'O');
        assertNotEquals(' ', board.isCellEmpty(2, 2)); // sollte belegt sein
    }

    @Test
    void testIsFullPositive() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void testIsFullNegative() {
        Board board = new Board();
        assertFalse(board.isFull()); // frisch angelegt → leer
    }

    @Test
    void testClearPositive() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.clear();
        assertEquals(' ', board.isCellEmpty(0, 0));
    }

    @Test
    void testClearNegative() {
        Board board = new Board();
        board.clear(); // direkt nach Konstruktor
        assertEquals(' ', board.isCellEmpty(1, 1)); // immer noch leer
    }
}
