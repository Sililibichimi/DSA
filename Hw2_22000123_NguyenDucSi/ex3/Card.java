package DSA.Hw2_22000123_NguyenDucSi.ex3;

public class Card implements Comparable {

    char rank;
    String suit;

    public Card(char rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public void setRank(char rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getRank() {
        if(this.rank <= '9') {
            return this.rank - '0';
        }
        else {
            switch(this.rank) {
                case 'T':
                    return 10;
                case 'J':
                    return 11;
                case 'Q':
                    return 12;
                case 'K':
                    return 13;
                case 'A':
                    return 14;
                default:
                    return 0;
            }
        }
    }

    public int getSuit() {
        switch (this.suit) {
            case "Spades":
                return 0;
            case "Clubs":
                return 1;
            case "Diamonds":
                return 2;
            case "Hearts":
                return 3;
            default:
                return 0;
        }
    }

    @Override
    public int compareTo(Object o) {
        Card c = (Card) o;

        if(this.getRank() == c.getRank()) {
            return this.getSuit() - c.getSuit();
        } else {
            return this.getRank() - c.getRank();
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + rank +
                '}';
    }


}
