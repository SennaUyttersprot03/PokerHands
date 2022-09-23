package logica;

import Enum.CardTypes;
import org.w3c.dom.ls.LSOutput;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/**
 * PokerHands : Card
 *
 * @author Senna Uyttersprot
 * @version 22/09/2022
 */
public class Card {
    CardTypes type;
    String value;

    public Card(String type, String value) throws IllegalArgumentException {
        this.type = CardTypes.valueOf(type);
        this.value = value;
    }

    public Card(String card) throws IllegalArgumentException {
        this.type = CardTypes.valueOf("" + card.charAt(0));
        String temp = card.substring(1);
        if (temp.length() >= 2 && Integer.parseInt(temp) != 10)
            throw new IllegalArgumentException("Should be between [2,10] or be J,Q,K or A");
        if (!"JQKA".contains(temp) && (2 > Integer.parseInt(temp) || Integer.parseInt(temp) > 10))
            throw new IllegalArgumentException();
        this.value = temp;
    }

    public CardTypes getType() {
        return type;
    }

    public void setType(String type) {
        this.type = CardTypes.valueOf(type);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCard() {
        return type + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return type == card.type && Objects.equals(value, card.value);
    }
}
