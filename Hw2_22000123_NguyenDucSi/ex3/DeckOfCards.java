package DSA.Hw2_22000123_NguyenDucSi.ex3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {

    Card[] cards;

    public DeckOfCards() {
        cards = new Card[52];
        char[] ranks = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};

        int index = 0;
        for(char rank : ranks) {
            for(String suit : suits) {
                cards[index++] = new Card(rank, suit);
            }
        }
    }

    public void sortDeck() {
        Comparecard comparator = new Comparecard();
        Arrays.sort(cards, comparator);
    }

    public void shuffleDeck() {
        List<Card> cardList = Arrays.asList(cards);
        Collections.shuffle(cardList);
        cardList.toArray(cards);
    }

    public void printDeck() {
        for(Card card : cards) {
            System.out.println(card.rank + " of " + card.suit);
        }
    }
}
