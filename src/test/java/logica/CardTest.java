package logica;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PokerHands : CardTest
 *
 * @author Senna Uyttersprot
 * @version 22/09/2022
 */
class CardTest {
    @Test
    public void typeTestOnEveryLetter() {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (i == 'C' || i == 'D' || i == 'H' || i == 'S') continue;
            char t = (char) i;
            assertThrows(IllegalArgumentException.class, () -> new Card(t + "1"));
        }
        ;
    }

    @ParameterizedTest
    @CsvSource(value = {"1 15 C"})
    public void valueTestOnWrongCardValues(String cardValues) {
        for (String cardValue : cardValues.split(" ")) {
            assertThrows(IllegalArgumentException.class, () -> new Card("C" + cardValue));
        }
    }
}