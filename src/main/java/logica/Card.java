package logica;
import Enum.CardTypes;

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

    public Card(String type, String value) {
        this.type = CardTypes.valueOf(type);
        this.value = value;
    }
    public Card(String card) {
        this.type = CardTypes.valueOf("" + card.charAt(0));
        this.value = card.substring(1);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return type == card.type && Objects.equals(value, card.value);
    }
}
