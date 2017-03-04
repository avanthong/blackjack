package com.blackjack.lib.heuristics;

import com.blackjack.lib.Player;

/**
 * Mimics the strategy defined in "the book" of black jack playing.
 */
public class TheBookHeuristic implements BlackJackHeuristic {
    public boolean isHitCondition(Player myHand, Player dealerHand) {
        return ((dealerHand.getValue() >= 16 && myHand.getValue() < 17) ||
                myHand.getValue() <= 11);
    }
}
