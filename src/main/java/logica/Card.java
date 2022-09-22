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

    public Card(String type, String value) throws IllegalArgumentException {
        this.type = CardTypes.valueOf(type);
        this.value = value;
    }
    public Card(String card) throws IllegalArgumentException {
        this.type = CardTypes.valueOf("" + card.charAt(0));
        String temp = card.substring(1);
        if ("JQKA".contains(temp) ||
                (2 <= Integer.parseInt(temp)
                && Integer.parseInt(temp) <= 10)) {
            this.value = temp;
        } else throw new IllegalArgumentException("Should be between [2,10] or be J,Q,K or A");

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

    public String getCard(){
        return type + value;
    }
}
