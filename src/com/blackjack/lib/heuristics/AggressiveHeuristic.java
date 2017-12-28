package com.blackjack.lib.heuristics;

import com.blackjack.lib.Player;

/**
 * This heuristic will always hit until the hand has 20 or 21.
 */
public class AggressiveHeuristic implements BlackJackHeuristic {
    public boolean isHitCondition(Player myHand, Player dealerHand) {
        return myHand.getValue() < 20;
    }
}
