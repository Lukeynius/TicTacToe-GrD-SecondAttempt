import example.Player;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void testGetMarkerPositive() {
        Player p = new Player('X');
        assertEquals('X', p.getMarker());
    }

    @Test
    void testGetMarkerNegative() {
        Player p = new Player('O');
        assertNotEquals('X', p.getMarker());
    }
}
