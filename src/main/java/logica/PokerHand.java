package logica;
import Enum.CardTypes;

import java.util.ArrayList;


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


    public PokerHand(Card hand []){
        if (hand.length < 5){
            throw new IllegalArgumentException("Hand is kleiner dan 5");
        }else if(hand.length > 5){
            throw new IllegalArgumentException("Hand is groter dan 5");
        }
       this.hand = hand;
    }

    public String getCombinatie(){
        if ((hand[0].getCard() == "HA") && (hand[0].getCard() == "HK") && (hand[0].getCard() == "HQ") && (hand[0].getCard() == "HJ") && (hand[0].getCard() == "H10")){
            return "royal flush";
        }

        boolean cardZelfdeTekens = true;
        for (int i = 0; i < HANDGROTE; i++){
            if (hand[0].getType() != hand[i].getType()){
                cardZelfdeTekens = false;
            }
        }


    }
}
