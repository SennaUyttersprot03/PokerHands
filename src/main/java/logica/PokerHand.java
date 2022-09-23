package logica;
import Enum.CardTypes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;


/**
 * PokerHands: PokerHand
 *
 * @author Quinten Conil
 * @version 22/09/2022
 */
public class PokerHand {
    private final int HANDGROTE = 5;
    private Card[] hand;
    private CardTypes[] kaartType = {CardTypes.C, CardTypes.D, CardTypes.H, CardTypes.S};
    private String[] kaartValue = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};



    public PokerHand(Card[] hand){
        if (hand.length < 5){
            throw new IllegalArgumentException("Hand is kleiner dan 5");
        } else if (hand.length > 5) {
            throw new IllegalArgumentException("Hand is groter dan 5");
        }

        if (!bevatDubbeleKaarten(hand)) {
            throw new IllegalArgumentException("Hand bevat dubbele kaarten");
        }
       this.hand = hand;
    }


    public String getScore() {
        if (alleTypesHetzelfde() && opeenvolgend().equals("High")) {
            return "Royal Flush";
        }
        if (alleTypesHetzelfde() && opeenvolgend().equals("True")) {
            return "Straight Flush";
        }
        if (alleTypesHetzelfde()) {
            return "Flush";
        }
        if (opeenvolgend().equals("True")) {
            return "Straight";
        }
        return "Geen speciale combinatie";
    }

    public String getCombinatie(){
        if ((hand[0].getCard() == "HA") && (hand[0].getCard() == "HK") && (hand[0].getCard() == "HQ") && (hand[0].getCard() == "HJ") && (hand[0].getCard() == "H10")){
            return "royal flush";
        }
        return "";
    }

    private boolean alleTypesHetzelfde(){
        boolean cardZelfdeTekens = true;
        for (int i = 0; i < HANDGROTE; i++){
            if (hand[0].getType() != hand[i].getType()){
                cardZelfdeTekens = false;
            }
        }
        return cardZelfdeTekens;
    }

    private String opeenvolgend() {
        ArrayList<Integer> valueArray = new ArrayList<>();
        for(Card card : this.hand) {
            String temp = card.value;
            valueArray.add(valueToInt(temp));
        }
        Collections.sort(valueArray);
        for (int i = 0; i < valueArray.size()-1; i++) {
            int diff = valueArray.get(i + 1) - valueArray.get(i);
            if (diff != 1 && !(diff == 9 && valueArray.get(i) == 5)) {
                return "False";
            }
        }
        return (valueArray.get(0) == 10 ? "High" : "True");
    }

    private int valueToInt(String value) {
        int intValue;
        switch (value) {
            case "J": intValue = 11;break;
            case "Q": intValue = 12;break;
            case "K": intValue = 13;break;
            case "A": intValue = 14;break;
            default: intValue = Integer.parseInt(value);
        }
        return intValue;
    }

    public boolean bevatDubbeleKaarten(Card[] hand) {
        for (int i = 0; i < hand.length - 1; i++) {
            Card temp = hand[i];

            for (int j = i + 1; j < hand.length - 2; j++) {
                if (temp.equals(hand[j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
