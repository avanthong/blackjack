package com.blackjack.lib.heuristics;

import com.blackjack.lib.Player;

/**
 * Generic interface for various black jack heuristics.
 * Obviously, they need hte ability to play out a hand.
 */
public interface BlackJackHeuristic {
    /**
     * Determines whether the player should hit or stay.
     * @param myHand The current player's hand.
     * @param dealerHand The dealer's hand.
     * @return True if the player should hit. False to stay.
     */
    boolean isHitCondition(Player myHand, Player dealerHand);
}
