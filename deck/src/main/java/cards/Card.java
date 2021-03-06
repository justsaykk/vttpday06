package cards;
// Chuk's solution

public class Card {
    public enum Suit { // enum is an implicit static. Just like constant
        Diamonds, Spade, Hearts, Clubs
    };

    // Card Names
    public static final String[] CARD_NAMES = {
            "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"
    };

    // Card values
    public static final int[] CARD_VALUE = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10
    };

    private final Suit suit;
    private final String name;
    private final Integer value;

    // Initialize cards
    public Card(Suit s, String n, int v) {
        suit = s;
        name = n;
        value = v;
    }

    public Suit getSuit() {
        return suit;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "%s, %s, %d".formatted(suit, name, value);
    }
}
