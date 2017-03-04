package com.blackjack.lib;

import com.blackjack.lib.heuristics.BlackJackHeuristic;

import java.util.ArrayList;

public class Player {
    // Cards in this player's hand:
    private ArrayList<Card> hand;
    private String name;
    private BlackJackHeuristic heuristic;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<Card>(0);
    }

    /**
     * Determines how this player will play the game.
     * @param heuristic
     */
    public void setHeuristic(BlackJackHeuristic heuristic) {
        this.heuristic = heuristic;
    }

    /**
     * Uses this player's playstyle/heuristic to dertermin whether they will
     * hit given the current state of the board.
     * @param dealerHand The dealer's hand as Player object.
     * @return True if the player is hitting
     */
    public boolean isHitting(Player dealerHand) {
        return heuristic.isHitCondition(this, dealerHand);
    }

    /**
     * Add a card to this player's hand
     * @param card Card to be added to the player's hand
     */
    public void addCard(Card card) {
        hand.add(card);
    }

    /**
     * Player discards his entire hand.
     */
    public void discardHand() {
        hand.clear();
    }

    public String toString() {
        return name + "'s hand: " + hand.toString() + " (" + getValue() + " total)";
    }

    /**
     * How many cards are in this player's hand.
     * @return int Number of cards in this player's hand.
     */
    public int numCards() {
        return hand.size();
    }

    /**
     * The upper value of this player's hand.
     * @return int The highest value of this player's hand.
     */
    public int getValue() {
        //TODO: Account for ACE card
        int totalValue = 0;
        for (Card card : hand) {
            totalValue += card.getValue().getValue();
        }
        return totalValue;
    }

    public String getName() {
        return name;
    }
}