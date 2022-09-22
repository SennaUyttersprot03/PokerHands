package logica;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PokerHands : CardTest
 *
 * @author Senna Uyttersprot
 * @version 22/09/2022
 */
class CardTest {
    @Test
    public void typeTest() {
        for(int i = 'A'; i <= 'Z'; i++) {
            if (i == 'C' || i == 'D' || i == 'H' || i == 'S') continue;
            char t = (char) i;
            assertThrows(IllegalArgumentException.class, () -> new Card(t + "1"));
        };
    }

    @Test
    public void valueTest() {
        for(int i)
    }
}