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
        Card[] cards = {
                new Card("C4"),
                new Card("C3"),
                new Card("D7"),
                new Card("H2")
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new PokerHand(cards));
        assertEquals("Hand is kleiner dan 5", exception.getMessage());
    }
    @Test
    public void testTweeKeerDezelfdeKaart() {
        Card[] cards = {
                new Card("C4"),
                new Card("C4"),
                new Card("D7"),
                new Card("H2"),
                new Card("S2")
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new PokerHand(cards));
    };


    @Test
    public void testOngeldigeKaart1() {
        Card[] cards = {new Card("C4"),
                new Card("L3"),
                new Card("D7"),
                new Card("H2"),
                new Card("H8")};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new PokerHand(cards));
        assertEquals("No enum constant Enum.CardTypes.L", exception.getMessage());
    }

    @Test
    public void testOngeldigeKaart2() {
        Card[] cards = {new Card("C4"),
                new Card("H15"),
                new Card("D7"),
                new Card("H2"),
                new Card("H8")};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new PokerHand(cards));
        assertEquals("Should be between [2,10] or be J,Q,K or A", exception.getMessage());
    }
}
