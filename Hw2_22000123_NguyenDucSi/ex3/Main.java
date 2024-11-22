package DSA.Hw2_22000123_NguyenDucSi.ex3;

public class Main {
    public static void main(String[] args) {

        DeckOfCards deck = new DeckOfCards();
        deck.shuffleDeck();
        System.out.println("Before sorting");
        deck.printDeck();

        System.out.println("____________________________________________________________________________________________________________");
        System.out.println("After sorting");
        deck.sortDeck();
        deck.printDeck();
    }
}
