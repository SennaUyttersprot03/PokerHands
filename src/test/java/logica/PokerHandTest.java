package logica;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PokerHands: PokerHandTest
 *
 * @author Quinten Conil
 * @version 22/09/2022
 */
class PokerHandTest {
    @BeforeEach
    void setup() {
    }

    @AfterEach
    void teardown() {
    }

    @Test
    public void testTeveelKaarten() {
        Card[] cards = {new Card("C4"),
                new Card("C3"),
                new Card("D7"),
                new Card("H2"),
                new Card("H5"),
                new Card("H8")};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new PokerHand(cards));
        assertEquals("Hand is groter dan 5", exception.getMessage());
    }

    @Test
    public void testTeWeinigKaarten() {
        Card[] cards = {new Card("C4"),
                new Card("C3"),
                new Card("D7"),
                new Card("H2")};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new PokerHand(cards));
        assertEquals("Hand is kleiner dan 5", exception.getMessage());
    }


}
