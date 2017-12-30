package com.blackjack.test;

import com.blackjack.lib.Card;
import com.blackjack.lib.Player;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class PlayerTest {
    @Test
    public void testAddCard() {
        Player player = new Player("");
        player.addCard(new Card(Card.Suit.CLUBS, Card.Value.TWO));
        assertEquals(player.numCards(), 1);
        player.addCard(new Card(Card.Suit.CLUBS, Card.Value.TWO));
        assertEquals(player.numCards(), 2);
    }

    @Test
    public void testDiscardHand() {
        Player player = new Player("");
        player.addCard(new Card(Card.Suit.SPADES, Card.Value.THREE));
        player.addCard(new Card(Card.Suit.CLUBS, Card.Value.FOUR));
        player.discardHand();
        assertEquals(player.numCards(), 0);
    }

    @Test
    public void testGetValue() {
        Player player = new Player("");
        player.addCard(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));
        assertEquals(player.getValue(), 8);
        player.addCard(new Card(Card.Suit.HEARTS, Card.Value.TEN));
        assertEquals(player.getValue(), 18);
        player.addCard(new Card(Card.Suit.DIAMONDS, Card.Value.KING));
        assertEquals(player.getValue(), 28);
        player.addCard(new Card(Card.Suit.SPADES, Card.Value.ACE));
        assertEquals(player.getValue(), 39);
    }

    @Test
    public void testWins() {
        Player player = new Player("");
        player.addWin();
        player.addWin();
        assertEquals(player.getNumWins(), 2);
    }

    @Test
    public void testGetName() {
        Player player = new Player("test name");
        assertEquals(player.getName(), "test name");
    }

}