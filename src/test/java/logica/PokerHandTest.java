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
    }

    ;

    @Test
    public void testFlush() {
        PokerHand flush = new PokerHand(
                new Card[]{
                        new Card("H2"),
                        new Card("H3"),
                        new Card("H4"),
                        new Card("H7"),
                        new Card("H6")
                }
        );
        PokerHand noFlush = new PokerHand(
                new Card[]{
                        new Card("H2"),
                        new Card("H3"),
                        new Card("D4"),
                        new Card("C3"),
                        new Card("S6")
                }
        );
        assertEquals("Flush", flush.getScore());
        assertNotEquals("Flush", noFlush.getScore());
    }

    @Test
    public void testStraight() {
        PokerHand straight = new PokerHand(
                new Card[]{
                        new Card("H2"),
                        new Card("S3"),
                        new Card("D4"),
                        new Card("S5"),
                        new Card("H6")
                }
        );
        PokerHand highestStraight = new PokerHand(
                new Card[]{
                        new Card("H9"),
                        new Card("S10"),
                        new Card("DQ"),
                        new Card("SK"),
                        new Card("HJ")
                }
        );
        PokerHand lowestStraight = new PokerHand(
                new Card[]{
                        new Card("H2"),
                        new Card("S4"),
                        new Card("D3"),
                        new Card("S5"),
                        new Card("HA")
                }
        );
        PokerHand noStraight = new PokerHand(
                new Card[]{
                        new Card("H2"),
                        new Card("H3"),
                        new Card("D4"),
                        new Card("C3"),
                        new Card("S6")
                }
        );
        assertEquals("Straight", straight.getScore());
        assertEquals("Straight", highestStraight.getScore());
        assertEquals("Straight", lowestStraight.getScore());
        assertNotEquals("Straight", noStraight.getScore());
    }

    @Test
    public void testStraightFlush() {
        PokerHand straightFlush = new PokerHand(
                new Card[]{
                        new Card("H2"),
                        new Card("H3"),
                        new Card("H4"),
                        new Card("H5"),
                        new Card("H6")
                }
        );
        assertEquals("Straight Flush", straightFlush.getScore());
    }

    @Test
    public void testRoyalFlush() {
        PokerHand royalFlush = new PokerHand(
                new Card[]{
                        new Card("H10"),
                        new Card("HJ"),
                        new Card("HQ"),
                        new Card("HK"),
                        new Card("HA"),
                }
        );
        assertEquals("Royal Flush", royalFlush.getScore());
    }
}
