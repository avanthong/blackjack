package com.blackjack.test;

import com.blackjack.lib.Card;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CardTest {
    @Test
    public void testGetSuit() {
        Card card = new Card(Card.Suit.CLUBS, Card.Value.ACE);
        assertEquals(card.getSuit(), Card.Suit.CLUBS);
    }

    @Test
    public void testSetSuit() {
        Card card = new Card(Card.Suit.CLUBS, Card.Value.ACE);
        card.setSuit(Card.Suit.HEARTS);
        assertEquals(card.getSuit(), Card.Suit.HEARTS);
    }

    @Test
    public void testGetValue() {
        Card card = new Card(Card.Suit.CLUBS, Card.Value.ACE);
        assertEquals(card.getValue().getValue(), 11);
    }

    @Test
    public void testSetValue() {
        Card card = new Card(Card.Suit.CLUBS, Card.Value.ACE);
        card.setValue(Card.Value.FIVE);
        assertEquals(card.getValue().getValue(), 5);
    }
}