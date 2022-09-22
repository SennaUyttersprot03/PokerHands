package logica;
import Enum.CardTypes;

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
}
