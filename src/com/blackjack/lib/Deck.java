package com.blackjack.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Deck {
    // All cards in this deck:
    private ArrayList<Card> cards;

    // Keep track of which card will be dealt next:
    private int currIndex;

    public Deck() {
        cards = new ArrayList<Card>(52);
        currIndex = 0;

        // Populate the deck with all 52 cards:
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                cards.add(new Card(suit, value));
            }
        }
    }

    /**
     * Determines whether or not the Deck still has any cards left to deal.
     * @return boolean True if no cards are left
     */
    public boolean isDealt() {
        return currIndex >= cards.size();
    }

    /**
     * The "size" of the deck -- how many undealt cards are left in the deck.
     * @return int Number of undealt cards left in the deck.
     */
    public int size() {
        return cards.size() - currIndex;
    }

    /**
     * Deal a card from the top of the deck.
     * @return Card The next card off the top of the deck
     */
    public Card deal() {
        if (isDealt())
            throw new IllegalArgumentException("No cards left to deal");
        currIndex++;
        return cards.get(currIndex-1);
    }

    /**
     * Shuffles the deck to start anew
     */
    public void shuffle() {
        currIndex = 0;
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
    }

    public String toString() {
        return cards.toString();
    }
}
