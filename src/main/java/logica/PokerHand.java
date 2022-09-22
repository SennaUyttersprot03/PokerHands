package logica;

/**
 * PokerHands: PokerHand
 *
 * @author Quinten Conil
 * @version 22/09/2022
 */
public class PokerHand {
    private Card[] hand = new Card[5];

    public PokerHand(Card hand[]){
        if(hand.length > 5){
            throw new IllegalArgumentException("Hand is groter dan 5");
        }else if(hand.length < 5){
            throw new IllegalArgumentException("Hand is kleiner dan 5");
        }
    }

}
