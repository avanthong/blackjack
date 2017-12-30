package com.blackjack.test;

import com.blackjack.lib.Deck;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class DeckTest {
    /**
     * Utility method which deals every card in the deck.
     * Helpful in situations where testing with an empty deck is needed.
     * @param deck Deck class which will be completely dealt.
     */
    private void dealAllCards(Deck deck) {
        for (int i = 0; i < 52; i++) {
            deck.deal();
        }
    }

    @Test
    public void testIsDealt() {
        Deck deck = new Deck();
        assertEquals(deck.isDealt(), false);
        // Deal all the cards:
        dealAllCards(deck);
        assertEquals(deck.isDealt(), true);
        // Re-shuffle the deck, and verify it's not longer dealt:
        deck.shuffle();
        assertEquals(deck.isDealt(), false);
    }

    @Test
    public void testSize() {
        Deck deck = new Deck();
        assertEquals(deck.size(), 52);
        deck.deal();
        assertEquals(deck.size(), 51);
        deck.shuffle();
        assertEquals(deck.size(), 52);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void TestDealEmptyDeck() {
        Deck deck = new Deck();
        dealAllCards(deck);
        deck.deal();
    }
}