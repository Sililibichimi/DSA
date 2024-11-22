package DSA.Hw2_22000123_NguyenDucSi.ex3;

import java.util.Comparator;

public class Comparecard implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        Card c1 = (Card) o1;
        Card c2 = (Card) o2;

        if(c1.getSuit() == c2.getSuit()) {
            return c1.getRank() - c2.getRank();
        }
        else {
            return c1.getSuit() - c2.getSuit();
        }
    }

}
