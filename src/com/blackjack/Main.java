package com.blackjack;

import com.blackjack.lib.Card;
import com.blackjack.lib.Deck;
import com.blackjack.lib.Player;

public class Main {

    public static void main(String[] args) {
	    Card card = new Card(Card.Suit.HEARTS, 1);
	    System.out.println("First card is a: " + card);
	    card.setValue(12);
	    card.setSuit(Card.Suit.CLUBS);
        System.out.println("Card changed to: " + card);
        try {
            card.setValue(15);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("================");
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println("Dealing card: " + deck.deal());
        System.out.println("Dealing card: " + deck.deal());
        System.out.println("Re-shuffling . . .");
        deck.shuffle();
        System.out.println("Dealing card: " + deck.deal());

        System.out.println("================");
        Player p1 = new Player("Player 1");
        p1.addCard(deck.deal());
        System.out.println("P1 has cards: " + p1);
        p1.discardHand();
        System.out.println("P1 has cards: " + p1);
    }
}
