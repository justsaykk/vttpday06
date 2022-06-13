package cards;
// Chuk's Solution

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import cards.Card.Suit;

public class Deck {
    private List<Card> cards = new LinkedList<>();

    public Deck() {
        // Call constructor with 1 deck to create
        this(1);
    }

    public Deck(int numDecks) {

        for (int d = 0; d < numDecks; d++) { // Create number of decks
            for (Suit s : Suit.values()) { // For each suit
                for (int i = 0; i < Card.CARD_NAMES.length; i++) {
                    Card card = new Card(s, Card.CARD_NAMES[i], Card.CARD_VALUE[i]);
                    cards.add(card);
                }
            }
        }
    }

    public void shuffle() {
        // Random rand = new Random(System.currentTimeMillis()); // Create random number
        // via a seed
        Random rand = new SecureRandom();
        for (int p = 0; p < cards.size(); p++) {
            Card srcCard = cards.get(p);
            int idx = rand.nextInt(0, cards.size());
            Card toSwap = cards.get(idx);
            cards.set(p, toSwap);
            cards.set(idx, srcCard);
        }
    }

    public Card take() {
        return cards.remove(0);
    }

    public List<Card> take(int num) {
        List<Card> cards = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            if (remaining() > 0) {
                cards.add(take());
            } else
                break;
        }
        return cards;
    }

    public int remaining() {
        return cards.size();
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
